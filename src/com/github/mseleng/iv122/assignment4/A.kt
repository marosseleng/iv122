package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage

fun main(args: Array<String>) {
    circleFull(500, 100).writeTo(fileWithName(assignmentNo = 4, name = "circle-full.png"))
    circleEmpty(500, 100).writeTo(fileWithName(assignmentNo = 4, name = "circle-empty.png"))
    circleEmpty(500, 240).writeTo(fileWithName(assignmentNo = 4, name = "circle-empty2.png"))
    println(Math.tan(Math.toRadians(45.0)))
//    circleParam(500, 100, 0.01).writeTo(fileWithName(assignmentNo = 4, name = "circle-param.png"))
    ellipse(500, 100, 1, 4).writeTo(fileWithName(assignmentNo = 4, name = "ellipse.png"))
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

fun circleParam(imgSize: Int, radius: Int, eps: Double): BufferedImage {
    val centerX = imgSize / 2
    val centerY = centerX
    return squareBitmapImage(imgSize).colorize { x, y ->
        for (angle in 1..360) {
            val rads = Math.toRadians(angle.toDouble())
            val paramX = centerX + radius.times(Math.cos(rads))
            val paramY = centerY + radius.times(Math.sin(rads))
            if (Math.abs(x-centerX).toDouble() <= paramX && Math.abs(y-centerY).toDouble() <= paramY) {
                Color.BLACK.rgb
            }
        }
        Color.WHITE.rgb
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

fun triangle(imgSize: Int, eps: Double = 0.01): BufferedImage {
    val centerX = imgSize / 2
    val centerY = imgSize - 1
    return squareBitmapImage(imgSize).colorize { x, y ->








        Color.BLACK.rgb
    }
}
