---
title: gradientColorForCoordinates - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](index.md) / [gradientColorForCoordinates](.)

# gradientColorForCoordinates

`fun gradientColorForCoordinates(x: Int, y: Int, width: Int, height: Int, topLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, topRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomLeft: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, bottomRight: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`): Int`

Computes the color in the 4-way gradient in 2D grid using the bilinear interpolation

The resulting color consists of the R-G-B values, each of which was computed using the separate interpolation

### Parameters

`x` - the horizontal part of target point's coordinates

`y` - the vertical part of target point's coordinates

`width` - the width of the 2D grid

`height` - the height of the 2D grid

`topLeft` - the top-left value

`topRight` - the top-right value

`bottomLeft` - the bottom-left value

`bottomRight` - the bottom-right value

**Return**
an interpolated color of the pixel with coordinates ([x](gradient-color-for-coordinates.md#com.github.mseleng.iv122.assignment1$gradientColorForCoordinates(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, java.awt.Color, java.awt.Color, java.awt.Color, java.awt.Color)/x), [y](gradient-color-for-coordinates.md#com.github.mseleng.iv122.assignment1$gradientColorForCoordinates(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, java.awt.Color, java.awt.Color, java.awt.Color, java.awt.Color)/y))

**See Also**

[bilinearInterpolation](bilinear-interpolation.md)

