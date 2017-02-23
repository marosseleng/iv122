import java.awt.Color

fun main(args: Array<String>) {
    printFourWayGradient(2500, Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA)
    printStar(28, 50)
    printInsideOutStar(28, 50)
}

fun printFourWayGradient(size: Int, topLeft: Color, topRight: Color, bottomLeft: Color, bottomRight: Color, fileName: String = "gradient.png") {
    squareBitmapImage(size)
            .colorize { x, y ->
                colorForCoordinates(x, y, size, size, topLeft, topRight, bottomLeft, bottomRight)
            }
            .writeTo(fileWithName(fileName))
}

/**
 * Computes the color in the 4-way gradient in 2D grid using the bilinear interpolation
 *
 * The resulting color consists of the R-G-B values, each of which was computed using the separate interpolation
 *
 * @param x the horizontal part of target point's coordinates
 * @param y the vertical part of target point's coordinates
 * @param width the width of the 2D grid
 * @param height the height of the 2D grid
 * @param topLeft the top-left value
 * @param topRight the top-right value
 * @param bottomLeft the bottom-left value
 * @param bottomRight the bottom-right value
 * @return an interpolated color of the pixel with coordinates ([x], [y])
 * @see bilinearInterpolation
 */
fun colorForCoordinates(x: Int, y: Int, width: Int, height: Int, topLeft: Color, topRight: Color, bottomLeft: Color, bottomRight: Color): Int {
    return Color(
            bilinearInterpolation(x, y, width, height, topLeft.red, topRight.red, bottomLeft.red, bottomRight.red).toInt(),
            bilinearInterpolation(x, y, width, height, topLeft.green, topRight.green, bottomLeft.green, bottomRight.green).toInt(),
            bilinearInterpolation(x, y, width, height, topLeft.blue, topRight.blue, bottomLeft.blue, bottomRight.blue).toInt()).rgb
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
            linearInterpolation(x, width, tl.toDouble(), tr.toDouble()),
            linearInterpolation(x, width, bl.toDouble(), br.toDouble()))
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

/**
 * Prints the "tangent" star. The result image can be seen in the file 'outputs/star.png'
 *
 * @param steps the number of lines of the half of the horizontal/vertical center line (the size of the result file is (2*[steps]*[stepWidth])
 * @param stepWidth the size of the gap between each step (how far from each other the points are)
 * @param lineStyle the style of the line. Default: `Style(stroke = Color.BLACK, strokeWidth = 1)`
 * @param fileName the name of the result file WITHOUT '.svg'
 */
fun printStar(steps: Int, stepWidth: Int, lineStyle: Style = Style(stroke = Color.BLACK, strokeWidth = 1), fileName: String = "star") {
    val size = steps.times(2).times(stepWidth)
    val star = SVG(size)
            .horizontalFullWidthLine(size.div(2), lineStyle)
            .verticalFullHeightLine(size.div(2), lineStyle)
    for (x1 in 0..size.div(2) step stepWidth) {
        val x2 = size.minus(x1)
        val y1 = (size.div(2).minus(x1.plus(stepWidth)))
        val y2 = (size.div(2).plus(x1.plus(stepWidth)))
        star
                .line(x1, size.div(2), size.div(2), y1, lineStyle)
                .line(x1, size.div(2), size.div(2), y2, lineStyle)
                .line(x2, size.div(2), size.div(2), y1, lineStyle)
                .line(x2, size.div(2), size.div(2), y2, lineStyle)
    }
    star.writeTo(svgFileWithName(fileName))
}

/**
 * Prints the "inside-out" star. The result image can be seen in the file 'outputs/weird-star.png'
 *
 * @param steps the number of lines per frame edge (how many starting points are on the edge) (the size of the result file is ([steps]*[stepWidth])
 * @param stepWidth the size of the gap between each step (how far from each other the points are)
 * @param lineStyle the style of the line. Default: `Style(stroke = Color.BLACK, strokeWidth = 1)`
 * @param fileName the name of the result file WITHOUT '.svg'
 */
fun printInsideOutStar(steps: Int, stepWidth: Int, lineStyle: Style = Style(stroke = Color.BLACK, strokeWidth = 1), fileName: String = "weird-star") {
    val size = steps.times(stepWidth)
    val star = SVG(size)
    for (x1 in 0..size step stepWidth) {
        val x2 = size.minus(x1)
        val y1 = x2
        val y2 = x1
        star
                .line(x1, 0, 0, y1, lineStyle)
                .line(x2, size, 0, y1, lineStyle)
                .line(x1, 0, size, y2, lineStyle)
                .line(x2, size, size, y2, lineStyle)
    }
    star.writeTo(svgFileWithName(fileName))
}