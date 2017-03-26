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

| [isOutOfRange](is-out-of-range.md) | `fun isOutOfRange(width: Int, height: Int): Boolean`<br>Says whether this coordinates are out of the given range |
| [trimToNDecimalPoints](trim-to-n-decimal-points.md) | `fun trimToNDecimalPoints(n: Int): Coordinates`<br>Trims this decimal number, so there is no scientific exponentiation in toString() |

### Extension Functions

| [inOnLine](../../com.github.mseleng.iv122.assignment5/in-on-line.md) | `fun Coordinates.inOnLine(line: <ERROR CLASS><Coordinates, Coordinates>): Boolean` |

