package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage

fun main(args: Array<String>) {

}

/**
 * Creates a full circle using the general equation
 *
 * @param imgSize the size of the image
 * @param circleRadius the radius of the circle
 * @return an image containing the circle
 */
fun circleFull(imgSize: Int, circleRadius: Int): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    return squareBitmapImage(imgSize).colorize { x, y ->
        if ((x - centerX).square() + (y - centerY).square() <= circleRadius.square()) {
            Color.BLACK.rgb
        } else {
            Color.WHITE.rgb
        }
    }
}

/**
 * Creates an empty circle using the general equation
 *
 * @param imgSize the size of the image
 * @param circleRadius the radius of the circle
 * @param eps the difference to accept while painting points (default = 0.01)
 * @return an image containing the circle
 */
fun circleEmpty(imgSize: Int, circleRadius: Int, eps: Double = 0.01): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    return squareBitmapImage(imgSize).colorize { x, y ->
        if (((x - centerX).square() + (y - centerY).square()).div(circleRadius.square().toDouble()) in (1 - eps)..(1 + eps)) {
            Color.BLACK.rgb
        } else {
            Color.WHITE.rgb
        }
    }
}

/**
 * Create an empty regular ellipse
 *
 * @param imgSize the size of the image
 * @param radius the radius of the ellipse
 * @param a the coefficient to multiply x by
 * @param b the coefficient to multiply y by
 * @param eps the difference to accept while paining points (default = 0.01)
 * @return an image containing the ellipse
 */
fun ellipse(imgSize: Int, radius: Int, a: Int, b: Int, eps: Double = 0.01): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    return squareBitmapImage(imgSize).colorize { x, y ->
        if (((x - centerX).square().times(a) + (y - centerY).square().times(b)).div(radius.square().toDouble()) in (1 - eps)..(1 + eps)) {
            Color.BLACK.rgb
        } else {
            Color.WHITE.rgb
        }
    }
}

/**
 * Creates a spiral
 *
 * @param imgSize the size of the image
 * @param radius the outer (maximum) radius of the spiral
 * @param offset describes how far from the center will the first colored point be
 * @param density describes how fast (depending on the increasing angle) will the spiral grow (the smaller number, the denser will the spiral be)
 * @return an image with the spiral
 */
fun spiralParam(imgSize: Int, radius: Int, offset: Double, density: Double): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    val img = squareBitmapImage(imgSize)
    var angle = 0.0
    do {
        val currentRadius = offset + density * angle
        val rads = Math.toRadians(angle)
        val x = centerX + currentRadius.times(Math.cos(rads))
        val y = centerY + currentRadius.times(Math.sin(rads))
        val patternAngleWidth = (angle.toInt() % 120) + 1 // 120 can be replaced by whatever; it just affects, where the color pattern starts
        val clr = patternAngleWidth * 255 / 360
        val c = Color(clr, 255 - clr, (255 + clr) / 2)
        drawSurrounding(Coordinates(x, y), img, c)
        angle += 0.005
    } while (currentRadius < radius.toDouble())
    return img
}

/**
 * Creates an empty circle using the parametric definition
 *
 * @param imgSize the size of the image
 * @param radius the radius of the circle
 * @return the image containing the circle
 */
fun circleParam(imgSize: Int, radius: Int): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    val img = squareBitmapImage(imgSize)
    var angle = 0.0
    while (angle <= 360.0) {
        val rads = Math.toRadians(angle)
        val x = centerX + radius.times(Math.cos(rads))
        val y = centerY + radius.times(Math.sin(rads))
        drawSurrounding(Coordinates(x, y), img, Color.BLACK)
        angle += 0.01
    }
    return img
}

/**
 * Creates the triangle with all edges with the same length
 *
 * @param imgSize the size of the resulting image
 * @param topColor the color of the top vertex
 * @param leftColor the color of the left vertex
 * @param rightColor the color of the right vertex
 * @return an image containing the colored triangle
 */
fun triangle(imgSize: Int, topColor: Color, leftColor: Color, rightColor: Color): BufferedImage {
    val centerX = imgSize / 2
    val centerY = imgSize - 1
    val edge = imgSize - 2
    val height = edge * Math.sin(Math.toRadians(60.0))
    val top = Coordinates(centerX, centerY - height.toInt())
    val left = Coordinates(centerX - edge / 2, centerY)
    val right = Coordinates(centerX + edge / 2, centerY)

    fun isBelowRightEdge(coordinates: Coordinates): Boolean {
        return 0 >= ((top.x * right.y - top.y * right.x)/(top.x - right.x)) + ((right.y - top.y) / (right.x - top.x)) * coordinates.x - coordinates.y
    }

    fun isBelowLeftEdge(coordinates: Coordinates): Boolean {
        return 0 >= ((top.x * left.y - top.y * left.x)/(top.x - left.x)) + ((left.y - top.y) / (left.x - top.x)) * coordinates.x - coordinates.y
    }
    return squareBitmapImage(imgSize).colorize { x, y ->
        val coordinates = Coordinates(x, y)
        if (isBelowLeftEdge(coordinates) && isBelowRightEdge(coordinates) && y <= centerY) {
            /* computing the relative distances of this point to the vertices */
            val topRatio = 1.0 - (coordinates.euclideanDistanceFrom(top) / edge) // between 0 and 1
            val leftRatio = 1.0 - (coordinates.euclideanDistanceFrom(left) / edge) // between 0 and 1
            val rightRatio = 1.0 - (coordinates.euclideanDistanceFrom(right) / edge) // between 0 and 1
            /* the components of the resulting color */
            val topComponent = topColor * topRatio
            val leftComponent = leftColor * leftRatio
            val rightComponent = rightColor * rightRatio
            /* resulting color combined of its components */
            val newRed = (topComponent.red + leftComponent.red + rightComponent.red).limitTo(255)
            val newGreen = (topComponent.green + leftComponent.green + rightComponent.green).limitTo(255)
            val newBlue = (topComponent.blue + leftComponent.blue + rightComponent.blue).limitTo(255)
            Color(newRed, newGreen, newBlue).rgb
        } else {
            Color.WHITE.rgb
        }
    }
}
