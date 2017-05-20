package com.github.mseleng.iv122.util

import java.util.*

/**
 * Generic class representing the node in the graph, which is identified by its coordinates and value
 *
 * @constructor creates the node with the specified [value] and [coordinates]
 * @property value the value associated with this node
 * @property coordinates the coordinates of this node
 */
class Node<T>(val value: T, var coordinates: Coordinates) {

    /* BFS/DFS related fields */
    /**
     * @property predecessor the predecessor of this node
     */
    var predecessor: Node<T>? = null
    /**
     * @property distanceFromStart the distance from the start
     */
    var distanceFromStart = 0
    /**
     * @property searchState the current search state of the node
     */
    var searchState: SearchState = SearchState.NOT_DISCOVERED

    /**
     * @property neighbors the neighbors in the graph (adjacent nodes)
     */
    var neighbors: Set<Node<T>> = mutableSetOf()

    /**
     * @suppress
     */
    override fun equals(other: Any?): Boolean {
        return other != null
                && (other is Node<*>)
                && this.value == other.value
                && this.coordinates == other.coordinates
    }

    /**
     * @suppress
     */
    override fun hashCode(): Int {
        return Objects.hash(value)
    }

    /**
     * @suppress
     */
    override fun toString(): String {
        return "$coordinates -> $value"
    }

    /**
     * Initializes this node for the Single-source-shortest-path algorithms
     */
    fun initSSSP() {
        predecessor = null
        distanceFromStart = 0
        searchState = SearchState.NOT_DISCOVERED
    }
}

/**
 * The state of the node when searching through the graph
 */
enum class SearchState {
    /**
     * Node has not been discovered yet
     */
    NOT_DISCOVERED,
    /**
     * Node has already been discovered (is in the queue or the stack)
     */
    DISCOVERED,
    /**
     * Node is fully searched
     */
    DONE
}

/**
 * Representing the graph
 *
 * @property nodes the list of nodes defining this graph
 */
data class Graph<T>(val nodes: List<Node<T>> = mutableListOf()) {

    /**
     * @suppress
     */
    override fun toString(): String {
        val sb = StringBuilder("")
        for (node in nodes) {
            sb.append("$node\n")
        }
        return sb.toString()
    }

    /**
     * Initializes the SSSP algorithm on this graph
     */
    fun initSSSP() {
        nodes.forEach { it.initSSSP() }
    }
}

/**
 * Performs the Breadth-first search on the given [graph]. Starting at the [startingNode]
 */
fun <T> bfs(graph: Graph<T>, startingNode: Node<T>) {
    val deque = LinkedList<Node<T>>()
    graph.initSSSP()
    startingNode.searchState = SearchState.DISCOVERED
    startingNode.distanceFromStart = 0
    deque.add(startingNode)
    while (deque.isNotEmpty()) {
        val node = deque.poll()
        for (succ in node.neighbors) {
            if (succ.searchState == SearchState.NOT_DISCOVERED) {
                succ.searchState = SearchState.DISCOVERED
                succ.predecessor = node
                succ.distanceFromStart = node.distanceFromStart + 1
                deque.add(succ)
            }
        }
        node.searchState = SearchState.DONE
    }
}

/**
 * After performing the BFS, this function computes the shortes path from the [target] to the BFS starting node
 */
fun <T> constructBFSPathToStart(target: Node<T>): List<Node<T>> {
    val result = mutableListOf(target)
    var predecessor = target.predecessor
    while (predecessor != null) {
        result.add(predecessor)
        predecessor = predecessor.predecessor
    }
    return result
}
