---
title: Coordinates - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Coordinates](.)

# Coordinates

`data class Coordinates`

Data class representing the coordinates of a single point in the 2D space

### Parameters

`x` - the horizontal part

`y` - the vertical part

### Constructors

| [&lt;init&gt;](-init-.md) | `Coordinates(x: Int, y: Int)`<br>A constructor that accepts the integral values`Coordinates(x: Double, y: Double)`<br>creates the coordinates with the given values |

### Properties

| [x](x.md) | `val x: Double`<br>the horizontal part |
| [y](y.md) | `val y: Double`<br>the vertical part |

### Functions

| [euclideanDistanceFrom](euclidean-distance-from.md) | `fun euclideanDistanceFrom(other: Coordinates): Double`<br>Computes the euclidean distance between this and [other](euclidean-distance-from.md#com.github.mseleng.iv122.util.Coordinates$euclideanDistanceFrom(com.github.mseleng.iv122.util.Coordinates)/other) |
| [isOutOfRange](is-out-of-range.md) | `fun isOutOfRange(width: Int, height: Int): Boolean`<br>Says whether this coordinates are out of the given range |
| [laysAboveLine](lays-above-line.md) | `fun laysAboveLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean` |
| [laysBelowLine](lays-below-line.md) | `fun laysBelowLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean` |
| [laysLeftToTheLine](lays-left-to-the-line.md) | `fun laysLeftToTheLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean` |
| [laysOnLine](lays-on-line.md) | `fun laysOnLine(line: `[`ParametricLine`](../-parametric-line/index.md)`, tolerance: Double): Boolean` |
| [laysOnLineStrict](lays-on-line-strict.md) | `fun laysOnLineStrict(line: `[`ParametricLine`](../-parametric-line/index.md)`, tolerance: Double): Boolean` |
| [laysRightToLine](lays-right-to-line.md) | `fun laysRightToLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean` |
| [polarAngleTo](polar-angle-to.md) | `fun polarAngleTo(other: Coordinates): Double` |
| [trimToNDecimalPoints](trim-to-n-decimal-points.md) | `fun trimToNDecimalPoints(n: Int): Coordinates`<br>Trims this decimal number, so there is no scientific exponentiation in toString() |
| [vectorTo](vector-to.md) | `fun vectorTo(other: Coordinates): Coordinates` |
