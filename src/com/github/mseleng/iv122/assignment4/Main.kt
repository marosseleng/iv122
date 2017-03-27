package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color

/**
 * @suppress
 */
fun run(path: String) {
    //A
    val imgSize = 1000
    val radius = 450
    println("-> Input: Image size: $imgSize; Radius (circle, spiral and ellipse): $radius")
    print("-> Full circle (general eq.)......")
    circleFull(imgSize, radius).writeTo(fileWithName(path, 4, "circle-full.png"))
    print(" ✓ (assignment4/circle-full.png)\n-> Empty circle (general eq.)......")
    circleEmpty(imgSize, radius).writeTo(fileWithName(path, 4, "circle-empty.png"))
    print(" ✓ (assignment4/circle-empty.png)\n-> Empty circle (param.)......")
    circleParam(imgSize, radius).writeTo(fileWithName(path, 4, "circle-param.png"))
    print(" ✓ (assignment4/circle-param.png)\n-> Spiral (param.)......")
    spiralParam(imgSize, radius, 10.0, 3 / 10.0).writeTo(fileWithName(path, 4, "spiral.png"))
    print(" ✓ (assignment4/spiral.png)\n-> Equal-sized triangle......")
    triangle(imgSize, Color.ORANGE, Color.BLACK, Color.MAGENTA).writeTo(fileWithName(path, 4, "triangle.png"))
    print(" ✓ (assignment4/triangle.png)\n-> Ellipse......")
    ellipse(imgSize, radius, 1, 4).writeTo(fileWithName(path, 4, "ellipse.png"))
    print(" ✓ (assignment3/ellipse.svg)\n==========\n")

    //B

    //C
}