package com.github.mseleng.iv122.util

import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO

/**
 * This file contains utility functions to work with the bitmap graphics (using the BufferedImage)
 *
 * @author Maroš Šeleng
 */

/**
 * Creates an instance of [BufferedImage] of the square shape
 *
 * **An instance uses the RGB coloring**
 *
 * @param size the size of the desired image
 * @param init a block of code to execute on a newly created [BufferedImage]
 * @return an instance of [BufferedImage]
 * @see [bitmapImage]
 */
fun squareBitmapImage(size: Int, init: BufferedImage.() -> Unit = {}): BufferedImage {
    return bitmapImage(size, size, init)
}

/**
 * An helper function that creates an instance of [BufferedImage] for further edit.
 *
 * **An instance uses the RGB coloring**
 *
 * @param width the width of the target image
 * @param height the height of the target image
 * @param init a block of code to execute on a newly created [BufferedImage]
 * @return an instance of [BufferedImage]
 */
fun bitmapImage(width: Int, height: Int, init: BufferedImage.() -> Unit = {}): BufferedImage {
    val img = BufferedImage(width, height, TYPE_INT_RGB)
    img.init()
    return img
}

/**
 * An helper function that colorizes this [BufferedImage]
 *
 * @param colorFunction a function that takes two parameters (x, y) and returns and [Int] representing the RGB color
 * @return this
 */
fun BufferedImage.colorize(colorFunction: (x: Int, y: Int) -> Int): BufferedImage {
    for (x in 0 until width) {
        for (y in 0 until height) {
            setRGB(x, y, colorFunction(x, y))
        }
    }
    return this
}

/**
 * An extension function that writes this [BufferedImage] instance to a specified [File]
 *
 * @param file the target file
 * @return true iff save was successful, false otherwise
 * @see [writeToFile]
 */
fun BufferedImage.writeTo(file: File): Boolean {
    return writeToFile(file.extension, file)
}

/**
 * An fileFormat function that writes this [BufferedImage] instance to a specified [File] in the specified format
 *
 * @param fileFormat the target file's format
 * @param file the target file
 * @return true iff save was successful, false otherwise
 */
fun BufferedImage.writeToFile(fileFormat: String, file: File): Boolean {
    return ImageIO.write(this, fileFormat, file)
}
