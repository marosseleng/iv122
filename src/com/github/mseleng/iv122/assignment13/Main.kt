package com.github.mseleng.iv122.assignment13

import com.github.mseleng.iv122.util.fileWithName

/**
 * @suppress
 */
fun run(path: String) {

    // A
    print("-> Squared maze (30x30)......")
    generateRectangularMaze(30, 30, 50).writeTo(fileWithName(path, 13, "square-1.svg"))
    print(" ✓ (assignment13/square-1.svg)\n==========\n")

    // B
    print("-> Triangular maze (40x40)......")
    triangularMazeByKruskal(40, 40, 50).writeTo(fileWithName(path, 13, "triangle-1.svg"))
    print(" ✓ (assignment13/triangle-1.svg)\n-> Iterations of the Kurskal's algorithm (20x20)")
    triangularMazeByKruskal(20, 20, 30, true) { fileWithName(path, 13, String.format("kruskal-iter-%03d.svg", it)) }
            .writeTo(fileWithName(path, 13, "triangle-2.svg"))
    println(" ✓ (assignment13/kruskal-iter-%03d.svg[0-399])")
}
