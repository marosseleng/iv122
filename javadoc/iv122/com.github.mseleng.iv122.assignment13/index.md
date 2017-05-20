---
title: com.github.mseleng.iv122.assignment13 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment13](.)

## Package com.github.mseleng.iv122.assignment13

### Types

| [Edge](-edge/index.md) | `data class Edge`<br>Helper class for the Kruskal's algorithm |

### Functions

| [dfsOnMap](dfs-on-map.md) | `fun dfsOnMap(fieldsAndEdges: Map<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, MutableList<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>, visited: MutableList<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, candidates: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, start: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`): Unit`<br>Performs DFS on the graph specified as Map&lt;Coordinates, List&gt; |
| [generateRectangularMaze](generate-rectangular-maze.md) | `fun generateRectangularMaze(sizeX: Int, sizeY: Int, fieldSize: Int): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Generates the rectangular maze using the DFS |
| [kruskal](kruskal.md) | `fun kruskal(edges: MutableList<`[`Edge`](-edge/index.md)`>, components: MutableList<Set<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>): List<List<`[`Edge`](-edge/index.md)`>>`<br>Generate the triangular maze using the Kruskal's algorithm |
| [triangularMazeByKruskal](triangular-maze-by-kruskal.md) | `fun triangularMazeByKruskal(sizeX: Int, sizeY: Int, fieldSize: Int, printIterations: Boolean = false, fileNameFunction: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)` = { File("") }): `[`SVG`](../com.github.mseleng.iv122.util/-s-v-g/index.md)<br>Generates random triangular maze using the Kruskal's algorithm |

