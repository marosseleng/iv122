import org.jfree.graphics2d.svg.SVGGraphics2D
import java.awt.Color
import java.io.File

/**
 * Created by mseleng on 2/22/17.
 */

fun SVGGraphics2D.writeTo(file: File) {
    file.writeText(this.svgDocument)
}

data class Style(val stroke: Color, val strokeWidth: Int, val fill: Color)

class SVG(val width: Int, val height: Int) {
    val graphics = SVGGraphics2D(width, height)

    //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />
    fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: Style): SVG {
        return this
    }

    fun square(x: Int, y: Int, size: Int, style: Style): SVG {
        return rect(x, y, size, size, style)
    }

    //<rect width="300" height="100" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)" />
    fun rect(x: Int, y: Int, width: Int, height: Int, style: Style): SVG {

        return this
    }

    //<circle cx="50" cy="50" r="40" stroke="green" stroke-width="4" fill="yellow" />
    fun circle(cx: Int, cy: Int, r: Int, style: Style): SVG {

        return this
    }

    //<ellipse cx="200" cy="80" rx="100" ry="50" style="fill:yellow;stroke:purple;stroke-width:2" />
    fun ellipse(cx: Int, cy: Int, rx: Int, ry: Int, style: Style): SVG {

        return this
    }

    //<polygon points="200,10 250,190 160,210" style="fill:lime;stroke:purple;stroke-width:1" />
    fun polygon(style: Style, vararg points: Pair<Int, Int>): SVG {

        return this
    }

    //<polyline points="20,20 40,25 60,40 80,120 120,140 200,180" style="fill:none;stroke:black;stroke-width:3" />
    fun polyline(style: Style, vararg points: Pair<Int, Int>): SVG {

        return this
    }

}