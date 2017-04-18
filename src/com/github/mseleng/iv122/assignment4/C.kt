package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage

//fun main(args: Array<String>) {
//    chessBoard(1000, 50, 72, 237, 430).writeTo(fileWithName(assignmentNo = 4, name = "chessboard.png"))
//}

/*
fun chessBoard(imgSize: Int, fieldSize: Int, vararg radii: Int): BufferedImage {
    val img = squareBitmapImage(imgSize)
    val centerX = imgSize / 2
    val centerY = centerX
    val centerCoordinates = Coordinates(centerX, centerY)
    var firstRowColor = Color.WHITE
    for (x in 0 until imgSize) {
        if (x % fieldSize == 0) {
            firstRowColor = firstRowColor.inverse()
        }
        // TODO FIND BETTER ALGORITHM!!!!
        // filter only blabla caused by circle
        // rozdelim na pocetKruhov*2 a vezmem kolko potrebujem
        // TODO RECURSIVE!!
        val intersections = (0 until imgSize).asIterable().filter { y -> radii.any { Coordinates(x, y).laysOnCircle(centerCoordinates, it) } }
        val intersectionsForX = intersections.filterIndexed { index, y ->
            if (index == 0 || index == intersections.lastIndex) {
                false
            } else if (intersections[index + 1] - y > 1) {
                true
            } else y - intersections.getOrElse(index - 1, { y }) > 1
        }.toMutableList()

        if (intersectionsForX.isEmpty() && intersections.isNotEmpty()) {
            // adding first circle
            val index = intersections.lastIndex / 2
            intersectionsForX.add(intersections[0])
            intersectionsForX.add(intersections[intersections.lastIndex])
        }

        var yColor = firstRowColor
        for (y in 0 until imgSize) {
            if (y % fieldSize == 0) {
                yColor = yColor.inverse()
            } else if (y in intersectionsForX) {
                yColor = yColor.inverse()
            }
            img.setRGB(x, y, yColor.rgb)
        }
    }
    return img
}

fun Coordinates.laysOnCircle(center: Coordinates, radius: Int, eps: Double = 0.01) =
        ((x - center.x).square() + (y - center.y).square()) / (radius.square().toDouble()) in (1 - eps)..(1 + eps)

*/