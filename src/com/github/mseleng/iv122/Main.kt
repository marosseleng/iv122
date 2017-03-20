package com.github.mseleng.iv122

/**
 * @suppress
 */
fun main(args: Array<String>) {
    val path = args.getOrElse(0) { "iv122_outputs" }
    println("IV122")
    println("Output directory: $path/\n\n")
    println("***The first assignment***")
    com.github.mseleng.iv122.assignment1.run(path)
    println("Complete.\n\n***The second assignment***")
    com.github.mseleng.iv122.assignment2.run(path)
    println("Complete.\n\n***The third assignment***")
    com.github.mseleng.iv122.assignment3.run(path)
    println("Complete.\n")
}
