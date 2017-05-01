package com.github.mseleng.iv122.assignment8

import com.github.mseleng.iv122.assignment6.generateRegularNPolygon
import com.github.mseleng.iv122.util.*

/**
 * Represents a pattern within the MRCM iteration
 */
class Wrapper(val lines: List<Line>)

/**
 * An alias for the iterative function on Wrappers
 */
typealias WrapperApplication = (Wrapper) -> List<Wrapper>

/**
 * Class representing MRCM
 *
 * @param initialWrapper
 * @param offset the offset, where to move the resulting image
 * @param application the iterative function to apply
 */
class MRCM(initialWrapper: Wrapper, val offset: Coordinates, val application: WrapperApplication) {
    var current = listOf(initialWrapper)

    fun apply(n: Int): List<Line> {
        n.timesRepeat {
            current = current.flatMap(application)
        }
        return current.flatMap(Wrapper::lines).offsetTo(offset)
    }
}

/**
 * @suppress
 */
fun twinChristmasTreeMRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), translation(0.0, initialSize / 2)).applyOn(it.lines))
        val second = Wrapper(combine(rotation(-90.0), scaling(0.5, 0.5), translation(initialSize / 2, -initialSize / 2)).applyOn(it.lines))
        val third = Wrapper(combine(rotation(90.0), scaling(0.5, 0.5), translation(-initialSize / 2, -initialSize / 2)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun dragonMRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val ratio = 23 / 40.0
    val a = (initialSize / 2) - ((initialSize * ratio) / 2)
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(rotation(-90.0), scaling(ratio, ratio), translation(initialSize / 4, 0.0)).applyOn(it.lines))
        val second = Wrapper(combine(rotation(-90.0), scaling(ratio, ratio), translation(-(initialSize / 2) * (2 / 8.0), a)).applyOn(it.lines))
        val third = Wrapper(combine(rotation(-90.0), scaling(ratio, ratio), translation(-(initialSize / 2) * (2 / 8.0), -a)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun originalSierpinskiMRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val height = Math.sqrt(3 * Math.pow(initialSize, 2.0) / 4)
    val points = sameSizedTriangle(height * 2 / 3)
    val triangle = points.mapIndexed { index, coordinates -> Line(coordinates, points[(index + 1) % points.count()]) }
    val mrcm = MRCM(Wrapper(triangle), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), translation(Coordinates(-initialSize / 4, -4 * height / 24))).applyOn(it.lines))
        val second = Wrapper(combine(scaling(0.5, 0.5), translation(Coordinates(initialSize / 4, -4 * height / 24))).applyOn(it.lines))
        val third = Wrapper(combine(scaling(0.5, 0.5), translation(Coordinates(0.0, 8 * height / 24))).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun sierpAlt1MRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), translation(-initialSize / 4, -initialSize / 4)).applyOn(it.lines))
        val second = Wrapper(combine(scaling(0.5, 0.5), translation(-initialSize / 4, initialSize / 4)).applyOn(it.lines))
        val third = Wrapper(combine(scaling(0.5, 0.5), translation(initialSize / 4, -initialSize / 4)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun sierpAlt2MRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), translation(-initialSize / 4, -initialSize / 4)).applyOn(it.lines))
        val second = Wrapper(combine(scaling(0.5, 0.5), rotation(-90.0), translation(-initialSize / 4, initialSize / 4)).applyOn(it.lines))
        val third = Wrapper(combine(scaling(0.5, 0.5), rotation(90.0), translation(initialSize / 4, -initialSize / 4)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun sierpAlt3MRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), rotation(180.0), translation(-initialSize / 4, -initialSize / 4)).applyOn(it.lines))
        val second = Wrapper(combine(scaling(0.5, 0.5), rotation(90.0), translation(-initialSize / 4, initialSize / 4)).applyOn(it.lines))
        val third = Wrapper(combine(scaling(0.5, 0.5), rotation(-90.0), translation(initialSize / 4, -initialSize / 4)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}

/**
 * @suppress
 */
fun sierpAlt4MRCM(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        val first = Wrapper(combine(scaling(0.5, 0.5), translation(-initialSize / 4, -initialSize / 4)).applyOn(it.lines))
        val second = Wrapper(combine(scaling(0.5, 0.5), rotation(180.0), translation(-initialSize / 4, initialSize / 4)).applyOn(it.lines))
        val third = Wrapper(combine(scaling(0.5, 0.5), rotation(180.0), translation(initialSize / 4, -initialSize / 4)).applyOn(it.lines))

        listOf(first, second, third)
    }
    return mrcm.apply(n)
}
/*
fun star(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val transformations: List<Transformation> = listOf(
            arrayOf(
                    Triple(0.255,   0.0, 0.3726),
                    Triple(  0.0, 0.255, 0.6714),
                    Triple(  0.0,   0.0,    1.0)),
            arrayOf(
                    Triple(0.255,   0.0, 0.1146),
                    Triple(  0.0, 0.255, 0.2232),
                    Triple(  0.0,   0.0,    1.0)),
            arrayOf(
                    Triple(0.255,   0.0, 0.6306),
                    Triple(  0.0, 0.255, 0.2232),
                    Triple(  0.0,   0.0,    1.0)),
            arrayOf(
                    Triple(0.370, -0.642,  0.6356),
                    Triple(0.642,  0.370, -0.0061),
                    Triple(  0.0,    0.0,     1.0)))
    val mrcm = MRCM(Wrapper(square(initialSize)), offset) {
        transformations.map { transformation -> Wrapper(transformation.applyOn(it.lines)) }
    }
    return mrcm.apply(n)
}

fun fern(initialSize: Double, offset: Coordinates, n: Int): List<Line> {
    val transformations: List<Transformation> = listOf(
            arrayOf(
                    Triple( 0.849, 0.037, 0.075),
                    Triple(-0.037, 0.849, 0.183),
                    Triple(   0.0,   0.0,   1.0)),
            arrayOf(
                    Triple(0.197, -0.226,   0.4),
                    Triple(0.226,  0.197, 0.049),
                    Triple(  0.0,   0.0,    1.0)),
            arrayOf(
                    Triple(-0.15, 0.283, 0.575),
                    Triple( 0.26, 0.237, 0.084),
                    Triple(  0.0,   0.0,   1.0)),
            arrayOf(
                    Triple(0.0,  0.0, 0.5),
                    Triple(0.0, 0.16, 0.0),
                    Triple(0.0,  0.0, 1.0)))
    val mrcm = MRCM(Wrapper(square(1.0)), offset) {
        transformations.map { transformation -> Wrapper(transformation.applyOn(it.lines)) }
    }
    return mrcm.apply(n)
}*/

private fun sameSizedTriangle(radius: Double) = generateRegularNPolygon(3, radius, Coordinates(0, 0))
