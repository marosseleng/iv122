package com.github.mseleng.iv122.util

import java.awt.Color
import java.io.File

/**
 * The class representing the style of the SVG elements
 *
 * @param stroke the [Color] of the stroke
 * @param strokeWidth the width of the stroke
 * @param fill the [Color] of the fill
 * @constructor creates the [Style] with the given parameters
 */
data class Style(val stroke: Color? = null, val strokeWidth: Int? = null, val fill: Color? = null)

/**
 * The default style (black stroke and stroke width == 1)
 */
val defaultLineStyle = Style(Color.BLACK, 1, null)

/**
 * A typealias for the [Pair] of [Coordinates] representing the starting and the end point of a line in SVG
 */
typealias Line = Pair<Coordinates, Coordinates>

/**
 * An helper class for the work with the SVG images
 *
 * @param width the desired width of the SVG image (default 1000)
 * @param height the desired height of the SVG image (default 1000)
 * @constructor creates the SVG with the header
 */
class SVG(val width: Int = 1000, val height: Int = 1000) {

    /**
     * A constructor used for square-shaped SVGs
     *
     * @param size the size of the SVG image
     */
    constructor(size: Int) : this(size, size)

    val builder = StringBuilder()
    private var isFinalized = false

    init {
        builder.append(
                "<?xml version=\"1.0\"?>" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD util.SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-util.SVG-20010904/DTD/svg10.dtd\">" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"$height\" width=\"$width\" text-rendering=\"auto\" shape-rendering=\"auto\">")
    }

    /**
     * Adds the horizontal line
     *
     * @param y the y coordinate of the line's points
     * @param width the desired width of the line
     * @param style the desired style of the line (default: [defaultLineStyle])
     * @return this
     */
    fun horizontalLine(y: Int, width: Int, style: Style = defaultLineStyle): SVG {
        builder.append("<line x1=\"0\" y1=\"$y\" x2=\"$width\" y2=\"$y\" ${printStyle(style)}/>")
        return this
    }

    /**
     * Adds the vertical line
     *
     * @param x the x coordinate of the line's points
     * @param height the desired height of the line
     * @param style the desired style of the line (default: [defaultLineStyle])
     * @return this
     */
    fun verticalLine(x: Int, height: Int, style: Style = defaultLineStyle): SVG {
        builder.append("<line x1=\"$x\" y1=\"0\" x2=\"$x\" y2=\"$height\" ${printStyle(style)}/>")
        return this
    }

    /**
     * Adds a line
     *
     * @param line a [Line] to add
     * @return this
     */
    fun line(line: Line): SVG {
        return line(line.first.x, line.first.y, line.second.x, line.second.y)
    }

    /**
     * Adds a line
     *
     * @param start the starting point of the line
     * @param end the ending point of the line
     * @return this
     */
    fun line(start: Coordinates, end: Coordinates): SVG {
        return line(start.x, start.y, end.x, end.y)
    }

    /**
     * Adds a line
     *
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the end point
     * @param y2 the y-coordinate of the end point
     * @param style the desired style of the line (default: [defaultLineStyle])
     * @return this
     */
    fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: Style = defaultLineStyle): SVG {
        return line(x1.toDouble(), y1.toDouble(), x2.toDouble(), y2.toDouble(), style)
    }

    /**
     * Adds a line
     *
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the end point
     * @param y2 the y-coordinate of the end point
     * @param style the desired style of the line (default: [defaultLineStyle])
     * @return this
     */
    fun line(x1: Double, y1: Double, x2: Double, y2: Double, style: Style = defaultLineStyle): SVG {
        builder.append("<line x1=\"$x1\" y1=\"$y1\" x2=\"$x2\" y2=\"$y2\" ${printStyle(style)}/>")
        return this
    }

    /**
     * Adds multiple lines
     *
     * @param lines lines to add
     * @return this
     */
    fun lines(lines: Collection<Line>): SVG {
        for (line in lines) {
            line(line)
        }
        return this
    }

    /**
     * Adds a square
     *
     * @param x the x-coordinate of the top-left corner
     * @param y the y-coordinate of the top-left corner
     * @param size the desired size of a square
     * @param style the desired style of a square
     * @return this
     */
    fun square(x: Int, y: Int, size: Int, style: Style): SVG {
        return rect(x, y, size, size, style)
    }

    /**
     * Adds a rectangle
     *
     * @param x the x-coordinate of the top-left corner
     * @param y the y-coordinate of the top-left corner
     * @param width the desired width of a rectangle
     * @param height the desired height of a rectangle
     * @param style the desired style of a rectangle
     * @return this
     */
    fun rect(x: Int, y: Int, width: Int, height: Int, style: Style): SVG {
        builder.append("<rect x=\"$x\" y=\"$y\" width=\"$width\" height=\"$height\" ${printStyle(style)} />")
        return this
    }

    /**
     * Adds a circle
     *
     * @param cx the x-coordinate of the center
     * @param cy the y-coordinate of the center
     * @param r the desired radius of a circle
     * @param style the desired style of a circle
     * @return this
     */
    fun circle(cx: Int, cy: Int, r: Int, style: Style): SVG {
        builder.append("<circle cx=\"$cx\" cy=\"$cy\" r=\"$r\" ${printStyle(style)} />")
        return this
    }

    /**
     * Adds an ellipse
     *
     * @param cx the x-coordinate of the center
     * @param cy the y-coordinate of the center
     * @param rx the x-radius of an ellipse
     * @param ry the y-radius of an ellipse
     * @param style the desired style of an ellipse
     * @return this
     */
    fun ellipse(cx: Int, cy: Int, rx: Int, ry: Int, style: Style): SVG {
        builder.append("<ellipse cx=\"$cx\" cy=\"$cy\" rx=\"$rx\" ry=\"$ry\" ${printStyle(style)} />")
        return this
    }

    /**
     * Adds a polygon
     *
     * @param style the desired style of an ellipse
     * @param points (possibly multiple) points to add
     * @return this
     */
    fun polygon(style: Style, vararg points: Coordinates): SVG {
        builder.append("<polygon ${printPoints(points)} ${printStyle(style)} />")
        return this
    }

    /**
     * Adds a polyline
     *
     * @param style the desired style of an ellipse
     * @param points (possibly multiple) points to add
     * @return this
     */
    fun polyline(style: Style, vararg points: Coordinates): SVG {
        builder.append("<polyline ${printPoints(points)} ${printStyle(style)} />")
        return this
    }

    /**
     * Adds a footer
     */
    fun finalize(): SVG {
        builder.append("</svg>")
        isFinalized = true
        return this
    }

    /**
     * Writes the SVG data into the passed file
     *
     * @param file to save SVG data
     */
    fun writeTo(file: File) {
        if (!isFinalized) {
            finalize()
        }
        file.writeText(builder.toString())
    }

    private fun printStyle(style: Style?): String {
        return "style=" +
                "\"${printStrokeWidth(style?.strokeWidth)};" +
                "${printStroke(style?.stroke)};" +
                "${printFill(style?.fill)}\""
    }

    private fun printStroke(stroke: Color?): String {
        return if (stroke == null) {
            "stroke:none"
        } else {
            "stroke:rgb(${stroke.red},${stroke.green},${stroke.blue})"
        }
    }

    private fun printStrokeWidth(width: Int?): String {
        return if (width == null) {
            ""
        } else {
            "stroke-width:$width"
        }
    }

    private fun printFill(fill: Color?): String {
        return if (fill == null) {
            "fill:none"
        } else {
            "fill:rgb(${fill.red},${fill.green},${fill.blue})"
        }
    }

    private fun printPoints(points: Array<out Coordinates>): String {
        val sb = StringBuilder()
        if (points.isNotEmpty()) {
            sb.append("points=\" ")
            for (x in points) {
                sb.append("${x.x},${x.y} ")
            }
            sb.append("\"")
        }
        return sb.toString()
    }
}