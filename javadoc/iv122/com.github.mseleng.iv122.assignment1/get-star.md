---
title: getStar - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](index.md) / [getStar](.)

# getStar

`fun getStar(steps: Int, stepWidth: Int, lineStyle: `[`Style`](../com.github.mseleng.iv122.util/-style/index.md)` = defaultLineStyle): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)

Prints the "tangent" star. The result image can be seen in the file 'outputs/star.png'

### Parameters

`steps` - the number of lines of the half of the horizontal/vertical center line (the size of the result file is (2*[steps](get-star.md#com.github.mseleng.iv122.assignment1$getStar(kotlin.Int, kotlin.Int, com.github.mseleng.iv122.util.Style)/steps)*[stepWidth](get-star.md#com.github.mseleng.iv122.assignment1$getStar(kotlin.Int, kotlin.Int, com.github.mseleng.iv122.util.Style)/stepWidth))

`stepWidth` - the size of the gap between each step (how far from each other the points are)

`lineStyle` - the style of the line. Default: [defaultLineStyle](../com.github.mseleng.iv122.util/default-line-style.md)