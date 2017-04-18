#! /bin/bash

CONSOLE_OUTPUT=docs/console-output.md
PROGRAM_OUTPUT=iv122_outputs
JAVADOC_DIR=javadoc

#remove everything
rm -rf ${JAVADOC_DIR} ${PROGRAM_OUTPUT} ${CONSOLE_OUTPUT} &> /dev/null

#generate the documentation from javadoc using dokka
java -jar dokka-fatjar.jar src/ -output ${JAVADOC_DIR} -module iv122 -format jekyll

#copy the artifact
mkdir ${PROGRAM_OUTPUT}
cp out/artifacts/iv122/iv122.jar ${PROGRAM_OUTPUT}/iv122.jar

#run the jar and save the console output
touch ${CONSOLE_OUTPUT}
echo "## The console output" >> ${CONSOLE_OUTPUT}
echo "[Home](../)" >> ${CONSOLE_OUTPUT}
echo >> ${CONSOLE_OUTPUT}
echo '```' >> ${CONSOLE_OUTPUT}
java -jar ${PROGRAM_OUTPUT}/iv122.jar >> ${CONSOLE_OUTPUT}
echo '```' >> ${CONSOLE_OUTPUT}