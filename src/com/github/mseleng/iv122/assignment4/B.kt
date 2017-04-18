package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.ParametricLine
import com.github.mseleng.iv122.util.squareBitmapImage
import com.github.mseleng.iv122.util.toParamLines
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * Creates and fills the polygon specified by the given points
 *
 * @param imgSize the size of the image
 * @param points the points defining the polygon
 * @return an image with the polygon
 */
fun polygon(imgSize: Int, vararg points: Coordinates): BufferedImage {
    val lines = points.toParamLines()
    val intersectionsMap = intersections(imgSize, lines)
    val img = squareBitmapImage(imgSize)
    for (y in 0 until img.height) {
        val intersectionsForY = intersectionsMap.getOrDefault(y, emptyList()).filter { !it.isOutOfRange(imgSize, imgSize) }
        for (x in 0 until img.width) {
            val coords = Coordinates(x, y)
            if (lines.any { coords.laysOnLineStrict(it, 0.1) }) {
                img.setRGB(x, y, Color.BLACK.rgb)
            } else {
                val usefulIntersections = intersectionsForY.filter { it.x > x }
                if (usefulIntersections.size % 2 == 0) {
                    img.setRGB(x, y, Color.WHITE.rgb)
                } else {
                    img.setRGB(x, y, Color.BLACK.rgb)
                }
            }
        }
    }
    return img
}

/**
 * Uses ray tracing to find intersections with the given lines
 *
 * The algorithm uses horizontal rays for ([height] - 1) rows
 *
 * @param height the number of rows to cover
 * @param lines the list of lines to find intersections with
 * @return the map, where the key is the number of row and the value is the list of interceptions on that line
 */
fun intersections(height: Int, lines: List<ParametricLine>): Map<Int, List<Coordinates>> {
    return (0 until height).asIterable()
            .associate { Pair(it, Coordinates(0, it)) } // create a Map<Int, Coordinates>
            .mapValues { ParametricLine(it.value, it.value.copy(x = (height - 1).toDouble())) } // create a line for each row
            .mapValues { entry -> lines.mapNotNull { entry.value.intersectionWith(it) }.minus(lines.map { it.first }) } // find intersections
}