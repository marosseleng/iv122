/**
 * Created by mseleng on 2/21/17.
 */

import org.jfree.graphics2d.svg.SVGGraphics2D
import java.awt.Color

fun main(args: Array<String>) {
//    collatz(mutableN)
//    collatzWithMax(mutableN)
    val size = 5000
//    squareBitmapImage(size)
//            .colorize { x, y ->
//                fourWayGradient(x, y, size, size, Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA)
//            }
//            .writeTo(fileWithName("gradient.png"))
    val svg = SVGGraphics2D(size, size)
    svg.paint = Color.CYAN
    svg.fillRect(0, 0, 100, 100)
    svg.paint = Color.YELLOW
    svg.fillRect(100, 100, 200, 200)
    svg.writeTo(svgFileWithName("cyanFile"))
}

fun fourWayGradient(x: Int, y: Int, width: Int, height: Int, topLeft: Color, topRight: Color, bottomLeft: Color, bottomRight: Color): Int {
    val newRed = bilinearInterpolation(x, y, width, height, topLeft.red, topRight.red, bottomLeft.red, bottomRight.red)
    val newGreen = bilinearInterpolation(x, y, width, height, topLeft.green, topRight.green, bottomLeft.green, bottomRight.green)
    val newBlue = bilinearInterpolation(x, y, width, height, topLeft.blue, topRight.blue, bottomLeft.blue, bottomRight.blue)

    return Color(newRed.toInt(), newGreen.toInt(), newBlue.toInt()).rgb
}

/**
 * Computes the value of the "point" defined by its coordinates ([x], [y]) using the bilinear interpolation:
 *
 *  tl        q     tr
 *  +- - - - + - - -+
 *  |        |
 *  |          p    |
 * y+        +
 *  |               |
 *  |        |
 *  |               |
 *  |        |r
 *  +--------+------+
 *  bl       x      br
 *
 * This function uses the [linearInterpolation] function three times:
 *   1. computes the value q by interpolating the values [tl] and [tr]
 *   2. computes the value r by interpolating the values [bl] and [br]
 *   3. computes the result value p by interpolating the values q and r
 *
 * @param x the horizontal part of target point's coordinates
 * @param y the vertical part of target point's coordinates
 * @param width the width of the 2D grid
 * @param height the height of the 2D grid
 * @param tl the top-left value
 * @param tr the top-right value
 * @param bl the bottom-left value
 * @param br the bottom-right value
 * @return an interpolated value of the point with coordinates ([x], [y])
 */
fun bilinearInterpolation(x: Int, y: Int, width: Int, height: Int, tl: Int, tr: Int, bl: Int, br: Int): Double {
    return linearInterpolation(
            y,
            height,
            linearInterpolation(x, width, tl, tr),
            linearInterpolation(x, width, bl, br))
}

/**
 * Computes the value on the [x]-th position using the linear interpolation
 *
 * This function just calls the overloaded one (with the *Value parameters of type Double)
 *
 * @param x the position whose value we want to compute
 * @param width the width of the interval
 * @param firstValue the start value
 * @param secondValue the target value
 * @return an interpolated value of [x]
 */
fun linearInterpolation(x: Int, width: Int, firstValue: Int, secondValue: Int): Double {
    return linearInterpolation(x, width, firstValue.toDouble(), secondValue.toDouble())
}

/**
 * Computes the value on the [x]-th position using the linear interpolation:
 *
 * firstValue              secondValue
 *     |-------------+----------|
 *                   x
 *
 * @param x the position whose value we want to compute
 * @param width the width of the interval
 * @param firstValue the start value
 * @param secondValue the target value
 * @return an interpolated value of [x]
 */
fun linearInterpolation(x: Int, width: Int, firstValue: Double, secondValue: Double): Double {
    val ratio = fraction(x, width)
    return (1 - ratio) * firstValue + ratio * secondValue
}

fun fraction(part: Int, whole: Int): Double {
    return part.toDouble().div(whole)
}

fun collatz(n: Int) {
    for (number in 1..n) {
        var mutableNumber = number
        var steps = 1
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            steps++
        }
        print("$steps,")
    }
}

fun collatzWithMax(n: Int) {
    for (number in 1..n) {
        var mutableNumber = number
        var max = mutableNumber
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            max = maxOf(mutableNumber, max)
        }
        print("$max,")
    }
}
