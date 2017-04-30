---
title: com.github.mseleng.iv122.assignment7 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment7](.)

## Package com.github.mseleng.iv122.assignment7

### Properties

| [indigoGray](indigo-gray.md) | `val indigoGray: <ERROR CLASS>`<br>The indigo-gray color scheme |
| [innerForIndigoGray](inner-for-indigo-gray.md) | `val innerForIndigoGray: <ERROR CLASS>`<br>Inner colors nicely matching the indigo-gray combination |
| [innerForLightBlueBrown](inner-for-light-blue-brown.md) | `val innerForLightBlueBrown: <ERROR CLASS>`<br>Inner colors nicely matching the lightblue-brown combination |
| [innerForLinePurple](inner-for-line-purple.md) | `val innerForLinePurple: <ERROR CLASS>`<br>Inner colors nicely matching the lime-purple combination |
| [lightBlueBrown](light-blue-brown.md) | `val lightBlueBrown: <ERROR CLASS>`<br>The light blue-brown color scheme |
| [limePurple](lime-purple.md) | `val limePurple: <ERROR CLASS>`<br>The lime-purple color scheme |
| [newtonColors](newton-colors.md) | `val newtonColors: <ERROR CLASS>`<br>Colors for the newton fractal |

### Functions

| [fractal](fractal.md) | `fun fractal(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, innerColors: <ERROR CLASS><`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, autoBalance: Boolean = true, numOfThreads: Int = 1, colorByComplexResult: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> Boolean = { c -> c.re != Double.NaN && c.im != Double.NaN && c.abs() < 2.0 }, iterate: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> <ERROR CLASS><`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, Int>): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>This serves as a load balancer, eg. if we don't want parallelism, we will not create ExecutorService. |
| [julia](julia.md) | `fun julia(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, innerColors: <ERROR CLASS><`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, c: `[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, autoBalance: Boolean = true, numOfThreads: Int = 1): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Generates the Julia set/fractal within the given ranges |
| [mandelbrot](mandelbrot.md) | `fun mandelbrot(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, innerColors: <ERROR CLASS><`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, autoBalance: Boolean = true, numOfThreads: Int = 1): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Generates the Mandelbrot set/fractal within the given ranges |
| [newton](newton.md) | `fun newton(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, function: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> `[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, solutions: List<`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`>, colors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, autoBalance: Boolean = true, numOfThreads: Int = 1): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Generates the Newton fractal for the given equation and respective solutions within the given ranges |
| [zoomedMandelbrot](zoomed-mandelbrot.md) | `fun zoomedMandelbrot(imgSize: Int = 1200, center: `[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, zoomFactor: Double = 5.0, iterations: Int = 20, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, targetFile: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`<br>Generates (and writes) the series of zoomed Mandelbrot fractals within the given ranges |

