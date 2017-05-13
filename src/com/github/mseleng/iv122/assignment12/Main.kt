package com.github.mseleng.iv122.assignment12

import com.github.mseleng.iv122.util.bfs
import com.github.mseleng.iv122.util.constructBFSPathToStart
import com.github.mseleng.iv122.util.fileWithName
import java.io.File

/**
 * @suppress
 */
fun run(path: String) {

    // A
    println("-> Number maze (input from inputs/assignment12/numberMaze.txt)......")
    val numberMazeGraph = createNumberMazeGraph(parseNumberMazeFromFile(File("inputs/assignment12/numberMaze.txt")))
    // perform BFS starting at the top-left corner
    bfs(numberMazeGraph, numberMazeGraph.nodes.first())
    val numberMazePath = constructBFSPathToStart(numberMazeGraph.nodes.last()).reversed()
    println("\t${numberMazePath.joinToString(separator = " ~~> ") { it.coordinates.toString() }}")
    print("==========\n")

    // B
    val fieldSize = 100
    print("-> Lamp maze(input from inputs/assignment12/lampMaze.txt; fieldSize == $fieldSize)......")
    val input = parseLampMazeFromFile(File("inputs/assignment12/lampsMaze.txt"))
    fillNeighbors(input)
    val paths = createShortestPathsFromLamps(input.flatten())
    drawBFSPaths(paths, fieldSize, drawLampMazeToSVG(input, fieldSize)).writeTo(fileWithName(path, 12, "lamps.svg"))
    println(" ✓ (assignment12/lamps.svg)")
}
