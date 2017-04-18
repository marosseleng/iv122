package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.Coordinates
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
    print(" ✓ (assignment4/ellipse.svg)\n-> Sloped ellipse......")
    detailedEllipse(imgSize, 1000, 400, 30.0).writeTo(fileWithName(path, 4, "sloped-ellipse.png"))
    print(" ✓ (assignment4/sloped-ellipse.svg)\n==========\n")

    //B
    print("-> Filled polygon (triangle)......")
    polygon(500,
            Coordinates(249, 10),
            Coordinates(0, 490),
            Coordinates(490, 400))
            .writeTo(fileWithName(path, 4, "filled-polygon-1.png"))
    print(" ✓ (assignment4/filled-polygon-1.png)\n-> Another filled polygon......")
    polygon(500,
            Coordinates(50, 10),
            Coordinates(300, 209),
            Coordinates(449, 150),
            Coordinates(499, 399),
            Coordinates(0, 499))
            .writeTo(fileWithName(path, 4, "filled-polygon-2.png"))
    print(" ✓ (assignment4/filled-polygon-2.png)\n==========\n")
    //C

    //D
    print("-> Hide and seek 1......")
    hideAndSeek1().writeTo(fileWithName(path, 4, "skryvacka-1.png"))
    print(" ✓ (assignment4/skryvacka-1.png)\n-> Hide and seek 2......")
    hideAndSeek2().writeTo(fileWithName(path, 4, "skryvacka-2.png"))
    print(" ✓ (assignment4/skryvacka-2.png)\n-> Hide and seek 3......")
    hideAndSeek3().writeTo(fileWithName(path, 4, "skryvacka-3.png"))
    println(" ✓ (assignment4/skryvacka-3.png)")
}