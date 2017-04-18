package com.github.mseleng.iv122.util

import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO

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
    return bitmapImage(size, size, init = init)
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
fun bitmapImage(width: Int, height: Int, backgroundColor: Color = Color.WHITE, init: BufferedImage.() -> Unit = {}): BufferedImage {
    val img = BufferedImage(width, height, TYPE_INT_RGB)
    img.colorize { _, _ -> backgroundColor.rgb }
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

fun readFile(name: String): BufferedImage {
    return ImageIO.read(File(name))
}

/**
 * Fills the surroundings (3x3 grid) of the given point in the given image
 *
 * @param point the point, whose surroundings to paint
 * @param img the image
 * @param color the color to use to fill the surroundings
 */
fun drawSurrounding(point: Coordinates, img: BufferedImage, color: Color) {
    for (x in (point.x.toInt() - 1)..(point.x.toInt() + 1)) {
        ((point.y.toInt() - 1)..(point.y.toInt() + 1))
                .filterNot { Coordinates(x, it).isOutOfRange(img.width, img.height) }
                .forEach { img.setRGB(x, it, color.rgb) }
    }
}

/**
 * Multiplies this color by the given [ratio].
 *
 * Ratio must be a number between [0.0, 1.0] inclusive
 *
 * @param ratio the ratio to multiply this color's parts by
 * @return the new color
 */
operator fun Color.times(ratio: Double): Color {
    val newRed = (red * ratio).toInt()
    val newGreen = (green * ratio).toInt()
    val newBlue = (blue * ratio).toInt()
    return Color(newRed, newGreen, newBlue)
}

/**
 * Returns the list of [ParametricLine]s from this list of Coordinates.
 *
 * Suitable for defining polygons
 *
 * @receiver the list of coordinates, which represent the edges of the polygon
 * @return the list of lines describing the polygon
 */
fun Array<out Coordinates>.toParamLines(): List<ParametricLine> {
    var last = last()
    return map {
        val line = ParametricLine(last, it)
        last = it
        line
    }
}

/**
 * Returns the inverted color
 */
fun Color.inverse() = Color(255 - red, 255 - green, 255 - blue)
