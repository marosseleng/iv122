---
title: com.github.mseleng.iv122.util - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](.)

## Package com.github.mseleng.iv122.util

### Types

| [Backward](-backward/index.md) | `class Backward : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the backward move |
| [Chart](-chart/index.md) | `class Chart`<br>This class is used as a simple facade above the jfreechart library, providing simple chart actions |
| [Complex](-complex/index.md) | `data class Complex`<br>Complex number implementation, copied from
http://introcs.cs.princeton.edu/java/32class/Complex.java.html |
| [Coordinates](-coordinates/index.md) | `data class Coordinates`<br>Data class representing the coordinates of a single point in the 2D space |
| [Custom](-custom/index.md) | `class Custom : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the custom defined movement of the turtle |
| [Direction](-direction/index.md) | `enum class Direction`<br>Enum representing directions in a 2D grid |
| [Forward](-forward/index.md) | `class Forward : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the forward move |
| [LSystem](-l-system/index.md) | `class LSystem`<br>Class representing the L-system |
| [Left](-left/index.md) | `class Left : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the left rotation |
| [ParametricLine](-parametric-line/index.md) | `data class ParametricLine`<br>Class representing a line in Carthesian system, more specificaly its parametric representation |
| [Pop](-pop/index.md) | `class Pop : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the pop from the stack |
| [Push](-push/index.md) | `class Push : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the push to the stack |
| [Right](-right/index.md) | `class Right : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the right rotation |
| [SVG](-s-v-g/index.md) | `class SVG`<br>An helper class for the work with the SVG images |
| [StandStill](-stand-still/index.md) | `class StandStill : `[`TurtleDirections`](-turtle-directions/index.md)<br>A subclass of [TurtleDirections](-turtle-directions/index.md) representing the default fallback (the turtle does nothing) |
| [Style](-style/index.md) | `data class Style`<br>The class representing the style of the SVG elements |
| [Turtle](-turtle/index.md) | `class Turtle`<br>A helper class to work with the turtle graphics |
| [TurtleDirections](-turtle-directions/index.md) | `sealed class TurtleDirections`<br>Sealed class representing the possible turtle directions |

### Type Aliases

| [LSystemGrammarRules](-l-system-grammar-rules.md) | `typealias LSystemGrammarRules = Map<Char, String>`<br>The typealias for the grammar rules within the L-System |
| [LSystemTurtleRules](-l-system-turtle-rules.md) | `typealias LSystemTurtleRules = Map<Char, `[`TurtleDirections`](-turtle-directions/index.md)`>`<br>The typealias for the turtle rules within the L-System |
| [Line](-line.md) | `typealias Line = <ERROR CLASS><`[`Coordinates`](-coordinates/index.md)`, `[`Coordinates`](-coordinates/index.md)`>`<br>A typealias for the [kotlin.Pair](#) of [Coordinates](-coordinates/index.md) representing the starting and the end point of a line in SVG |

### Extensions for External Classes

| [java.awt.Color](java.awt.-color/index.md) |  |
| [java.awt.image.BufferedImage](java.awt.image.-buffered-image/index.md) |  |
| [kotlin.Array](kotlin.-array/index.md) |  |
| [kotlin.Double](kotlin.-double/index.md) |  |
| [kotlin.Int](kotlin.-int/index.md) |  |
| [kotlin.Long](kotlin.-long/index.md) |  |

### Properties

| [defaultLineStyle](default-line-style.md) | `val defaultLineStyle: `[`Style`](-style/index.md)<br>The default style (black stroke and stroke width == 1) |

### Functions

| [bisection](bisection.md) | `fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double`<br>Approximates the number using bisection |
| [bitmapImage](bitmap-image.md) | `fun bitmapImage(width: Int, height: Int, backgroundColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)` = Color.WHITE, init: `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`.() -> Unit = {}): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>An helper function that creates an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html) for further edit. |
| [drawSurrounding](draw-surrounding.md) | `fun drawSurrounding(point: `[`Coordinates`](-coordinates/index.md)`, img: `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`, color: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`): Unit`<br>Fills the surroundings (3x3 grid) of the given point in the given image |
| [e](e.md) | `fun e(eps: Double = 0.000001): Double`<br>Approximates the Euler's number |
| [fileWithName](file-with-name.md) | `fun fileWithName(rootDirName: String = "iv122_outputs", assignmentNo: Int, name: String): `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)<br>Returns an instance of [File](http://docs.oracle.com/javase/6/docs/api/java/io/File.html) somewhere in the `/outputs/` directory |
| [fraction](fraction.md) | `fun fraction(part: Int, whole: Int): Double`<br>Computes the fraction for the given part and the whole |
| [ln](ln.md) | `fun ln(x: Double, eps: Double = 0.000001): Double`<br>Approximates the natural logarithm of the given [x](ln.md#com.github.mseleng.iv122.util$ln(kotlin.Double, kotlin.Double)/x) |
| [nthRoot_approx_bisection](nth-root_approx_bisection.md) | `fun nthRoot_approx_bisection(num: Double, order: Long, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.0001): Double`<br>Approximates (using the bisection) the [order](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/order)-th root of [num](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/num) |
| [quadraticEquation](quadratic-equation.md) | `fun quadraticEquation(a: Double, b: Double, c: Double): <ERROR CLASS><Double, Double>`<br>Computes the roots of the given quadratic equation in the form |
| [readFile](read-file.md) | `fun readFile(name: String): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Reads the specified image file |
| [sqrt_approx_bisection](sqrt_approx_bisection.md) | `fun sqrt_approx_bisection(num: Double, from: Double = 0.0, to: Double = Math.floor(num.div(2.0)).plus(1), eps: Double = 0.0001): Double`<br>Approximates (using the bisection) the square root of the given number |
| [squareBitmapImage](square-bitmap-image.md) | `fun squareBitmapImage(size: Int, init: `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`.() -> Unit = {}): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html) of the square shape |

