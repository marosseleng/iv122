---
title: com.github.mseleng.iv122.assignment12 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment12](.)

## Package com.github.mseleng.iv122.assignment12

### Types

| [LampMazeFieldType](-lamp-maze-field-type/index.md) | `enum class LampMazeFieldType`<br>The enum representing the different fields in the maze |

### Functions

| [createNumberMazeGraph](create-number-maze-graph.md) | `fun createNumberMazeGraph(numbers: List<List<Int>>): `[`Graph`](../com.github.mseleng.iv122.util/-graph/index.md)`<Int>`<br>Creates a Graph representing the number maze |
| [createShortestPathsFromLamps](create-shortest-paths-from-lamps.md) | `fun createShortestPathsFromLamps(input: List<`[`Node`](../com.github.mseleng.iv122.util/-node/index.md)`<`[`LampMazeFieldType`](-lamp-maze-field-type/index.md)`>>): List<List<`[`Node`](../com.github.mseleng.iv122.util/-node/index.md)`<`[`LampMazeFieldType`](-lamp-maze-field-type/index.md)`>>>`<br>Creates the list of paths from the lamps to the "meeting point" |
| [drawBFSPaths](draw-b-f-s-paths.md) | `fun drawBFSPaths(paths: List<List<`[`Node`](../com.github.mseleng.iv122.util/-node/index.md)`<*>>>, fieldSize: Int, svg: `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)`): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Draws the given paths to the SVG and returns that SVG |
| [drawLampMazeToSVG](draw-lamp-maze-to-s-v-g.md) | `fun drawLampMazeToSVG(fields: List<List<`[`Node`](../com.github.mseleng.iv122.util/-node/index.md)`<`[`LampMazeFieldType`](-lamp-maze-field-type/index.md)`>>>, fieldSize: Int): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Draws the maze to the SVG |
| [fillNeighbors](fill-neighbors.md) | `fun fillNeighbors(nodes: List<List<`[`Node`](../com.github.mseleng.iv122.util/-node/index.md)`<`[`LampMazeFieldType`](-lamp-maze-field-type/index.md)`>>>): Unit`<br>Fills the neighbors of each node in the graph |
| [parseLampMazeFromFile](parse-lamp-maze-from-file.md) | `fun parseLampMazeFromFile(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): <ERROR CLASS>`<br>Parses the lamp maze from the give [file](parse-lamp-maze-from-file.md#com.github.mseleng.iv122.assignment12$parseLampMazeFromFile(java.io.File)/file)
'.' means an empty field
'#' means the wall
everything else means the lamp |
| [parseNumberMazeFromFile](parse-number-maze-from-file.md) | `fun parseNumberMazeFromFile(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, separator: Char = '|'): <ERROR CLASS>`<br>Parses teh number maze from the input [file](parse-number-maze-from-file.md#com.github.mseleng.iv122.assignment12$parseNumberMazeFromFile(java.io.File, kotlin.Char)/file) |

