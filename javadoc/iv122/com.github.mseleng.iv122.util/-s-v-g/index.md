---
title: SVG - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [SVG](.)

# SVG

`class SVG : Any`

### Constructors

| [&lt;init&gt;](-init-.md) | `SVG(size: Int)`<br>`SVG(width: Int? = null, height: Int? = null)` |

### Properties

| [builder](builder.md) | `val builder: `[`StringBuilder`](http://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html) |
| [height](height.md) | `val height: Int?` |
| [width](width.md) | `val width: Int?` |

### Functions

| [circle](circle.md) | `fun circle(cx: Int, cy: Int, r: Int, style: `[`Style`](../-style/index.md)`): SVG` |
| [ellipse](ellipse.md) | `fun ellipse(cx: Int, cy: Int, rx: Int, ry: Int, style: `[`Style`](../-style/index.md)`): SVG` |
| [finalize](finalize.md) | `fun finalize(): SVG` |
| [getSVGString](get-s-v-g-string.md) | `fun getSVGString(): String` |
| [horizontalLine](horizontal-line.md) | `fun horizontalLine(y: Int, width: Int, style: `[`Style`](../-style/index.md)` = defaultStyle): SVG` |
| [line](line.md) | `fun line(line: <ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>): SVG`<br>`fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: `[`Style`](../-style/index.md)` = defaultStyle): SVG`<br>`fun line(x1: Double, y1: Double, x2: Double, y2: Double, style: `[`Style`](../-style/index.md)` = defaultStyle): SVG` |
| [lines](lines.md) | `fun lines(lines: Collection<<ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>>): SVG` |
| [polygon](polygon.md) | `fun polygon(style: `[`Style`](../-style/index.md)`, vararg points: <ERROR CLASS><Int, Int>): SVG` |
| [polyline](polyline.md) | `fun polyline(style: `[`Style`](../-style/index.md)`, vararg points: <ERROR CLASS><Int, Int>): SVG` |
| [rect](rect.md) | `fun rect(x: Int, y: Int, width: Int, height: Int, style: `[`Style`](../-style/index.md)`): SVG` |
| [square](square.md) | `fun square(x: Int, y: Int, size: Int, style: `[`Style`](../-style/index.md)`): SVG` |
| [verticalLine](vertical-line.md) | `fun verticalLine(x: Int, height: Int, style: `[`Style`](../-style/index.md)` = defaultStyle): SVG` |
| [writeTo](write-to.md) | `fun writeTo(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit` |
