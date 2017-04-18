package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo

fun run(path: String) {

    //A
    val imgSize = 1000
    val skip = 250
    println("-> Input: Image size: $imgSize; Number of points to skip: $skip")
    print("-> Sierpinski triangle (Chaos game; 1:2)......")
    chaosGame(3, 1 / 2.0, skip, imgSize).writeTo(fileWithName(path, 6, "sierpinski-triangle.png"))
    print(" ✓ (assignment6/sierpinski-triangle.png)\n-> Sierpinski triangle 2 (Chaos game; 1:4)......")
    chaosGame(3, 1 / 4.0, skip, imgSize).writeTo(fileWithName(path, 6, "sierpinski-triangle-2.png"))
    print(" ✓ (assignment6/sierpinski-triangle-2.png)\n-> Pentagon (Chaos game; 1:3)......")
    chaosGame(5, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "pentagon.png"))
    print(" ✓ (assignment6/pentagon.png)\n-> Pentagon 2 (Chaos game; 3:8)......")
    chaosGame(5, 3.0 / 8.0, skip, imgSize).writeTo(fileWithName(path, 6, "pentagon-2.png"))
    print(" ✓ (assignment6/pentagon-2.png)\n-> Hexagon (Chaos game; 1:3)......")
    chaosGame(6, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "hexagon.png"))
    print(" ✓ (assignment6/hexagon.png)\n-> Octagon (Chaos game; 1:3)......")
    chaosGame(8, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon.png"))
    print(" ✓ (assignment6/octagon.png)\n-> Octagon 2 (Chaos game; 3:16)......")
    chaosGame(8, 3 / 16.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon-2.png"))
    print(" ✓ (assignment6/octagon-2.png)\n-> Octagon 3 (Chaos game; 2:7)......")
    chaosGame(8, 2 / 7.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon-3.png"))
    print(" ✓ (assignment6/octagon-3.png)\n==========\n")

    //B
    
    //C
}