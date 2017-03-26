package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage

fun main(args: Array<String>) {
//    circleFull(500, 100).writeTo(fileWithName(assignmentNo = 4, name = "circle-full.png"))
//    circleEmpty(500, 100).writeTo(fileWithName(assignmentNo = 4, name = "circle-empty.png"))
//    circleEmpty(500, 240).writeTo(fileWithName(assignmentNo = 4, name = "circle-empty2.png"))
//    circleParam(5000, 2490).writeTo(fileWithName(assignmentNo = 4, name = "circle-param.png"))
    spiralParam(2000, 999, 20.0, 2 / 10.0).writeTo(fileWithName(assignmentNo = 4, name = "spiral-param.png"))
//    ellipse(500, 100, 1, 4).writeTo(fileWithName(assignmentNo = 4, name = "ellipse.png"))
//    otherEllipse(500, 100, 1, 4, 2).writeTo(fileWithName(assignmentNo = 4, name = "other-ellipse.png"))
}

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
        val angleModThreeSixty = (angle.toInt() % 120) + 1 // values 0..359
        val clr = angleModThreeSixty * 255 / 360//angleModThreeSixty % 255
        val c = Color(clr, 255 - clr, (255 + clr) / 2)
        drawSurrounding(imgSize, imgSize, Coordinates(x, y), img, c)
        angle += 0.005
    } while (currentRadius < radius.toDouble())
    return img
}

fun circleParam(imgSize: Int, radius: Int): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    val img = squareBitmapImage(imgSize)
    var angle = 0.0
    while (angle <= 360.0) {
        val rads = Math.toRadians(angle)
        val x = centerX + radius.times(Math.cos(rads))
        val y = centerY + radius.times(Math.sin(rads))
        drawSurrounding(imgSize, imgSize, Coordinates(x, y), img, Color.BLACK)
        angle += 0.01
    }
    return img
}

fun drawSurrounding(imgWitdth: Int, imgHeight: Int, point: Coordinates, img: BufferedImage, color: Color) {
    for (x in (point.x.toInt() - 1)..(point.x.toInt() + 1)) {
        ((point.y.toInt() - 1)..(point.y.toInt() + 1))
                .filterNot { Coordinates(x, it).isOutOfRange(imgWitdth, imgHeight) }
                .forEach { img.setRGB(x, it, color.rgb) }
    }
}

fun triangle(imgSize: Int, eps: Double = 0.01): BufferedImage {
    val centerX = imgSize / 2
    val centerY = imgSize - 1
    return squareBitmapImage(imgSize).colorize { x, y ->








        Color.BLACK.rgb
    }
}
