package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.drawSurrounding
import com.github.mseleng.iv122.util.squareBitmapImage
import com.github.mseleng.iv122.util.timesRepeat
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.*

/**
 * Run the chaos game within the [n]-sided regular polygon
 *
 * @param n the number of edges of a polygon
 * @param ratio the ratio at which to choose the next point
 * @param skip the amount of points to skip from the beginning
 * @param imgSize the size of the image
 * @param iterations the number of iterations (default = 1 milion)
 * @return an image containing the result
 */
fun chaosGame(n: Int, ratio: Double, skip: Int, imgSize: Int, iterations: Int = 1_000_000): BufferedImage {
    val img = squareBitmapImage(imgSize)
    val radius = imgSize / 2 - 50
    val rand = Random()
    val vertices = generateRegularNPolygon(n, radius.toDouble(), Coordinates(imgSize / 2, imgSize / 2))
    var randPoint = Coordinates(rand.nextInt(imgSize), rand.nextInt(imgSize))
    vertices.forEach {
        drawSurrounding(it, img, Color.BLACK)
    }
    iterations.timesRepeat { i ->
        val targetVertex = vertices[rand.nextInt(vertices.size)]
        if (i > skip) {
            drawSurrounding(randPoint, img, Color.BLACK)
        }
        randPoint = (randPoint.vectorTo(targetVertex) * ratio) + targetVertex
    }
    return img
}

/**
 * Creates the [n] sided regular polygon within the circle with the given [center] and [radius]
 */
fun generateRegularNPolygon(n: Int, radius: Double, center: Coordinates): List<Coordinates> {
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
