#! /bin/sh

java -jar dokka-fatjar.jar src/ -output docs/

cp out/artifacts/iv122/iv122.jar outputs/iv122.jar