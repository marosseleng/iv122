---
title: SVG - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [SVG](.)

# SVG

`class SVG`

An helper class for the work with the SVG images

### Parameters

`width` - the desired width of the SVG image (default 1000)

`height` - the desired height of the SVG image (default 1000)

### Constructors

| [&lt;init&gt;](-init-.md) | `SVG(size: Int)`<br>A constructor used for square-shaped SVGs`SVG(width: Int = 1000, height: Int = 1000)`<br>creates the SVG with the header |

### Properties

| [height](height.md) | `val height: Int`<br>the desired height of the SVG image (default 1000) |
| [width](width.md) | `val width: Int`<br>the desired width of the SVG image (default 1000) |

### Functions

| [circle](circle.md) | `fun circle(cx: Int, cy: Int, r: Int, style: `[`Style`](../-style/index.md)`): SVG`<br>Adds a circle |
| [ellipse](ellipse.md) | `fun ellipse(cx: Int, cy: Int, rx: Int, ry: Int, style: `[`Style`](../-style/index.md)`): SVG`<br>Adds an ellipse |
| [finalize](finalize.md) | `fun finalize(): SVG`<br>Adds a footer |
| [horizontalLine](horizontal-line.md) | `fun horizontalLine(y: Int, width: Int, style: `[`Style`](../-style/index.md)` = defaultLineStyle): SVG`<br>Adds the horizontal line |
| [line](line.md) | `fun line(line: <ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>): SVG`<br>`fun line(start: `[`Coordinates`](../-coordinates/index.md)`, end: `[`Coordinates`](../-coordinates/index.md)`): SVG`<br>`fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: `[`Style`](../-style/index.md)` = defaultLineStyle): SVG`<br>`fun line(x1: Double, y1: Double, x2: Double, y2: Double, style: `[`Style`](../-style/index.md)` = defaultLineStyle): SVG`<br>Adds a line |
| [lines](lines.md) | `fun lines(lines: Collection<<ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>>): SVG`<br>Adds multiple lines |
| [point](point.md) | `fun point(coordinates: `[`Coordinates`](../-coordinates/index.md)`, stroke: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)` = Color.BLACK): SVG`<br>Adds a single point |
| [polygon](polygon.md) | `fun polygon(style: `[`Style`](../-style/index.md)`, vararg points: `[`Coordinates`](../-coordinates/index.md)`): SVG`<br>Adds a polygon |
| [polyline](polyline.md) | `fun polyline(style: `[`Style`](../-style/index.md)`, vararg points: `[`Coordinates`](../-coordinates/index.md)`): SVG`<br>Adds a polyline |
| [rect](rect.md) | `fun rect(x: Int, y: Int, width: Int, height: Int, style: `[`Style`](../-style/index.md)`): SVG`<br>Adds a rectangle |
| [square](square.md) | `fun square(x: Int, y: Int, size: Int, style: `[`Style`](../-style/index.md)`): SVG`<br>Adds a square |
| [verticalLine](vertical-line.md) | `fun verticalLine(x: Int, height: Int, style: `[`Style`](../-style/index.md)` = defaultLineStyle): SVG`<br>Adds the vertical line |
| [writeTo](write-to.md) | `fun writeTo(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`<br>Writes the SVG data into the passed file |

