# []()My portfolio for the IV122 class @ FI MU Brno

There is a jar archive inside the `iv122_outputs` directory of the `gh-pages` branch. That jar includes all the dependencies needed.

## &larr; Download the current JAR here

#### [](#usage)Usage: 
```bash
    
java -jar path-to/iv122.jar [path-to-existing-output-dir]
    
```
If the `<path-to-existing-output-dir>` is not specified, the program will create a directory named 'iv122_outputs' in the current directory

##### [](#output)The output of the above command can be found [here](docs/console-output.md)

### [](#assignments)The list of assignments (in Slovak):
  1. [Warm-up](docs/warm-up.md)
  2. [Numbers](docs/numbers.md)
  3. [Vector graphics](docs/vector-graphics.md)
  4. [Bitmap graphics](docs/bitmap-graphics.md)
  5. [Geometric algorithms](docs/geometric-algorithms.md)
  6. [Fractals (chaos)](docs/fractals-chaos.md)
  7. [Fractals (complex numbers)](docs/fractals-complex.md)
  8. [Linear algebra and 2D transformations](docs/linear-algebra.md)
  9. ===
  10. [Probability](docs/probability.md)
  
  
#### What is not implemented?
  + 3.D some own fractals created using the Turtle graphics
  + 4.C optical effects: I started implementing the chessboard-like effect, but after some time I dropped it. I got the main idea of switching the colors whenever some intersection occurs, but I din not finish it.
  + 5: Convex hull and the triangulation
  + 8: Bernsley fern and snowflake (reasons writter in assigment's own page)


#### What am I proud for?
  + The jar file available for download, that allows anyone to generate the images themselves (this was not a part of the assignment)
  + The [`Turtle`](https://github.com/mseleng/iv122/blob/master/src/com/github/mseleng/iv122/util/Turtle.kt) class that simply integrates also the L-systems
  + [`L-system`](https://github.com/mseleng/iv122/blob/master/src/com/github/mseleng/iv122/util/LSystem.kt) implementation and experiments (change the angles)
  + Complex-numbers-based fractals (simplicity of the interface for the creating fractals, parallel implementation, coloring, self-similarity demonstrating GIFs)
  + Implementation of the linear transformations
  
  
##### [](#reference)The class (and functions) reference can be found [here](javadoc/iv122/index.md)