package com.github.mseleng.iv122.util

import com.github.mseleng.iv122.assignment1.gcd

/**
 * A typealias representing the "decimal fraction", in other words numbers like 3(27/29)
 *
 * If we take the PI as 3.14, we could write 3.14 == 314/100 == 157/50 == 3(7/50)
 *
 * This "type" just helps us to prevent stack overflow when doing high exponentiations like 2^157
 */
typealias DecimalFraction = Pair<Int, Fraction>

/**
 * A class representing rational numbers as the fraction in the format [part]/[whole]
 *
 * E.g.: 3.14 == 157/50
 *
 * @param part
 * @param whole
 * @constructor creates a rational number in the format of a fraction
 */
data class Fraction(val part: Int, val whole: Int) {
    /**
     * Returns this rational number represented as a decimal fraction (when possible)
     *
     * If the number is less than one, this method returns something like this 0([part]/[whole])
     *
     * @return the [DecimalFraction] representing this rational number
     */
    fun toDecimalFraction(): DecimalFraction {
        if (part < whole) {
            return DecimalFraction(0, this)
        } else {
            val int = part.div(whole)
            return DecimalFraction(int, copy(part = part.minus(int.times(whole))))
        }
    }
}

/**
 * Says whether this is a prime number or not.
 *
 * @return true iff this is a prime number, false otherwise
 */
fun Int.isPrime() = this > 1 && (2..(this.div(2))).all{ this.rem(it) != 0 }

/**
 * Computes the fraction for the given part and the whole
 *
 * @param part
 * @param whole
 * @return a double = [part].div([whole])
 */
fun fraction(part: Int, whole: Int) = part.toDouble().div(whole)

/**
 * Says whether this and [other] differ at most by [eps]
 *
 * @param other
 * @param eps
 * @return true, iff this and [other] differ at most by [eps], false otherwise
 */
fun Double.isAlmostEqual(other: Double, eps: Double): Boolean = Math.abs(this.minus(other)) <= eps

/**
 * Returns the square of this
 *
 * @return the square
 */
fun Double.square(): Double = times(this)

/**
 * Returns the square of this
 *
 * @return the square
 */
fun Int.square(): Int = times(this)

/**
 * Returns the [exp]-th power of this number. The exponent may be a positive decimal
 *
 * @param exp a (potentionally) decimal exponent
 * @return the [exp]-th power of this
 */
fun Int.pow(exp: Double) = toDouble().pow(exp)

/**
 * Returns the [exp]-th power of this number, when the exponent is an integer
 *
 * @param exp the integral exponent
 * @return the [exp]-th power of this
 */
fun Int.integralPow(exp: Int) = toDouble().integralPow(exp).toInt()

/**
 * Returns the **simplified** fraction of this
 *
 * 3.14.toFraction() = 157/50
 */
fun Double.toFraction(): Fraction {
    val s = toString()
    val numerator = s.substringBefore('.').plus(s.substringAfter('.')).toInt()
    var denominator = 1
    for (i in 1..s.substringAfter('.').length) {
        denominator *= 10
    }
    val gcd = gcd(numerator, denominator)
    return Fraction(numerator.div(gcd), denominator.div(gcd))
}

/**
 * Returns true iff this decimal number has decimal part == 0
 *
 * 2.0.isWhole() == true; 2.01.isWhole() == false;
 *
 * @return true iff this number is whole, false otherwise
 */
fun Double.isWhole(): Boolean = rem(1) == 0.toDouble()

/**
 * Returns the [exp]-th power of this number. The exponent may be a positive decimal
 *
 * @param exp a (potentionally) decimal exponent
 * @return the [exp]-th power of this
 */
fun Double.pow(exp: Double): Double {
    if (exp.isWhole()) {
        return integralPow(exp.toInt())
    } else {
        val (int, frac) = exp.toFraction().toDecimalFraction()
        return integralPow(int) * (nthRoot_approx_bisection(integralPow(frac.part), frac.whole) ?: 0.0)
    }
}

/**
 * Returns the [exp]-th power of this number, when the exponent is an integer
 *
 * @param exp the integral exponent
 * @return the [exp]-th power of this
 */
fun Double.integralPow(exp: Int): Double {
    return when {
        exp == 0 -> {
            1.toDouble()
        }
        exp > 0 -> {
            var res = 1.toDouble()
            for (i in 1..exp) {
                res *= this
            }
            res
        }
        else -> {
            1.div(integralPow(exp.unaryMinus()))
        }
    }
}

/**
 * Approximates (using the bisection) the square root of the given number
 *
 * @param num the number, whose square root we want to approximate
 * @param from the lower bound of the interval (default = 0.0)
 * @param to the upper bound of the interval (default ⌊([num] / 2)⌋ + 1; as (x/2 + 1) grows faster than sqrt(x))
 * @param eps the desired accuracy (default = 0.000001)
 * @return see [bisection]
 */
fun sqrt_approx_bisection(num: Double, from: Double = 0.0, to: Double = Math.floor(num.div(2.0)).plus(1), eps: Double = 0.00001)
        = bisection(num, from, to, eps, Double::square)

/**
 * Approximates (using the bisection) the [order]-th root of [num]
 *
 * @param num the number, whose root we want to approximate
 * @param order the order of the root
 * @param from the lower bound of the interval (default = 0.0)
 * @param to the upper bound of the interval (default ⌊([num] / [order])⌋ + 1; as linear function grows faster than the root function)
 * @param eps the desired accuracy (default = 0.000001)
 * @return see [bisection]
 */
fun nthRoot_approx_bisection(num: Double, order: Int, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.00001)
        = bisection(num, from, to, eps) { it.integralPow(order) }

/**
 * Approximates the number using bisection
 *
 * As this function cannot take a parameter representing the number that we want to approximate (because we do not know
 * the value of that number, that's why we want to approximate) one should provide the "validation function", which takes
 * the actual approximated number as a parameter and test whether that "validated" value is near enough to the target.
 *
 * Let's say, we want to approximate the square root of 5 (√5); we pass 5 to the [num] parameter and the squaring function
 * to the [validate] parameter
 *
 * @param num the "target" number; This is not he number that we want to approximate; this is the number,
 * close to which we want to get by applying [validate] on the approximated one
 * @param from the lower bound of the interval
 * @param to the upper bound of the interval
 * @param eps the desired accuracy (default = 0.000001)
 * @param validate the validation function
 * @return null, iff the value with the given accuracy could not be found within the given interval, or the approximated value otherwise
 */
fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double? {
    if (to < from) {
        return null
    }
    val mid: Double = from.plus(to).div(2)
    val midValidated = validate(mid)
    if (midValidated.isAlmostEqual(num, eps)) {
        return mid
    } else if (midValidated < num) {
        return bisection(num, mid.plus(eps), to, eps, validate)
    } else {
        return bisection(num, from, mid.minus(eps), eps, validate)
    }
}