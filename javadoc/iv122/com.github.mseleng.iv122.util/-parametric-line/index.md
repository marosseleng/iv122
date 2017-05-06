---
title: ParametricLine - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [ParametricLine](.)

# ParametricLine

`data class ParametricLine`

Class representing a line in Carthesian system, more specificaly its parametric representation

Each point p of this line l must suit the equation y = a*x + b

### Constructors

| [&lt;init&gt;](-init-.md) | `ParametricLine(svgLine: <ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>)`<br>creates the parametric line from the SVG one`ParametricLine(first: `[`Coordinates`](../-coordinates/index.md)`, second: `[`Coordinates`](../-coordinates/index.md)`)`<br>computes [a](a.md) and [b](b.md) for the line given by the points [first](-init-.md#com.github.mseleng.iv122.util.ParametricLine$<init>(com.github.mseleng.iv122.util.Coordinates, com.github.mseleng.iv122.util.Coordinates)/first) and [second](-init-.md#com.github.mseleng.iv122.util.ParametricLine$<init>(com.github.mseleng.iv122.util.Coordinates, com.github.mseleng.iv122.util.Coordinates)/second) |

### Properties

| [a](a.md) | `val a: Double` |
| [b](b.md) | `val b: Double` |
| [first](first.md) | `val first: `[`Coordinates`](../-coordinates/index.md)<br>the first point, that lays on this line |
| [second](second.md) | `val second: `[`Coordinates`](../-coordinates/index.md)<br>the second point, that lays on this line |

### Functions

| [getValue](get-value.md) | `fun getValue(x: Double): Double` |
| [intersectionWith](intersection-with.md) | `fun intersectionWith(other: ParametricLine): `[`Coordinates`](../-coordinates/index.md)`?`<br>Finds and returns (if exists) the intersection between this and other line |
| [isAscending](is-ascending.md) | `fun isAscending(): Boolean` |
| [isDescending](is-descending.md) | `fun isDescending(): Boolean` |
| [isHorizontal](is-horizontal.md) | `fun isHorizontal(): Boolean` |
| [substituteCoordinates](substitute-coordinates.md) | `fun substituteCoordinates(point: `[`Coordinates`](../-coordinates/index.md)`): Double`<br>Substitutes the coordinates in the equation a*x + b - y.
Returns the result, which is usable for determining the position of the given point relative to the line |

