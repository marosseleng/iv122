package com.github.mseleng.iv122.assignment13

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.io.File
import java.util.*

/**
 * Helper class for the Kruskal's algorithm
 */
data class Edge(val first: Coordinates, val second: Coordinates) {

    /**
     * @suppress
     */
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Edge) {
            return false
        }
        return (this.first == other.first && this.second == other.second) ||
                (this.first == other.second && this.second == other.first)
    }

    /**
     * @suppress
     */
    override fun hashCode(): Int {
        return 31 * (first.hashCode() + second.hashCode())
    }
}

/**
 * Generate the triangular maze using the Kruskal's algorithm
 *
 * @return a list of lists of edges representing an iteration step
 */
fun kruskal(edges: MutableList<Edge>, components: MutableList<Set<Coordinates>>): List<List<Edge>> {
    val random = Random()
    val tmp = mutableListOf<Edge>()
    tmp.addAll(edges)
    val result = mutableListOf(tmp)
    while (components.count() > 1) {
        val index = random.nextInt(edges.count())
        val randomEdge = edges[index]
        val firstSet = components.filter { it.contains(randomEdge.first) }.firstOrNull()
        val secondSet = components.filter { it.contains(randomEdge.second) }.firstOrNull()
        if (firstSet == null || secondSet == null) {
            edges.remove(randomEdge)
            continue
        }
        // if the random edge separates two different components, join them!
        if (firstSet != secondSet) {
            val jointSet = mutableSetOf<Coordinates>()
            jointSet.addAll(firstSet)
            jointSet.addAll(secondSet)
            components.remove(firstSet)
            components.remove(secondSet)
            components.add(jointSet)
            edges.remove(randomEdge)
            val newList = mutableListOf<Edge>()
            newList.addAll(edges)
            result.add(newList)
        }
    }
    return result
}

/**
 * Generates random triangular maze using the Kruskal's algorithm
 *
 * @param sizeX the number of squares in one row (a square consists of two triangles)
 * @param sizeY the number of rows
 * @param fieldSize the field size to use while creating an SVG
 * @param printIterations whether to save iterations (for the GIF creating); default false
 * @param fileNameFunction a function that creates the file according to the given index (useful when [printIterations] == true)
 * @return SVG containing the final maze
 */
fun triangularMazeByKruskal(sizeX: Int, sizeY: Int, fieldSize: Int, printIterations: Boolean = false, fileNameFunction: (Int) -> File = { File("") }): SVG {
    val evenCandidates = listOf(Coordinates(-1, 0), Coordinates(1, 0), Coordinates(1, 1))
    val oddCandidates = listOf(Coordinates(-1, 0), Coordinates(1, 0), Coordinates(-1, -1))

    val edges = mutableListOf<Edge>()
    val components = mutableListOf<Set<Coordinates>>()

    var tmpX = 1
    for (y in 0 until sizeY) {
        for (x in 0 until tmpX) {
            val targetCandidates = if (x % 2 == 0) { evenCandidates } else { oddCandidates }
            val thisTriangle = Coordinates(x, y)
            components.add(setOf(thisTriangle))
            edges.addAll(targetCandidates.map { it + thisTriangle }.map { Edge(thisTriangle, it) })
        }
        tmpX += 2
    }

    val filteredEdges = edges
            .filter { it.first.x >= 0 && it.first.y >= 0 && it.second.x >=0 && it.second.y >= 0 }
            .distinct()
            .toMutableList()

    val iterations = kruskal(filteredEdges, components)
    if (printIterations) {
        iterations.forEachIndexed { index, edges ->
            val svg = SVG(sizeX * fieldSize, sizeY * fieldSize)
            printToSVGTriangle(edges, sizeY, sizeX, fieldSize, svg)
            svg.writeTo(fileNameFunction(index))
        }
    }

    val svg = SVG(sizeX * fieldSize, sizeY * fieldSize)
    printToSVGTriangle(filteredEdges, sizeY, sizeX, fieldSize, svg)
    return svg
}

/**
 * Prints the maze to the [svg]
 */
private fun printToSVGTriangle(edges: List<Edge>, rows: Int, columns: Int, fieldSize: Int, svg: SVG) {
    svg.polyline(defaultLineStyle, Coordinates(0, 0), Coordinates(0, rows * fieldSize), Coordinates(columns * fieldSize, rows * fieldSize), Coordinates(0, 0))
    svg.polygon(Style(stroke = Color.GREEN, fill = Color.GREEN), Coordinates(0, 0), Coordinates(0, fieldSize), Coordinates(fieldSize, fieldSize))
    val bottomRightX = columns * fieldSize
    val bottomRightY = rows * fieldSize
    svg.polygon(Style(stroke = Color.RED, fill = Color.RED), Coordinates(bottomRightX, bottomRightY), Coordinates(bottomRightX - fieldSize, bottomRightY - fieldSize), Coordinates(bottomRightX - fieldSize, bottomRightY))
    edges.forEach {
        drawEdge(it, fieldSize, svg)
    }
}

/**
 * Draws an edge (for the triangular maze)
 */
private fun drawEdge(edge: Edge, fieldSize: Int, svg: SVG) {
    val (first, second) = edge
    if (first.y == second.y) {
        if (minOf(first.x, second.x).toInt() % 2 == 0) {
            // |\\| <- the diagonal edge between two triangles
            val newX = (minOf(first.x, second.x).toInt() / 2) * fieldSize
            val newY = first.y.toInt() * fieldSize
            svg.line(Coordinates(newX, newY), Coordinates(newX + fieldSize, newY + fieldSize))
        } else {
            // \||\ <- the vertical edge between two triangles
            val newX = (maxOf(first.x, second.x).toInt() / 2) * fieldSize
            val newY = first.y.toInt() * fieldSize
            svg.line(Coordinates(newX, newY), Coordinates(newX, newY + fieldSize))
        }
    } else {
        // represents the horizontal edge
        val newX = (first.x / 2) * fieldSize
        val newY = maxOf(first.y, second.y) * fieldSize
        svg.line(Coordinates(newX, newY), Coordinates(newX + fieldSize, newY))
    }
}
