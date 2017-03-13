##Repository with sources for the IV122 class @ FI MU Brno

Currently the docs pages are in the development. 

~~As there is no jar archive built yet, one does need to download 2 external dependencies and pack them to the project. The dependencies are:~~

  ~~+ jcommon-1.0.24~~
  
  ~~+ jfreechart-1.0.19~~
  
~~Both of the dependencies could be found at mvnrepository.~~

###I am using the Kotlin programming language, ~~so you may need to download and add it as dependency as well.~~

There is a jar archive inside the `outputs` directory of the `gh-pages` branch. That jar includes all the dependencies needed.

####Usage: 
```bash
    
java -jar outputs/iv122.jar <path-to-existent-output-dir>
    
```

#####The console output of the previous command can be found [here](outputs/console-output.txt)

SEE DOCS [HERE](javadoc/iv122/index.md)