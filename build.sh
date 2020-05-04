#!/usr/bin/env bash

curl -L https://repo1.maven.org/maven2/it/unimi/dsi/fastutil/8.3.1/fastutil-8.3.1.jar -o fastutil
./find-deps.sh minimize ~/.m2/repository/it/unimi/dsi/fastutil/8.3.1/fastutil-8.3.1.jar dependencies.txt