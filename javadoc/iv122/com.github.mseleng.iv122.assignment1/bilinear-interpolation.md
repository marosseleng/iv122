---
title: bilinearInterpolation - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](index.md) / [bilinearInterpolation](.)

# bilinearInterpolation

`fun bilinearInterpolation(x: Int, y: Int, width: Int, height: Int, tl: Int, tr: Int, bl: Int, br: Int): Double`

Computes the value of the "point" defined by its coordinates ([x](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/x), [y](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/y)) using the bilinear interpolation:

tl        q     tr

+- - - - + - - -+

|        |

|          p    |

y+        +

|               |

|        |

|               |

|        |r

+--------+------+

bl       x      br

This function uses the linearInterpolation function three times:

1. computes the value q by interpolating the values [tl](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/tl) and [tr](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/tr)
1. computes the value r by interpolating the values [bl](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/bl) and [br](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/br)
1. computes the result value p by interpolating the values q and r

### Parameters

`x` - the horizontal part of target point's coordinates

`y` - the vertical part of target point's coordinates

`width` - the width of the 2D grid

`height` - the height of the 2D grid

`tl` - the top-left value

`tr` - the top-right value

`bl` - the bottom-left value

`br` - the bottom-right value

**Return**
an interpolated value of the point with coordinates ([x](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/x), [y](bilinear-interpolation.md#com.github.mseleng.iv122.assignment1$bilinearInterpolation(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/y))

