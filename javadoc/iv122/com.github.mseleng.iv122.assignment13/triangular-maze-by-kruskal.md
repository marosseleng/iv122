---
title: triangularMazeByKruskal - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment13](index.md) / [triangularMazeByKruskal](.)

# triangularMazeByKruskal

`fun triangularMazeByKruskal(sizeX: Int, sizeY: Int, fieldSize: Int, printIterations: Boolean = false, fileNameFunction: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)` = { File("") }): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)

Generates random triangular maze using the Kruskal's algorithm

### Parameters

`sizeX` - the number of squares in one row (a square consists of two triangles)

`sizeY` - the number of rows

`fieldSize` - the field size to use while creating an SVG

`printIterations` - whether to save iterations (for the GIF creating); default false

`fileNameFunction` - a function that creates the file according to the given index (useful when [printIterations](triangular-maze-by-kruskal.md#com.github.mseleng.iv122.assignment13$triangularMazeByKruskal(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((kotlin.Int, java.io.File)))/printIterations) == true)

**Return**
SVG containing the final maze

