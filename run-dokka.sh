#! /bin/bash

#remove everything
rm -rf javadoc/* outputs/*

#generate the documentation from javadoc using dokka
java -jar dokka-fatjar.jar src/ -output javadoc/ -module iv122 -format jekyll

#copy the artifact
cp out/artifacts/iv122/iv122.jar outputs/iv122.jar

#run the jar and save the console output
touch outputs/console-output.md
echo "## The console output" >> docs/console-output.md
echo "[Home](../)" >> docs/console-output.md
echo >> docs/console-output.md
echo '```' >> docs/console-output.md
java -jar outputs/iv122.jar >> outputs/console-output.md
echo '```' >> docs/console-output.md