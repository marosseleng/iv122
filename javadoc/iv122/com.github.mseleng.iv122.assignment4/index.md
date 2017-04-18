---
title: com.github.mseleng.iv122.assignment4 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment4](.)

## Package com.github.mseleng.iv122.assignment4

### Functions

| [circleEmpty](circle-empty.md) | `fun circleEmpty(imgSize: Int, circleRadius: Int, eps: Double = 0.01): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates an empty circle using the general equation |
| [circleFull](circle-full.md) | `fun circleFull(imgSize: Int, circleRadius: Int): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates a full circle using the general equation |
| [circleParam](circle-param.md) | `fun circleParam(imgSize: Int, radius: Int): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates an empty circle using the parametric definition |
| [detailedEllipse](detailed-ellipse.md) | `fun detailedEllipse(imgSize: Int, a: Int, b: Int, rotationAngleDegrees: Double): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates a rotated ellipse |
| [ellipse](ellipse.md) | `fun ellipse(imgSize: Int, radius: Int, a: Int, b: Int, eps: Double = 0.01): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Create an empty regular ellipse |
| [hideAndSeek1](hide-and-seek1.md) | `fun hideAndSeek1(): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>The word "OREL" is hidden in pixels, that contain any blue part of the color. The rest of the picture's pixel does not contain any blue |
| [hideAndSeek2](hide-and-seek2.md) | `fun hideAndSeek2(): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>The word "KOZA" can be seen when we highlight trasitions between colors that are not smooth, eg. the neighbor pixel's colors differ by more than 1 |
| [hideAndSeek3](hide-and-seek3.md) | `fun hideAndSeek3(): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>The word "slon" was hidden in this image. It was deciphered using the XOR operation with the matrix.
The matrix looks like a chessboard, so that no two pixels with the same color share an edge |
| [intersections](intersections.md) | `fun intersections(height: Int, lines: List<`[`ParametricLine`](../com.github.mseleng.iv122.util/-parametric-line/index.md)`>): Map<Int, List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>`<br>Uses ray tracing to find intersections with the given lines |
| [polygon](polygon.md) | `fun polygon(imgSize: Int, vararg points: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates and fills the polygon specified by the given points |
| [spiralParam](spiral-param.md) | `fun spiralParam(imgSize: Int, radius: Int, offset: Double, density: Double): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates a spiral |
| [triangle](triangle.md) | `fun triangle(imgSize: Int, topColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, leftColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, rightColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)<br>Creates the triangle with all edges with the same length |

