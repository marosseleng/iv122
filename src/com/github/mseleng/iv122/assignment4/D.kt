package com.github.mseleng.iv122.assignment4

import com.github.mseleng.iv122.util.bitmapImage
import com.github.mseleng.iv122.util.colorize
import com.github.mseleng.iv122.util.readImageFile
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * The word "OREL" is hidden in pixels, that contain any blue part of the color. The rest of the picture's pixel does not contain any blue
 *
 * @return an image with the word OREL
 */
fun hideAndSeek1(): BufferedImage {
    val img = readImageFile("inputs/assignment4/skryvacka1.png")
    for (x in 0 until img.width) {
        for (y in 0 until img.height) {
            val color = Color(img.getRGB(x, y))
            if (color.blue > 0) {
                img.setRGB(x, y, Color.WHITE.rgb)
            }
        }
    }
    return img
}

/**
 * The word "KOZA" can be seen when we highlight trasitions between colors that are not smooth, eg. the neighbor pixel's colors differ by more than 1
 *
 * @return an image containing the highlighted word KOZA
 */
fun hideAndSeek2(): BufferedImage {
    val img = readImageFile("inputs/assignment4/skryvacka2.png")
    for (x in 0 until img.width) {
        var previousColor = Color(img.getRGB(x, 0))
        for (y in 0 until img.height) {
            val currentColor = Color(img.getRGB(x, y))
            if (Math.abs(previousColor.red - currentColor.red) <= 1 ||
                    Math.abs(previousColor.green - currentColor.green) <= 1 ||
                    Math.abs(previousColor.blue - currentColor.blue) <= 1) {
                img.setRGB(x, y, Color.BLACK.rgb)
            }
            previousColor = currentColor
        }
    }
    return img
}

/**
 * The word "slon" was hidden in this image. It was deciphered using the XOR operation with the matrix.
 * The matrix looks like a chessboard, so that no two pixels with the same color share an edge
 *
 * @return a Pair of images; first contains the cipher matrix and the second contains an image with word slon
 */
fun hideAndSeek3(): Pair<BufferedImage, BufferedImage> {
    val img = readImageFile("inputs/assignment4/skryvacka3.png")
    val cipherMatrix = mutableMapOf<Pair<Int, Int>, Boolean>()
    val imageMatrix = mutableMapOf<Pair<Int, Int>, Boolean>()
    // firstly we extract color information from the input img; BLACK is true
    // we create out cipher matrix (chessboard-like)
    for (x in 0 until img.width) {
        for (y in 0 until img.height) {
            cipherMatrix[Pair(x, y)] = (x + y) % 2 == 0
            imageMatrix[Pair(x, y)] = Color(img.getRGB(x, y)) == Color.BLACK
        }
    }

    img.colorize { x, y ->
        val cipher = cipherMatrix.getOrDefault(Pair(x, y), false)
        val image = imageMatrix.getOrDefault(Pair(x, y), false)
        if (image.xor(cipher)) {
            Color.BLACK.rgb
        } else {
            Color.WHITE.rgb
        }
    }
    return Pair(bitmapImage(img.width, img.height).colorize { x, y ->
        if (cipherMatrix.getOrDefault(Pair(x, y), false)) {
            Color.BLACK.rgb
        } else {
            Color.WHITE.rgb
        }
    }, img)
}
