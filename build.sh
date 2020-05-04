#!/usr/bin/env bash
set -ex

curl -L https://repo1.maven.org/maven2/it/unimi/dsi/fastutil/8.3.1/fastutil-8.3.1.jar -o "out/fastutil.jar"
./find-deps.sh minimize "out/fastutil.jar" dependencies.txt