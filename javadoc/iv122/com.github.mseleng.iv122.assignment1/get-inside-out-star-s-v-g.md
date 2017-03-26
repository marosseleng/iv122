---
title: getInsideOutStarSVG - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](index.md) / [getInsideOutStarSVG](.)

# getInsideOutStarSVG

`fun getInsideOutStarSVG(steps: Int, stepWidth: Int, lineStyle: `[`Style`](../com.github.mseleng.iv122.util/-style/index.md)` = defaultLineStyle): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)

Returns the "inside-out" star. The result image can be seen in the file 'outputs/weird-star.png'

### Parameters

`steps` - the number of lines per frame edge (how many starting points are on the edge) (the size of the result file is ([steps](get-inside-out-star-s-v-g.md#com.github.mseleng.iv122.assignment1$getInsideOutStarSVG(kotlin.Int, kotlin.Int, com.github.mseleng.iv122.util.Style)/steps)*[stepWidth](get-inside-out-star-s-v-g.md#com.github.mseleng.iv122.assignment1$getInsideOutStarSVG(kotlin.Int, kotlin.Int, com.github.mseleng.iv122.util.Style)/stepWidth))

`stepWidth` - the size of the gap between each step (how far from each other the points are)

`lineStyle` - the style of the line. Default: [defaultLineStyle](../com.github.mseleng.iv122.util/default-line-style.md)

**Return**
an SVG containing the output

