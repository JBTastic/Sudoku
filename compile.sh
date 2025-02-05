#!/bin/bash
rm main.jar
kotlinc src/*.kt -include-runtime -d main.jar
java -jar main.jar
