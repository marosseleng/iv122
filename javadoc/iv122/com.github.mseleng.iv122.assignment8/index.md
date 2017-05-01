---
title: com.github.mseleng.iv122.assignment8 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment8](.)

## Package com.github.mseleng.iv122.assignment8

### Types

| [MRCM](-m-r-c-m/index.md) | `class MRCM`<br>Class representing MRCM |
| [Wrapper](-wrapper/index.md) | `class Wrapper`<br>Represents a pattern within the MRCM iteration |

### Type Aliases

| [Transformation](-transformation.md) | `typealias Transformation = Array<<ERROR CLASS><Double, Double, Double>>`<br>Represents the transformation matrix |
| [WrapperApplication](-wrapper-application.md) | `typealias WrapperApplication = (`[`Wrapper`](-wrapper/index.md)`) -> List<`[`Wrapper`](-wrapper/index.md)`>`<br>An alias for the iterative function on Wrappers |

### Extensions for External Classes

| [kotlin.Array](kotlin.-array/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| [applyTransformations](apply-transformations.md) | `fun applyTransformations(lines: List<<ERROR CLASS><`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>, offset: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, iterations: Int, vararg transformations: `[`Transformation`](-transformation.md)`): List<<ERROR CLASS><`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>`<br>Applies the given transformations to the given lines [iterations](apply-transformations.md#com.github.mseleng.iv122.assignment8$applyTransformations(kotlin.collections.List((((com.github.mseleng.iv122.util.Coordinates, )))), com.github.mseleng.iv122.util.Coordinates, kotlin.Int, kotlin.Array((kotlin.Array((((kotlin.Double, , )))))))/iterations)-times. Offsets the result |
| [combine](combine.md) | `fun combine(vararg transformations: `[`Transformation`](-transformation.md)`): <ERROR CLASS>`<br>`fun combine(transformations: List<`[`Transformation`](-transformation.md)`>): <ERROR CLASS>`<br>Combine multiple transformations into one resulting |
| [identity](identity.md) | `fun identity(): `[`Transformation`](-transformation.md)<br>Returns an identity matrix |
| [mirrorX](mirror-x.md) | `fun mirrorX(): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the mirroring by the x-axis |
| [mirrorY](mirror-y.md) | `fun mirrorY(): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the mirroring by the y-axis |
| [prettyPrint](pretty-print.md) | `fun <ERROR CLASS><Double, Double, Double>.prettyPrint(): String`<br>Pretty prints the given row |
| [rotation](rotation.md) | `fun rotation(angle: Double): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the rotation by the given [angle](rotation.md#com.github.mseleng.iv122.assignment8$rotation(kotlin.Double)/angle) |
| [scaling](scaling.md) | `fun scaling(newWidth: Double, newHeight: Double): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the scaling |
| [shear](shear.md) | `fun shear(k: Double): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the shear by the given coefficient |
| [square](square.md) | `fun square(size: Double): List<<ERROR CLASS><`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>`<br>Returns the list of lines defining a square with its center in (0;0) and with edge length = 2*[size](square.md#com.github.mseleng.iv122.assignment8$square(kotlin.Double)/size) |
| [times](times.md) | `operator fun <ERROR CLASS><Double, Double, Double>.times(other: <ERROR CLASS><Double, Double, Double>): Double`<br>Multiplies (and sums) two rows of the matrix |
| [toCoordinates](to-coordinates.md) | `fun <ERROR CLASS><Double, Double, Double>.toCoordinates(): <ERROR CLASS>`<br>Converts the Triple to Coordinates (useful for homogeneous transformations |
| [translation](translation.md) | `fun translation(x: Double, y: Double): `[`Transformation`](-transformation.md)<br>`fun translation(target: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`): `[`Transformation`](-transformation.md)<br>Returns the matrix representing the translation by the given amount |

