package com.github.mseleng.iv122.assignment13

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.util.Collections.shuffle

/**
 * Prints the square maze to the SVG
 */
private fun printToSVG(fieldsAndEdges: Map<Coordinates, MutableList<Coordinates>>, rows: Int, columns: Int, fieldSize: Int, svg: SVG) {
    svg.rect(0, 0, columns * fieldSize, rows * fieldSize, Style(strokeWidth = 2, stroke = Color.BLACK))
    svg.circle(fieldSize / 2, fieldSize / 2, fieldSize / 3, Style(stroke = Color.GREEN, fill = Color.GREEN))
    svg.circle(
            fieldsAndEdges.keys.last().x.toInt() * fieldSize + (fieldSize / 2),
            fieldsAndEdges.keys.last().y.toInt() * fieldSize + (fieldSize / 2),
            fieldSize / 3,
            Style(stroke = Color.RED, fill = Color.RED))
    fieldsAndEdges.forEach { coordinates, walls ->
        drawLinesAroundSquare(coordinates, fieldSize, walls, svg)
    }
}

/**
 * For the given [coordinates], prints its [walls]
 */
private fun drawLinesAroundSquare(coordinates: Coordinates, fieldSize: Int, walls: List<Coordinates>, svg: SVG) {
    val topLeft = Coordinates(coordinates.x * fieldSize, coordinates.y * fieldSize)
    val bottomRight = Coordinates(coordinates.x * fieldSize + fieldSize, coordinates.y * fieldSize + fieldSize)
    walls.forEach {
        if (it == Coordinates(1, 0)) {
            svg.line(topLeft.copy(x = topLeft.x + fieldSize), bottomRight)
        }
        if (it == Coordinates(-1, 0)) {
            svg.line(topLeft, bottomRight.copy(x = bottomRight.x - fieldSize))
        }
        if (it == Coordinates(0, 1)) {
            svg.line(topLeft.copy(y = topLeft.y + fieldSize), bottomRight)
        }
        if (it == Coordinates(0, -1)) {
            svg.line(topLeft, bottomRight.copy(y = bottomRight.y - fieldSize))
        }
    }
}

/**
 * Performs DFS on the graph specified as Map<Coordinates, List<Coordinates>>
 */
fun dfsOnMap(fieldsAndEdges: Map<Coordinates, MutableList<Coordinates>>, visited: MutableList<Coordinates>, candidates: List<Coordinates>, start: Coordinates) {
    if (visited.contains(start)) {
        return
    }
    visited.add(start)

    val walls = fieldsAndEdges.getOrDefault(start, mutableListOf())
    val mappedCandidates = candidates.map { start + it }.toMutableList()
    shuffle(mappedCandidates)

    for (c in mappedCandidates) {
        val wallIndex = c - start
        if (wallIndex in walls && c !in visited) {
            walls.remove(wallIndex)
            fieldsAndEdges.getOrDefault(c, mutableListOf()).remove(Coordinates(0, 0) - wallIndex)
            dfsOnMap(fieldsAndEdges, visited, candidates, c)
        }
    }
}

/**
 * Generates the rectangular maze using the DFS
 */
fun generateRectangularMaze(sizeX: Int, sizeY: Int, fieldSize: Int): SVG {
    val candidates = listOf(Coordinates(1, 0), Coordinates(-1, 0), Coordinates(0, 1), Coordinates(0, -1))
    val fieldsAndEdges = mutableMapOf<Coordinates, MutableList<Coordinates>>()

    for (x in 0 until sizeX) {
        for (y in 0 until sizeY) {
            fieldsAndEdges.put(Coordinates(x, y), candidates.map { it.copy() }.toMutableList())
        }
    }

    val svg = SVG(sizeX * fieldSize, sizeY * fieldSize)

    dfsOnMap(fieldsAndEdges, mutableListOf(), candidates, fieldsAndEdges.keys.first())
    printToSVG(fieldsAndEdges, sizeX, sizeY, fieldSize, svg)

    return svg
}
