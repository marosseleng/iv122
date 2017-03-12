package com.github.mseleng.iv122.assignment2

fun main(args: Array<String>) {
    val interval = 2500L
    println("PI approximation within $interval ms:")
    println("Monte Carlo method: ${pi_MonteCarlo(interval)}")
    println("Gregory-Leibnitz method: ${pi_GregoryLeibnitz(interval)}")
    println("Archimedes' method: ${pi_Archimedes(interval)}")
}

fun pi_MonteCarlo(interval_ms: Long): Double {
    return 0.0
}

fun pi_GregoryLeibnitz(interval_ms: Long): Double {
    return 0.0
}

fun pi_Archimedes(interval_ms: Long): Double {
    return 0.0
}
