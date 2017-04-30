---
title: zoomedMandelbrot - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment7](index.md) / [zoomedMandelbrot](.)

# zoomedMandelbrot

`fun zoomedMandelbrot(imgSize: Int = 1200, center: `[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, zoomFactor: Double = 5.0, iterations: Int = 20, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, targetFile: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`

Generates (and writes) the series of zoomed Mandelbrot fractals within the given ranges

Always starts displaying the whole Mandelbrot's set

### Parameters

`center` - a point to be in the center while zooming

`zoomFactor` - the amount to divide the current interval

`iterations` - the number of images to generate/write

`targetFile` - a function that generates the output file (is dependent on the image number)