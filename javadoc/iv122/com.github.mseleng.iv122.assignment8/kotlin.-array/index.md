---
title: com.github.mseleng.iv122.assignment8.kotlin.Array - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.assignment8](../index.md) / [kotlin.Array](.)

### Extensions for kotlin.Array

| [applyOn](apply-on.md) | `fun `[`Transformation`](../-transformation.md)`.applyOn(lines: List<<ERROR CLASS><`[`Coordinates`](../../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Coordinates`](../../com.github.mseleng.iv122.util/-coordinates/index.md)`>>): <ERROR CLASS>`<br>Applies this transformation on the given lines |
| [get](get.md) | `operator fun `[`Transformation`](../-transformation.md)`.get(x: Int, y: Int): Double`<br>Returns the item from matrix at position (x, y) where x is column |
| [getColumn](get-column.md) | `fun `[`Transformation`](../-transformation.md)`.getColumn(n: Int): <ERROR CLASS><Double, Double, Double>`<br>Returns the [n](get-column.md#com.github.mseleng.iv122.assignment8$getColumn(kotlin.Array((((kotlin.Double, , )))), kotlin.Int)/n)-th column of this matrix |
| [prettyPrint](pretty-print.md) | `fun `[`Transformation`](../-transformation.md)`.prettyPrint(): String`<br>Pretty prints the given transformation matrix |
| [times](times.md) | `operator fun `[`Transformation`](../-transformation.md)`.times(other: `[`Transformation`](../-transformation.md)`): `[`Transformation`](../-transformation.md)<br>Multiplies two transformations (matrices)`operator fun `[`Transformation`](../-transformation.md)`.times(point: `[`Coordinates`](../../com.github.mseleng.iv122.util/-coordinates/index.md)`): <ERROR CLASS>`<br>Applies the transformation to the given coordinates. Returns the Coordinates`operator fun `[`Transformation`](../-transformation.md)`.times(point: <ERROR CLASS><Double, Double, Double>): <ERROR CLASS><Double, Double, Double>`<br>Applies the transformation to the given point (multiplies two matrices). Returns the Triple |

