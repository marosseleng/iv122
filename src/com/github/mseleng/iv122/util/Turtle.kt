package com.github.mseleng.iv122.util

/**
 * A helper class to work with the turtle graphics
 *
 * The initial direction of the turtle is 0.0 (the turtle is heading East)
 *
 * @param currentPosition the coordinates of the starting point
 */
class Turtle(var currentPosition: Coordinates = Coordinates(0.0, 0.0)) {

    var currentDirection: Double = 0.0
    private var isPenDown = true
    private val currentDirectionRadians: Double
        get() = Math.toRadians(currentDirection)

    val lines = mutableListOf<Line>()

    /**
     * Lifts the pen
     */
    fun penUp() {
        isPenDown = false
    }

    /**
     * Puts the pen down
     */
    fun penDown() {
        isPenDown = true
    }

    /**
     * Goes forward in the [currentDirection]
     *
     * @param amount the distance to go
     */
    fun forward(amount: Int) {
        forward(amount.toDouble())
    }

    /**
     * Goes forward in the [currentDirection]
     *
     * @param amount the distance to go
     */
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

    /**
     * Does backward but stay in the [currentDirection]
     *
     * @param amount the distance to go
     */
    fun backward(amount: Int) {
        forward(amount.unaryMinus())
    }

    /**
     * Does backward but stay in the [currentDirection]
     *
     * @param amount the distance to go
     */
    fun backward(amount: Double) {
        forward(amount.unaryMinus())
    }

    /**
     * Turns left by the given amount of [degrees]
     *
     * @param degrees the amount of degrees to turn
     */
    fun left(degrees: Double) {
        currentDirection = (currentDirection + degrees).rem(360)
    }

    /**
     * Turns left by the given amount of [degrees]
     *
     * @param degrees the amount of degrees to turn
     */
    fun right(degrees: Double) {
        currentDirection = (currentDirection - degrees).rem(360)
    }

    /**
     * @suppress
     */
    override fun toString(): String {
        return "Turtle[currentPosition=$currentPosition, currentDirection=$currentDirection, isPenDown=$isPenDown]"
    }
}