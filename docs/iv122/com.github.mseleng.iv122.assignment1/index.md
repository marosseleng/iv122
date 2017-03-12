---
title: com.github.mseleng.iv122.assignment1 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](.)

## Package com.github.mseleng.iv122.assignment1

### Types

| [EuclidSolution](-euclid-solution/index.md) | `data class EuclidSolution : Any`<br>Class representing tuple of two numbers (gcd and the number of steps needed to get it) |

### Functions

| [bilinearInterpolation](bilinear-interpolation.md) | `fun bilinearInterpolation(x: Int, y: Int, width: Int, height: Int, tl: Int, tr: Int, bl: Int, br: Int): Double`<br>Computes the value of the "point" defined by its coordinates ([x](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/x), [y](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/y)) using the bilinear interpolation: |
| [collatz](collatz.md) | `fun collatz(n: Int): `[`Chart`](../com.github.mseleng.iv122.util/-chart/index.md)<br>Creates a chart containing data about Collatz's sequence |
| [collatzWithMax](collatz-with-max.md) | `fun collatzWithMax(n: Int): `[`Chart`](../com.github.mseleng.iv122.util/-chart/index.md)<br>Creates a chart containing data about Collatz's sequence |
| [computeCenter](compute-center.md) | `fun computeCenter(width: Int, height: Int): `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)<br>Computes the coordinates for the center point (one containing the number 1) |
| [computeDimensions](compute-dimensions.md) | `fun computeDimensions(n: Int): <ERROR CLASS><Int, Int>`<br>Computes the minimum grid dimension for the given [n](compute-dimensions.md#com.github.mseleng.iv122.assignment1$computeDimensions(kotlin.Int)/n) |
| [gcd](gcd.md) | `fun gcd(first: Int, second: Int): Long`<br>Computes the greatest common divisor of two given integers`fun gcd(first: Long, second: Long): Long`<br>Computes the greatest common divisor of two given long integers |
| [getChartOfModulo](get-chart-of-modulo.md) | `fun getChartOfModulo(maxX: Int, maxY: Int): `[`Chart`](../com.github.mseleng.iv122.util/-chart/index.md)<br>Returns the [Chart](../com.github.mseleng.iv122.util/-chart/index.md) visualizing the number of steps needed to compute the gcd of two numbers (x,y) |
| [getChartOfSubtraction](get-chart-of-subtraction.md) | `fun getChartOfSubtraction(maxX: Int, maxY: Int): `[`Chart`](../com.github.mseleng.iv122.util/-chart/index.md)<br>Returns the [Chart](../com.github.mseleng.iv122.util/-chart/index.md) visualizing the number of steps needed to compute the gcd of two numbers (x,y) |
| [getFourWayGradient](get-four-way-gradient.md) | `fun getFourWayGradient(size: Int, topLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, topRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Prints the "4-way" gradient (using 4 colors in the edges of a 2D square grid) |
| [getInsideOutStarSVG](get-inside-out-star-s-v-g.md) | `fun getInsideOutStarSVG(steps: Int, stepWidth: Int, lineStyle: `[`Style`](../com.github.mseleng.iv122.util/-style/index.md)` = defaultStyle): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Returns the "inside-out" star. The result image can be seen in the file 'outputs/weird-star.png' |
| [getNextCoordinates](get-next-coordinates.md) | `fun getNextCoordinates(direction: `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`, lastCoordinates: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`): `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)<br>Computes the coordinates for the next number. |
| [getNextDirection](get-next-direction.md) | `fun getNextDirection(a: Int, lastDirection: `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`?): `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)<br>Computes the next direction. |
| [getNextMove](get-next-move.md) | `fun getNextMove(center: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, lastCoordinates: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`?, lastDirection: `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`?): <ERROR CLASS><`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`?>`<br>Computes the next move (where to place the next number on a spiral) |
| [getStar](get-star.md) | `fun getStar(steps: Int, stepWidth: Int, lineStyle: `[`Style`](../com.github.mseleng.iv122.util/-style/index.md)` = defaultStyle): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Prints the "tangent" star. The result image can be seen in the file 'outputs/star.png' |
| [getUlamsSpiral](get-ulams-spiral.md) | `fun getUlamsSpiral(n: Int, condition: UlamSpiralCondition): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Returns a file containing the Ulam's spiral. |
| [gradientColorForCoordinates](gradient-color-for-coordinates.md) | `fun gradientColorForCoordinates(x: Int, y: Int, width: Int, height: Int, topLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, topRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`): Int`<br>Computes the color in the 4-way gradient in 2D grid using the bilinear interpolation |
| [linearInterpolation](linear-interpolation.md) | `fun linearInterpolation(x: Int, width: Int, firstValue: Double, secondValue: Double): Double`<br>Computes the value on the [x](linear-interpolation.md#com.github.mseleng.iv122.assignment1$linearInterpolation(kotlin.Int, kotlin.Int, kotlin.Double, kotlin.Double)/x)-th position using the linear interpolation: |
| [run](run.md) | `fun run(args: Array<String>): Unit` |

