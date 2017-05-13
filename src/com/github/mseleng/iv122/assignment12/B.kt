package com.github.mseleng.iv122.assignment12

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.io.File

/**
 * The enum representing the different fields in the maze
 */
enum class LampMazeFieldType {
    /**
     * The lamp (or anything except for the empty field and the wall)
     */
    OBJECT,
    /**
     * An empty field
     */
    EMPTY,
    /**
     * A field with the wall
     */
    WALL
}

/**
 * Parses the lamp maze from the give [file]
 * '.' means an empty field
 * '#' means the wall
 * everything else means the lamp
 *
 * @return the 2-dimensional array, representing the maze (represented as the list of lists)
 */
fun parseLampMazeFromFile(file: File) = file.readLines()
        .mapIndexed { y, row ->
            row.mapIndexed { x, field ->
                val coordinates = Coordinates(x, y)
                when (field) {
                    '.' -> Node(LampMazeFieldType.EMPTY, coordinates)
                    '#' -> Node(LampMazeFieldType.WALL, coordinates)
                    else -> Node(LampMazeFieldType.OBJECT, coordinates)
                }
            }
        }

/**
 * Fills the neighbors of each node in the graph
 */
fun fillNeighbors(nodes: List<List<Node<LampMazeFieldType>>>) {
    val candidates = listOf(Coordinates(0, 1), Coordinates(0, -1), Coordinates(1, 0), Coordinates(-1, 0))
    val flattened = nodes.flatten()
    for (node in flattened) {
        node.neighbors = candidates
                .map { it + node.coordinates }
                .map { c -> flattened.indexOfFirst { it.coordinates == c } }
                .filter { it > -1 && flattened[it].value != LampMazeFieldType.WALL }
                .map { flattened[it] }
                .toSet()
    }
}

/**
 * Creates the list of paths from the lamps to the "meeting point"
 *
 * @param input the list of nodes representing the graph
 * @return the list of paths (represented by the list of nodes)
 */
fun createShortestPathsFromLamps(input: List<Node<LampMazeFieldType>>): List<List<Node<LampMazeFieldType>>> {
    val sumMap = mutableMapOf<Node<LampMazeFieldType>, Int>()
    input.filter { it.value == LampMazeFieldType.OBJECT }.forEach {
        val g = Graph(input)
        bfs(g, it)
        for (n in g.nodes) {
            // filtering walls and inaccessible(do not contains an OBJECT and their distance is zero) fields
            if (n.value != LampMazeFieldType.WALL && (n.value == LampMazeFieldType.OBJECT || n.distanceFromStart != 0)) {
                val current = sumMap.getOrDefault(n, 0)
                sumMap.put(n, current + n.distanceFromStart)
            }
        }
    }

    val meetingPoint = sumMap.minBy { it.value }?.key ?: Node(LampMazeFieldType.WALL, Coordinates(0, 0))
    val paths = mutableListOf<List<Node<LampMazeFieldType>>>()
    input.filter { it.value == LampMazeFieldType.OBJECT }.forEach {
        val g = Graph(input)
        bfs(g, it)
        paths.add(constructBFSPathToStart(meetingPoint).reversed())
        Unit
    }

    return paths
}

/* SVG related stuff */

/**
 * Draws the maze to the SVG
 *
 * @param fields the fields to be drawn
 * @param fieldSize the size of the field of the maze
 * @return the SVG containing the maze
 */
fun drawLampMazeToSVG(fields: List<List<Node<LampMazeFieldType>>>, fieldSize: Int): SVG {
    val svg = SVG(fields.first().count() * fieldSize, fields.count() * fieldSize)
    fields.flatten()
            .forEach { node ->
                val x = node.coordinates.x.toInt()
                val y = node.coordinates.y.toInt()
                val fillColor = when (node.value) {
                    LampMazeFieldType.EMPTY -> Color.WHITE
                    LampMazeFieldType.WALL -> Color.GRAY
                    else -> Color.YELLOW
                }
                svg.square(x * fieldSize, y * fieldSize, fieldSize, Style(stroke = Color.BLACK, fill = fillColor))
            }
    return svg
}

/**
 * Draws the given paths to the SVG and returns that SVG
 *
 * @param paths the list of paths to draw
 * @param fieldSize the size of the field of the graph
 * @return the SVG containing the paths
 */
fun drawBFSPaths(paths: List<List<Node<*>>>, fieldSize: Int, svg: SVG): SVG {
    paths
            .map { nodes ->
                nodes.map { node ->
                    (node.coordinates * fieldSize) + Coordinates(fieldSize / 2.0, fieldSize / 2.0)
                }
            }
            .forEach { svg.polyline(Style(stroke = Color.RED, strokeWidth = 3), it) }
    return svg
}
