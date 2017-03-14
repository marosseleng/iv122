package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.util.squareBitmapImage
import java.awt.Color
import java.awt.image.BufferedImage

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

interface PascalTriangleColorGenerator {
    fun next(): List<Color>
}

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