---
title: intersections - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment4](index.md) / [intersections](.)

# intersections

`fun intersections(height: Int, lines: List<`[`ParametricLine`](../com.github.mseleng.iv122.util/-parametric-line/index.md)`>): Map<Int, List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>`

Uses ray tracing to find intersections with the given lines

The algorithm uses horizontal rays for ([height](intersections.md#com.github.mseleng.iv122.assignment4$intersections(kotlin.Int, kotlin.collections.List((com.github.mseleng.iv122.util.ParametricLine)))/height) - 1) rows

### Parameters

`height` - the number of rows to cover

`lines` - the list of lines to find intersections with

**Return**
the map, where the key is the number of row and the value is the list of interceptions on that line

