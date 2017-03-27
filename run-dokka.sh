#! /bin/bash

CONSOLE_OUTPUT=docs/console-output.md
PROGRAM_OUTPUT=iv122_outputs

#remove everything
rm -rf javadoc/* outputs/*
rm ${CONSOLE_OUTPUT} &> /dev/null

#generate the documentation from javadoc using dokka
java -jar dokka-fatjar.jar src/ -output javadoc/ -module iv122 -format jekyll

#copy the artifact
rm -rf ${PROGRAM_OUTPUT} &> /dev/null
mkdir ${PROGRAM_OUTPUT}
cp out/artifacts/iv122/iv122.jar ${PROGRAM_OUTPUT}/iv122.jar

#run the jar and save the console output
touch ${CONSOLE_OUTPUT}
echo "## The console output" >> ${CONSOLE_OUTPUT}
echo "[Home](../)" >> ${CONSOLE_OUTPUT}
echo >> ${CONSOLE_OUTPUT}
echo '```' >> ${CONSOLE_OUTPUT}
java -jar iv122_outputs/iv122.jar | tee ${CONSOLE_OUTPUT}
echo '```' >> ${CONSOLE_OUTPUT}