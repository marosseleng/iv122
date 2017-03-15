package com.github.mseleng.iv122.util

import java.awt.Color

/**
 * Created by mseleng on 3/7/17.
 */
class Turtle(offset: Coordinates? = null) {

    var currentPosition = offset ?: Coordinates(0.0, 0.0)
    var currentDirection: Double = 0.0
    var isPenDown = true
    private val currentDirectionRadians: Double
        get() = Math.toRadians(currentDirection)

    val lines = mutableListOf<Line>()
    private val defaultStyle = Style(Color.BLACK, 1, null)

    fun penUp() {
        isPenDown = false
    }

    fun penDown() {
        isPenDown = true
    }

    fun forward(amount: Int) {
        forward(amount.toDouble())
    }

    fun forward(amount: Double) {
        val a = Coordinates(Math.cos(currentDirectionRadians), Math.sin(currentDirectionRadians).unaryMinus())
                .times(amount)
                .trimToNDecimalPoints(2)
        val newPosition = a + currentPosition
        if (isPenDown) {
            lines.add(Pair(currentPosition, newPosition))
        }
        currentPosition = newPosition
    }

    fun backward(amount: Int) {
        forward(amount.unaryMinus())
    }

    fun backward(amount: Double) {
        forward(amount.unaryMinus())
    }

    fun left(degrees: Double) {
        currentDirection = (currentDirection + degrees).rem(360)
    }

    fun right(degrees: Double) {
        currentDirection = (currentDirection - degrees).rem(360)
    }
}