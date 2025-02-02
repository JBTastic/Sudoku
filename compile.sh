#!/bin/bash
kotlinc src/*.kt -include-runtime -d main.jar
echo "Compilation finished. Running program..."
java -jar main.jar