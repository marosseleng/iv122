package com.github.mseleng.iv122.util

import com.github.mseleng.iv122.assignment3.toPlainString
import java.awt.Color
import java.io.File

data class Style(val stroke: Color? = null, val strokeWidth: Int? = null, val fill: Color? = null)
typealias Line = Pair<Coordinates, Coordinates>
val defaultStyle = Style(Color.BLACK, 1, null)

class SVG(val width: Int? = null, val height: Int? = null) {

    constructor(size: Int) : this(size, size)

    val builder = StringBuilder()
    private var isFinalized = false

    init {
        builder.append(
                "<?xml version=\"1.0\"?>" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD util.SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-util.SVG-20010904/DTD/svg10.dtd\">" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" text-rendering=\"auto\" shape-rendering=\"auto\">")
    }

    fun horizontalLine(y: Int, width: Int, style: Style = defaultStyle): SVG {
        builder.append("<line x1=\"0\" y1=\"$y\" x2=\"$width\" y2=\"$y\" ${printStyle(style)}/>")
        return this
    }

    fun verticalLine(x: Int, height: Int, style: Style = defaultStyle): SVG {
        builder.append("<line x1=\"$x\" y1=\"0\" x2=\"$x\" y2=\"$height\" ${printStyle(style)}/>")
        return this
    }

    fun line(line: Line): SVG {
        return line(line.first.x, line.first.y, line.second.x, line.second.y)
    }

    fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: Style = defaultStyle): SVG {
        return line(x1.toDouble(), y1.toDouble(), x2.toDouble(), y2.toDouble(), style)
    }

    fun line(x1: Double, y1: Double, x2: Double, y2: Double, style: Style = defaultStyle): SVG {
        builder.append("<line x1=\"$x1\" y1=\"$y1\" x2=\"$x2\" y2=\"$y2\" ${printStyle(style)}/>")
        return this
    }

    fun lines(lines: Collection<Line>): SVG {
        for (line in lines) {
            line(line)
        }
        return this
    }

    fun square(x: Int, y: Int, size: Int, style: Style): SVG {
        return rect(x, y, size, size, style)
    }

    fun rect(x: Int, y: Int, width: Int, height: Int, style: Style): SVG {
        builder.append("<rect x=\"$x\" y=\"$y\" width=\"$width\" height=\"$height\" ${printStyle(style)} />")
        return this
    }

    fun circle(cx: Int, cy: Int, r: Int, style: Style): SVG {
        builder.append("<circle cx=\"$cx\" cy=\"$cy\" r=\"$r\" ${printStyle(style)} />")
        return this
    }

    fun ellipse(cx: Int, cy: Int, rx: Int, ry: Int, style: Style): SVG {
        builder.append("<ellipse cx=\"$cx\" cy=\"$cy\" rx=\"$rx\" ry=\"$ry\" ${printStyle(style)} />")
        return this
    }

    fun polygon(style: Style, vararg points: Pair<Int, Int>): SVG {
        builder.append("<polygon ${printPoints(points)} ${printStyle(style)} />")
        return this
    }

    fun polyline(style: Style, vararg points: Pair<Int, Int>): SVG {
        builder.append("<polyline ${printPoints(points)} ${printStyle(style)} />")
        return this
    }

    fun finalize(): SVG {
        builder.append("</svg>")
        isFinalized = true
        return this
    }

    fun getSVGString() = builder.toString()

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

    private fun printPoints(points: Array<out Pair<Int, Int>>): String {
        val sb = StringBuilder()
        if (points.isNotEmpty()) {
            sb.append("points=\" ")
            for (x in points) {
                sb.append("${x.first},${x.second} ")
            }
            sb.append("\"")
        }
        return sb.toString()
    }
}