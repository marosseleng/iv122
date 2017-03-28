package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.*


fun main(args: Array<String>) {
    chaosGame(3, 1 / 2.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Trianle.png"))
    chaosGame(5, 1 / 3.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Pent.png"))
    chaosGame(5, 3.0 / 8.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Pent2.png"))
    chaosGame(6, 1 / 3.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Hex.png"))
    chaosGame(8, 1 / 3.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Oct.png"))
    chaosGame(8, 2 / 7.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Oct3.png"))
    chaosGame(8, 3 / 16.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Oct2.png"))
    chaosGame(3, 1 / 4.0, 1000, 2000, 1000000).writeTo(fileWithName(assignmentNo = 6, name = "Triangle2.png"))
}

fun generateRegularNPolygon(n: Int, radius: Int, center: Coordinates): List<Coordinates> {
    val degrees = 360.0 / n
    val result = mutableListOf<Coordinates>()
    n.timesRepeat { i ->
        val rads = Math.toRadians(degrees * (i - 1) + 90)
        val x = Math.cos(rads) * radius + center.x
        val y = Math.sin(rads) * radius + center.y
        result.add(Coordinates(x, y))
    }
    return result
}

fun chaosGame(n: Int, r: Double, skip: Int, imgSize: Int, iterations: Int): BufferedImage {
    val img = squareBitmapImage(imgSize)
    val radius = imgSize / 2 - 50
    val rand = Random()
    val vertices = generateRegularNPolygon(n, radius,Coordinates(imgSize / 2, imgSize / 2))
    var randPoint = Coordinates(rand.nextInt(imgSize), rand.nextInt(imgSize))
    vertices.forEach {
        drawSurrounding(it, img, Color.BLACK)
    }
    iterations.timesRepeat { i ->
        val targetVertex = vertices[rand.nextInt(vertices.size)]
        if (i > skip) {
            drawSurrounding(randPoint, img, Color.BLACK)
        }
        randPoint = (randPoint.vectorTo(targetVertex) * r) + targetVertex
    }
    return img
}