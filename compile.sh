#!/bin/bash
kotlinc src/*.kt -include-runtime -d main.jar && echo "COMPILATION SUCCEDED"
java -jar main.jar