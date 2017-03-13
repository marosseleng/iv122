#! /bin/sh

rm -rf javadoc/* outputs/*
java -jar dokka-fatjar.jar src/ -output javadoc/ -module iv122 -format jekyll

cp out/artifacts/iv122/iv122.jar outputs/iv122.jar

java -jar outputs/iv122.jar > outputs/console-output.txt