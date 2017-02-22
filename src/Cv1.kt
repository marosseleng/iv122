/**
 * Created by mseleng on 2/21/17.
 */

import java.awt.Color
import java.io.File
import java.lang.Math.abs

fun main(args: Array<String>) {
    val n = args[0].toIntOrNull() ?: 1
//    collatz(mutableN)
//    collatzWithMax(mutableN)
//    squareBitmapImage(500, 500)
//            .colorize { _, _ -> Color.CYAN.rgb }
//            .writeToJPG(File("obrazok.jpg"))
    val size = 10000
    val blackR = Color.BLACK.red
    val blackG = Color.BLACK.green
    val blackB = Color.BLACK.blue
    val whiteR = Color.WHITE.red
    val whiteG = Color.WHITE.green
    val whiteB = Color.WHITE.blue
    val topLeft = Color.BLACK
    val topRight = Color.RED
    val bottomLeft = Color.BLUE
    val bottomRight = Color.MAGENTA
    bitmapImage(size, size)
            .colorize { x, y ->
                fwgcfcII(x, y, size, size, topLeft, topRight, bottomLeft, bottomRight)
            }
            .writeToJPG(File("gradient.jpg"))
//    squareBitmapImage(size) //FIXME should not be divided by 2 here?
//            .colorize { x, y ->
//                topToBottomLinearGradientColorForCoordinates(x, y, size, size, bottomRight, bottomLeft)
//            }
//            .writeToJPG(File("LR_gradient.jpg"))
}

fun leftToRightLinearGradientColorForCoordinates(x: Int, y: Int, width: Int, height: Int, left: Color, right: Color): Int {
    return fwgcfcII(x, y, width, height, left, right, left, right)
}

fun topToBottomLinearGradientColorForCoordinates(x: Int, y: Int, width: Int, height: Int, top: Color, bottom: Color): Int {
    return fwgcfcII(x, y, width, height, top, top, bottom, bottom)
}

fun fourWayGradientColorForCoordinates(x: Int, y: Int, width: Int, height: Int, topLeft: Color, topRight: Color, bottomLeft: Color, bottomRight: Color): Int {
    val leftRightRatio = x.toDouble().div(width)
    val topBottomRatio = y.toDouble().div(height)

    val topLeftCoef = minOf((1 - leftRightRatio), (1 - topBottomRatio))
    val topRightCoef = minOf(leftRightRatio, (1 - topBottomRatio))
    val bottomLeftCoef = minOf((1 - leftRightRatio), topBottomRatio)
    val bottomRightCoef = minOf(leftRightRatio, topBottomRatio)

    val newR = topLeft.red * topLeftCoef + topRight.red * topRightCoef + bottomLeft.red * bottomLeftCoef + bottomRight.red * bottomRightCoef
    val newG = topLeft.green * topLeftCoef + topRight.green * topRightCoef + bottomLeft.green * bottomLeftCoef + bottomRight.green * bottomRightCoef
    val newB = topLeft.blue * topLeftCoef + topRight.blue * topRightCoef + bottomLeft.blue * bottomLeftCoef + bottomRight.blue * bottomRightCoef

    return Color(newR.toInt(), newG.toInt(), newB.toInt()).rgb
}

fun fwgcfcII(x: Int, y: Int, width: Int, height: Int, topLeft: Color, topRight: Color, bottomLeft: Color, bottomRight: Color): Int {
    val leftRightRatio = x.toDouble().div(width)
    val topBottomRatio = y.toDouble().div(height)

    abs(topLeft.red - topRight.red)
    abs(topLeft.red - bottomLeft.red)
    abs(bottomLeft.red - bottomRight.red)
    abs(bottomRight.red - topRight.red)

    val newRed =
            ((leftRightRatio * abs(topLeft.red - topRight.red)) +
            (leftRightRatio * abs(bottomLeft.red - bottomRight.red)) +
            (topBottomRatio * abs(topRight.red - bottomRight.red)) +
            (topBottomRatio * abs(topLeft.red - bottomLeft.red))) / 2

    val newGreen =
            ((leftRightRatio * abs(topLeft.green - topRight.green)) +
                    (leftRightRatio * abs(bottomLeft.green - bottomRight.green)) +
                    (topBottomRatio * abs(topRight.green - bottomRight.green)) +
                    (topBottomRatio * abs(topLeft.green - bottomLeft.green))) / 2

    val newBlue =
            ((leftRightRatio * abs(topLeft.blue - topRight.blue)) +
                    (leftRightRatio * abs(bottomLeft.blue - bottomRight.blue)) +
                    (topBottomRatio * abs(topRight.blue - bottomRight.blue)) +
                    (topBottomRatio * abs(topLeft.blue - bottomLeft.blue))) / 2

    return Color(newRed.toInt(), newGreen.toInt(), newBlue.toInt()).rgb
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
