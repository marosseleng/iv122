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
| [laysAboveLine](lays-above-line.md) | `fun laysAboveLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean`<br>Returns true if this lays above the [line](lays-above-line.md#com.github.mseleng.iv122.util.Coordinates$laysAboveLine(com.github.mseleng.iv122.util.ParametricLine)/line) |
| [laysBelowLine](lays-below-line.md) | `fun laysBelowLine(line: `[`ParametricLine`](../-parametric-line/index.md)`): Boolean`<br>Returns true if this lays below the [line](lays-below-line.md#com.github.mseleng.iv122.util.Coordinates$laysBelowLine(com.github.mseleng.iv122.util.ParametricLine)/line) |
| [laysOnLine](lays-on-line.md) | `fun laysOnLine(line: `[`ParametricLine`](../-parametric-line/index.md)`, tolerance: Double): Boolean`<br>Returns true if this lays on the parametric line |
| [laysOnLineStrict](lays-on-line-strict.md) | `fun laysOnLineStrict(line: `[`ParametricLine`](../-parametric-line/index.md)`, tolerance: Double): Boolean`<br>Returns true if this lays on the parametric line within its bounds |
| [polarAngleTo](polar-angle-to.md) | `fun polarAngleTo(other: Coordinates): Double`<br>Returns the polar angle between this and other |
| [toTriple](to-triple.md) | `fun toTriple(): <ERROR CLASS><Double, Double, Double>`<br>Returns the coordinates represented as the triple (for homogeneous transformations) |
| [trimToNDecimalPoints](trim-to-n-decimal-points.md) | `fun trimToNDecimalPoints(n: Int): Coordinates`<br>Trims this decimal number, so there is no scientific exponentiation in toString() |
| [vectorTo](vector-to.md) | `fun vectorTo(other: Coordinates): Coordinates`<br>Returns the (0;0) based vector from this to other |

