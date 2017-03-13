---
title: com.github.mseleng.iv122.util - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](.)

## Package com.github.mseleng.iv122.util

### Types

| [Chart](-chart/index.md) | `class Chart : Any`<br>This class is used as a simple facade above the jfreechart library, providing simple chart actions |
| [Coordinates](-coordinates/index.md) | `data class Coordinates : Any`<br>Data class representing the coordinates of a single point in the 2D space |
| [Direction](-direction/index.md) | `enum class Direction : Enum<`[`Direction`](-direction/index.md)`>`<br>Enum representing directions in a 2D grid |
| [SVG](-s-v-g/index.md) | `class SVG : Any`<br>An helper class for the work with the SVG images |
| [Style](-style/index.md) | `data class Style : Any`<br>The class representing the style of the SVG elements |
| [Turtle](-turtle/index.md) | `class Turtle : Any`<br>Created by mseleng on 3/7/17. |

### Type Aliases

| [Line](-line.md) | `typealias Line = <ERROR CLASS><`[`Coordinates`](-coordinates/index.md)`, `[`Coordinates`](-coordinates/index.md)`>`<br>A typealias for the [Pair](#) of [Coordinates](-coordinates/index.md) representing the starting and the end point of a line in SVG |

### Extensions for External Classes

| [java.awt.image.BufferedImage](java.awt.image.-buffered-image/index.md) |  |
| [kotlin.Double](kotlin.-double/index.md) |  |
| [kotlin.Int](kotlin.-int/index.md) |  |

### Properties

| [defaultLineStyle](default-line-style.md) | `val defaultLineStyle: `[`Style`](-style/index.md)<br>The default style (black stroke and stroke width == 1) |

### Functions

| [bisection](bisection.md) | `fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double`<br>Approximates the number using bisection |
| [bitmapImage](bitmap-image.md) | `fun bitmapImage(width: Int, height: Int, init: (`[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`) -> Unit = {}): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>An helper function that creates an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html) for further edit. |
| [e](e.md) | `fun e(eps: Double = 0.000001): Double`<br>Approximates the Euler's number |
| [fileWithName](file-with-name.md) | `fun fileWithName(rootDirName: String = "outputs", assignmentNo: Int, name: String): `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)<br>Returns an instance of [File](http://docs.oracle.com/javase/6/docs/api/java/io/File.html) somewhere in the `/outputs/` directory |
| [fraction](fraction.md) | `fun fraction(part: Int, whole: Int): Double`<br>Computes the fraction for the given part and the whole |
| [ln](ln.md) | `fun ln(x: Double, eps: Double = 0.000001): Double`<br>Approximates the natural logarithm of the given [x](ln.md#com.github.mseleng.iv122.util$ln(kotlin.Double, kotlin.Double)/x) |
| [nthRoot_approx_bisection](nth-root_approx_bisection.md) | `fun nthRoot_approx_bisection(num: Double, order: Long, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.0001): Double`<br>Approximates (using the bisection) the [order](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/order)-th root of [num](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/num) |
| [sqrt_approx_bisection](sqrt_approx_bisection.md) | `fun sqrt_approx_bisection(num: Double, from: Double = 0.0, to: Double = Math.floor(num.div(2.0)).plus(1), eps: Double = 0.0001): Double`<br>Approximates (using the bisection) the square root of the given number |
| [squareBitmapImage](square-bitmap-image.md) | `fun squareBitmapImage(size: Int, init: (`[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`) -> Unit = {}): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html) of the square shape |

