#!/bin/bash

rm main.jar
kotlinc src/*.kt -include-runtime -d main.jar

if [[ "$1" == "-e" ]]; then
  java -jar main.jar
fi
