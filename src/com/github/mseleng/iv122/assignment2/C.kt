package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.assignment1.gcd
import com.github.mseleng.iv122.util.integralPow
import com.github.mseleng.iv122.util.isWhole
import com.github.mseleng.iv122.util.nthRoot_approx_bisection

/**
 * A typealias representing the "decimal fraction", in other words numbers like 3(27/29)
 *
 * If we take the PI as 3.14, we could write 3.14 == 314/100 == 157/50 == 3(7/50)
 *
 * This "type" just helps us to prevent stack overflow when doing high exponentiations like 2^157
 */
typealias DecimalFraction = Pair<Long, Fraction>

/**
 * A class representing rational numbers as the fraction in the format [part]/[whole]
 *
 * E.g.: 3.14 == 157/50
 *
 * @param part
 * @param whole
 * @constructor creates a rational number in the format of a fraction
 * @property part
 * @property whole
 */
data class Fraction(val part: Long, val whole: Long) {
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
 * Returns the [exp]-th power of this number. The exponent may be a positive decimal
 *
 * @param exp a (potentionally) decimal exponent
 * @return the [exp]-th power of this
 */
fun rationalPower_1(base: Double, exp: Double): Double {
    if (exp.isWhole()) {
        return base.integralPow(exp.toLong())
    } else {
        val (int, frac) = exp.toFraction().toDecimalFraction()
        return base.integralPow(int) * (nthRoot_approx_bisection(base.integralPow(frac.part), frac.whole))
    }
}

/**
 * Returns the **simplified** fraction of this
 *
 * 3.14.toFraction() = 157/50
 */
fun Double.toFraction(): Fraction {
    val s = toString()
    val numerator = s.substringBefore('.').plus(s.substringAfter('.')).toLong()
    var denominator = 1L
    for (i in 1..s.substringAfter('.').length) {
        denominator *= 10
    }
    val gcd = gcd(numerator, denominator)
    return Fraction(numerator.div(gcd), denominator.div(gcd))
}

/**
 * The following method was intended to compute the rational power using the Euler's number and the natural logarithm,
 * but it made the stack overflow due to very high exponentiation
 *
 * a^b = e^(ln(a^b)) = e^(b*ln(a))
 * @suppress
 */
fun rationalPower_2(base: Double, exponent: Double): Nothing {
//    val lnBase = ln(base)
//    val expTimesLnBase = exponent.times(lnBase)
//    return e().pow(expTimesLnBase)
    error("Not implemented")
}

