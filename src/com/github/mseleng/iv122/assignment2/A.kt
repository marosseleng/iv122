package com.github.mseleng.iv122.assignment2

/**
 * Returns the list of permutations of the given numbers
 *
 * @param numbers the list of numbers to be permuted
 * @return the list of permutations
 */
fun permutations(numbers: List<Int>): List<String> {
    val result = mutableListOf<String>()
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

/**
 * Returns the list of [k]-variations of the given numbers
 *
 * @param numbers the list of numbers to compute variations from
 * @param k the arity of the variations
 * @param allowRepetition pass true for the variations with the repetition
 * @return the list of [k]-variations
 */
fun variations(numbers: List<Int>, k: Int, allowRepetition: Boolean): List<String> {
    val result = mutableListOf<String>()
    if (k == 0) {
        return emptyList()
    }
    for (number in numbers) {
        val subList = if (allowRepetition) {
            numbers
        } else {
            numbers.minus(number)
        }
        val midResult = variations(subList, k - 1, allowRepetition).filter { it.length < k }
        if (midResult.isEmpty()) {
            result.add("$number")
        } else {
            midResult.mapTo(result) { "$number$it" }
        }
    }
    return result
}

/**
 * Returns the list of [k]-combinations of the given numbers
 *
 * @param numbers the list of numbers to compute combinations from
 * @param k the arity of the combinations
 * @param allowRepetition pass true for the combinations with the repetition
 * @return the list of [k]-combinations
 */
fun combinations(numbers: List<Int>, k: Int, allowRepetition: Boolean) = variations(numbers, k, allowRepetition).map(String::sorted).toSet()

/**
 * An extension function that sorts the letters inside of this
 *
 * @return this the with letters sorted alphabetically
 */
fun String.sorted(): String = toCharArray().sorted().joinToString(separator = "")
