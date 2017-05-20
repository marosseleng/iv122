#! /bin/bash

CONSOLE_OUTPUT=docs/console-output.md
PROGRAM_OUTPUT=iv122_outputs
JAVADOC_DIR=javadoc
ASSIGNMENT7_DIR=${PROGRAM_OUTPUT}/assignment7
ASSIGNMENT11_DIR=${PROGRAM_OUTPUT}/assignment11
ASSIGNMENT13_DIR=${PROGRAM_OUTPUT}/assignment13

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

cd ${ASSIGNMENT7_DIR}
#using `convert` from ImageMagick library
convert 'top%03d.png[1-120]' top.gif
convert 'mini%03d.png[1-25]' mini.gif
convert 'stem%03d.png[1-15]' stem.gif
convert 'Feigenbaum%03d.png[1-30]' Feigenbaum.gif
convert 'Misiurewicz%03d.png[1-50]' Misiurewicz.gif

mkdir gifs
mv *.gif gifs/

rm Feigenbaum*
rm mini*
rm stem*
rm top*
rm Misiurewicz*

cd ../..
cd ${ASSIGNMENT11_DIR}
#using `convert` from ImageMagick library
convert 'linreg-gd-file%02d.png[1-50]' gd-file.gif
convert 'linreg-gd-synthetic-2-%02d.png[1-70]' gd-synthetic.gif
convert 'linreg-gd-synthetic-2-bad-%02d.png[1-70]' gd-synthetic-bad.gif
convert 'clusters-file%02d.png[0-10]' clusters-file.gif
convert 'clusters-synthetic%02d.png[0-30]' clusters-synthetic.gif

mkdir gifs
mv *.gif gifs/

rm linreg-gd*
rm clusters*

cd ../..
cd ${ASSIGNMENT13_DIR}
#using `convert` from ImageMagick library
convert 'kruskal-iter-%03d.svg[0-500]' kruskal.gif

mkdir gifs
mv *.gif gifs/

rm kruskal-iter*