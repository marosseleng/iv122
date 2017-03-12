package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.util.factorial
import com.github.mseleng.iv122.util.pow

fun run(args: Array<String>) {
    //A
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

    //B

    //C
    println(rationalPower_1(2.0, 0.5))
    println(rationalPower_1(3.0, 0.5))
    println(rationalPower_1(3.0, 3.14))
    println(rationalPower_1(2.0, 3.0))
//    println("*************************")
//    println(rationalPower_2(2.0, 3.0))
//    println(rationalPower_2(3.0, 0.5))
//    println(rationalPower_2(3.0, 3.14))

    //D
}
