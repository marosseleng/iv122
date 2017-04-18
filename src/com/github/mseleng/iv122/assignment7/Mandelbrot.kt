package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.Complex
import com.github.mseleng.iv122.util.bitmapImage
import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color
import java.awt.image.BufferedImage

fun mandelbrot(): BufferedImage {
    val scale = 4000
    val width = 3 * scale + 1
    val height = 2 * scale + 1

    val img = bitmapImage(width, height)
    for (x in 0 until width) {
        for (y in 0 until height) {
            val c = Complex((x - (2.0 * scale)) / scale, (scale.toDouble() - y) / scale)
            val iterated = iterate(c)
            if (iterated.re != Double.NaN && iterated.im != Double.NaN && iterated.abs() < 2.0) {
                img.setRGB(x, y, Color.BLACK.rgb)
            }
        }
    }

    return img
}

/**
 * Performs 30 iterations
 */
private fun iterate(c: Complex): Complex {
    var current = Complex(0, 0)
    for (i in 1..40) {
        current = (current * current) + c
    }
    return current
}