package com.github.mseleng.iv122.assignment12

import com.github.mseleng.iv122.util.*
import java.io.File

/**
 * Parses teh number maze from the input [file]
 *
 * @param file
 * @param separator the separator used to separate the numbers in the input file (default |)
 * @return the 2-dimensinoal list of Ints
 */
fun parseNumberMazeFromFile(file: File, separator: Char = '|')
        = file.readLines().map { it.split(separator).map { it.toIntOrNull() ?: 0 } }

/**
 * Creates a Graph representing the number maze
 */
fun createNumberMazeGraph(numbers: List<List<Int>>): Graph<Int> {
    val justNodes = numbers.mapIndexed { y, list ->
        list.mapIndexed { x, number ->
            Node(number, Coordinates(x, y))
        }
    }.flatten() // List<Node>

    // now we need to compute edges/neighbors
    for (node in justNodes) {
        val range = node.value
        val neighbors = listOf(
                Coordinates(0, range) + node.coordinates,
                Coordinates(0, -range) + node.coordinates,
                Coordinates(range, 0) + node.coordinates,
                Coordinates(-range, 0) + node.coordinates)
                .map { justNodes.firstOrNull { node -> node.coordinates == it } }
                .filterNotNull()
        node.neighbors = neighbors.toSet()
    }
    return Graph(justNodes)
}
