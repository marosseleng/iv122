---
title: Coordinates - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Coordinates](.)

# Coordinates

`data class Coordinates : Any`

Data class representing the coordinates of a single point in the 2D space

### Parameters

`x` - the horizontal part

`y` - the vertical part

### Constructors

| [&lt;init&gt;](-init-.md) | `Coordinates(x: Int, y: Int)``Coordinates(x: Double, y: Double)`<br>creates the coordinates with the given values |

### Properties

| [x](x.md) | `val x: Double` |
| [y](y.md) | `val y: Double` |

### Functions

| [isOutOfRange](is-out-of-range.md) | `fun isOutOfRange(width: Int, height: Int): Boolean`<br>Says whether this coordinates are out of the given range |
| [minus](minus.md) | `operator fun minus(other: Coordinates): Coordinates` |
| [plus](plus.md) | `operator fun plus(other: Coordinates?): Coordinates` |
| [times](times.md) | `operator fun times(other: Int): Coordinates`<br>`operator fun times(other: Double): Coordinates` |
| [trimToNDecimalPoints](trim-to-n-decimal-points.md) | `fun trimToNDecimalPoints(n: Int): Coordinates`<br>Trims this decimal number, so there is no scientific exponentiation in toString() |

