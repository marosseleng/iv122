package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.util.squareBitmapImage
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * Creates a Pascal's triangle that visualizes the numbers from the given generator
 *
 * @param n the height of a triangle
 * @param generator the colors generator
 * @return and image containing the Pascal's triangle
 */
fun pascal(n: Int, generator: PascalTriangleColorGenerator): BufferedImage {
    var offset = n.minus(1)
    var colors = generator.next()
    var y = 0
    return squareBitmapImage(2.times(n)) {
        while (offset >= 0) {
            var index = 0
            for (c in colors) {
                setRGB(offset + 2 * index, y, c.rgb)
                setRGB(offset + 2 * index + 1, y, c.rgb)
                index = index.inc()
            }
            if (y.rem(2) == 1) {
                colors = generator.next()
                offset = offset.dec()
            }
            y = y.inc()
        }
    }
}

/**
 * An interface providing simple method for the Pascal's triangle color retrieval
 */
interface PascalTriangleColorGenerator {
    /**
     * Returns a [List] of [Color]s to be put to the next line
     */
    fun next(): List<Color>
}

/**
 * A generator that supplies colors based on current line's modulus
 *
 * @param mod the desired modulus base
 * @param colors (possibly mutliple) [Color]s
 * @constructor
 * @property mod the desired modulus base
 * @property colors (possibly mutliple) [Color]s
 */
class ModuloColorGenerator(val mod: Int, vararg val colors: Color) : PascalTriangleColorGenerator {
    private var list = listOf<Int>()

    override fun next(): List<Color> {
        if (list.isEmpty()) {
            list = listOf(1)
        } else if (list.size == 1) {
            list = listOf(1, 1)
        } else {
            var previous = 0
            val lst = mutableListOf<Int>()
            for (current in list) {
                lst.add(previous.plus(current).rem(mod))
                previous = current
            }
            lst.add(1)
            list = lst
        }
        return list.map { it -> colors[it % colors.size] }
    }
}

/**
 * A generator that supplies colors based on the parity of the numbers in the current line
 *
 * @param evenColor a color to apply on the even numbers
 * @param oddColor a color to apply on the odd numbers
 * @constructor
 * @property evenColor a color to apply on the even numbers
 * @property oddColor a color to apply on the odd numbers
 */
class EvenOddColorGenerator(val evenColor: Color, val oddColor: Color) : PascalTriangleColorGenerator {
    private var list = listOf<Int>()

    override fun next(): List<Color> {
        if (list.isEmpty()) {
            list = listOf(1)
        } else if (list.size == 1) {
            list = listOf(1, 1)
        } else {
            var previous = 0
            val lst = mutableListOf<Int>()
            for (current in list) {
                lst.add(previous.plus(current).rem(2))
                previous = current
            }
            lst.add(1)
            list = lst
        }
        return list.map { it ->
            if (it.rem(2) == 0) {
                evenColor
            } else {
                oddColor
            }
        }
    }
}