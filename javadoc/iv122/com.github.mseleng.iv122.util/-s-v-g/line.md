---
title: SVG.line - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [SVG](index.md) / [line](.)

# line

`fun line(line: <ERROR CLASS><`[`Coordinates`](../-coordinates/index.md)`, `[`Coordinates`](../-coordinates/index.md)`>): `[`SVG`](index.md)

Adds a line

### Parameters

`line` - a Line to add

**Return**
this

`fun line(start: `[`Coordinates`](../-coordinates/index.md)`, end: `[`Coordinates`](../-coordinates/index.md)`): `[`SVG`](index.md)

Adds a line

### Parameters

`start` - the starting point of the line

`end` - the ending point of the line

**Return**
this

`fun line(x1: Int, y1: Int, x2: Int, y2: Int, style: `[`Style`](../-style/index.md)` = defaultLineStyle): `[`SVG`](index.md)
`fun line(x1: Double, y1: Double, x2: Double, y2: Double, style: `[`Style`](../-style/index.md)` = defaultLineStyle): `[`SVG`](index.md)

Adds a line

### Parameters

`x1` - the x-coordinate of the starting point

`y1` - the y-coordinate of the starting point

`x2` - the x-coordinate of the end point

`y2` - the y-coordinate of the end point

`style` - the desired style of the line (default: defaultLineStyle)

**Return**
this

