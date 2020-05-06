#!/usr/bin/env bash
set -ex

# echo $JAVA_HOME=/Library/Java/JavaVirtualMachines/amazon-corretto-8.jdk/Contents/Home
# java 8 is required, jdeps from jdk 13 produces output in a different format

IFS=$'\n\t'

fastutil_regex='it\.unimi\.dsi\.fastutil\..*'

jar_path="$(realpath "$1")"
if [ ! -f "$jar_path" ]; then
  echo "No file at \"$jar_path\""
  exit 1
fi

class_list_path="$(realpath "$2")"
if [ ! -f "$class_list_path" ]; then
  echo "No file at \"$class_list_path\""
  exit 1
fi

dest_path="${jar_path%\.jar}-min.jar"
unlink "$dest_path" || true

echo "Resolving transitive dependencies"

class_paths=$(grep '.class$' "$class_list_path")
if [ -z "$class_paths" ]; then
  echo "No classes found in $class_list_path - make sure they are proper paths to .class files"
  exit 1
fi

class_list=${class_paths//.class/}
class_list=${class_list//\//.}

# shellcheck disable=SC2086
transitive_dependencies=$(jdeps -recursive -regex "$fastutil_regex" -verbose:class -cp "$jar_path" ${class_list} | awk '/      -> / { gsub(/\./, "/", $2) ".class"; print $2 ".class" }')

# shellcheck disable=SC2086
depList=$(printf '%s\n' $class_paths $transitive_dependencies | sort | uniq)

echo "$depList" > out/deps.txt

echo "Unpacking jar from $jar_path"

rm -rf out/tmp
mkdir -p out/tmp

# shellcheck disable=SC2046
unzip -q "$jar_path" $(printf '%s\n' "$depList") -d out/tmp

cd "out/tmp"
echo "Creating minimized jar at $dest_path"
zip -9 -q -r "$dest_path" "it" "META-INF" .