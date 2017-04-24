package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.bitmapImage
import com.github.mseleng.iv122.util.timesRepeat
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * Function that generates (zoomed) feigenbaum bifurcation diagram
 *
 * @param width the width of the image
 * @param height the height of the image
 * @param rRange horizontal axis range (a Pair of Doubles)
 * @param xRange vertical axis range (a Pair of Doubles)
 * @return an image containing the bifurcation diagram
 */
fun feigenbaum(width: Int, height: Int, rRange: Pair<Double, Double>, xRange: Pair<Double, Double>): BufferedImage {
    val img = bitmapImage(width, height)
    val wStep = (rRange.second - rRange.first) / (width-1)
    val hStep = (xRange.second - xRange.first) / (height-1)

    for (rX in 0..img.width - 1) {
        var x = 0.01
        val r = rX * wStep + rRange.first
        100.timesRepeat {
            x *= 4 * r * (1 - x)
        }
        100.timesRepeat {
            x *= 4 * r * (1 - x)
            if (x in xRange.first..xRange.second) {
                val y = Math.round(height - 1 - (x-xRange.first)/hStep).toInt()
                img.setRGB(rX, y, Color.BLACK.rgb)
            }
        }
    }

    return img
}
