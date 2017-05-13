package com.github.mseleng.iv122.util

import java.util.*

class Node<T>(val value: T, var coordinates: Coordinates) {

    /* BFS/DFS related fields */
    var predecessor: Node<T>? = null
    var distanceFromStart = 0
    var searchState: SearchState = SearchState.NOT_DISCOVERED

    /* neighbors in the graph (adjacent nodes)*/
    var neighbors: Set<Node<T>> = mutableSetOf()

    override fun equals(other: Any?): Boolean {
        return other != null
                && (other is Node<*>)
                && this.value == other.value
                && this.coordinates == other.coordinates
    }

    override fun hashCode(): Int {
        return Objects.hash(value)
    }
    override fun toString(): String {
        return "$coordinates -> $value"
    }
    fun initSSSP() {
        predecessor = null
        distanceFromStart = 0
        searchState = SearchState.NOT_DISCOVERED
    }
}

enum class SearchState {
    NOT_DISCOVERED, DISCOVERED, DONE
}

data class Graph<T>(val nodes: List<Node<T>> = mutableListOf()) {
    override fun toString(): String {
        val sb = StringBuilder("")
        for (node in nodes) {
            sb.append("$node\n")
        }
        return sb.toString()
    }
    fun initSSSP() {
        nodes.forEach { it.initSSSP() }
    }
}

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

fun <T> constructBFSPathToStart(target: Node<T>): List<Node<T>> {
    val result = mutableListOf(target)
    var predecessor = target.predecessor
    while (predecessor != null) {
        result.add(predecessor)
        predecessor = predecessor.predecessor
    }
    return result
}
