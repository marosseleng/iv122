package com.github.mseleng.iv122.assignment5

import com.github.mseleng.iv122.util.fileWithName

/**
 * @suppress
 */
fun run(path: String) {

    //A
    val imgSize = 500
    val numOfLines = 25
    val lineLength = 220
    println("-> Input: Image size: $imgSize; Number of lines: $numOfLines; Line length: $lineLength")
    print("-> Random lines and their intersections (highlighted)......")
    linesAndIntersections(500, 25, 220, true).writeTo(fileWithName(path, 5, "lines.svg"))
    print(" ✓ (assignment5/lines.svg)\n-> Random lines and their intersections (not highlighted)......")
    linesAndIntersections(500, 25, 220).writeTo(fileWithName(path, 5, "lines-2.svg"))
    print(" ✓ (assignment5/lines-2.svg)\n==========\n")

    //B

    //C
}