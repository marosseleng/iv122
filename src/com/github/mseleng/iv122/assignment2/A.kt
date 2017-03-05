package com.github.mseleng.iv122.assignment2

import java.util.ArrayList

fun Int.factorial(): Int {
    if (this <= 1) {
        return 1
    }
    var result = 1
    for (i in 1..this) {
        result *= i
    }
    return result
}

fun Int.pow(exp: Int): Int {
    return when {
        exp == 0 -> {
            1
        }
        exp > 0 -> {
            var res = 1
            for (i in 1..exp) {
                res *= this
            }
            res
        }
        else -> {
            1.div(pow(exp.unaryMinus()))
        }
    }
}

fun main(args: Array<String>) {
    val input = listOf(1, 2, 3, 4, 5)
    val k = 3
    val n = input.size
    println("INPUT: $input; k: $k")
    println("*****PERMUTATIONS*****")
    val permutations = permutations(input)
    println("Size is: ${permutations.size}. Should be: ${n.factorial()}")
    println(permutations)
    println("*****COMBINATIONS WITHOUT REPETITION*****")
    val combinationsWithoutRep = combinations(input, k, false)
    println("Size is: ${combinationsWithoutRep.size}. Should be: ${n.factorial().div((n.minus(k).factorial()).times(k.factorial()))}")
    println(combinationsWithoutRep)
    println("*****COMBINATIONS WITH REPETITION*****")
    val combinationsWithRep = combinations(input, k, true)
    println("Size is: ${combinationsWithRep.size}. Should be: ${n.plus(k).minus(1).factorial().div((n.minus(1).factorial()).times(k.factorial()))}")
    println(combinationsWithRep)
    println("*****VARIATIONS WITHOUT REPETITION*****")
    val variationsWithoutRep = variations(input, k, false)
    println("Size is: ${variationsWithoutRep.size}. Should be: ${n.factorial().div((n.minus(k).factorial()))}")
    println(variationsWithoutRep)
    println("*****VARIATIONS WITH REPETITION*****")
    val variationsWithRep = variations(input, k, true)
    println("Size is: ${variationsWithRep.size}. Should be: ${n.pow(k)}")
    println(variationsWithRep)
}

fun permutations(numbers: List<Int>): List<String> {
    val result = ArrayList<String>()
    for (number in numbers) {
        val midResult = permutations(numbers.minus(number))
        if (midResult.isEmpty()) {
            result.add("$number")
        } else {
            midResult.mapTo(result) { "$number$it" }
        }
    }
    return result
}

fun variations(numbers: List<Int>, k: Int, allowRepetition: Boolean): List<String> {
    val result = ArrayList<String>()
    if (k == 0) {
        return emptyList()
    }
    for (number in numbers) {
        val subList = if (allowRepetition) { numbers } else { numbers.minus(number) }
        val midResult = variations(subList, k - 1, allowRepetition).filter { it.length < k }
        if (midResult.isEmpty()) {
            result.add("$number")
        } else {
            midResult.mapTo(result) { "$number$it" }
        }
    }
    return result
}

fun combinations(numbers:List<Int>, k: Int, allowRepetition: Boolean) = variations(numbers, k, allowRepetition).map(String::sorted).toSet()

fun String.sorted(): String = toCharArray().sorted().joinToString(separator = "")
