package com.github.mseleng.iv122.util

import java.util.*

/**
 * A helper class to work with the turtle graphics
 *
 * The initial direction of the turtle is 0.0 (the turtle is heading East)
 *
 * @constructor creates the turtle starting at [0;0]
 */
class Turtle() {

    /**
     * A class representing the state of a turtle
     *
     * @property position represents the coordinates, where the turtle currently stays
     * @property direction represents the azimuthal direction, which turtle is heading
     * @property penDown says whether the pen is down or not
     */
    class State(val position: Coordinates = Coordinates(0, 0), val direction: Double = 0.0, val penDown: Boolean = true)

    /**
     * @property currentDirection the direction this turtle is heading (default 0.0 -> EAST)
     */
    private var currentDirection: Double = 0.0
    private var currentPosition: Coordinates = Coordinates(0.0, 0.0)
    private var isPenDown = true
    private val currentDirectionRadians: Double
        get() = Math.toRadians(currentDirection)

    var currentState: State
        get() = State(currentPosition, currentDirection, isPenDown)
        private set(value) {
            currentPosition = value.position
            currentDirection = value.direction
            isPenDown = value.penDown
        }

    private val stack = ArrayDeque<State>()

    /**
     * @property lines the list of lines drawn by this turtle
     */
    val lines = mutableListOf<Line>()

    /**
     * Creates a turtle with the given initial state
     *
     * @param initialState the initial state of a turtle
     * @constructor creates an instance of turtle with the [initialState] set
     */
    constructor(initialState: State): this() {
        currentState = initialState
    }

    /**
     * Parses the given L-System and creates a turtle
     *
     * @param lSystem the defining L-System
     * @param depth the depth of grammar rule application
     * @param initialState the initial state of the turtle
     * @constructor a constructor to use with L-Systems
     */
    constructor(lSystem: LSystem, depth: Int, initialState: State): this(initialState) {
        var result = lSystem.axiom

        depth.timesRepeat {
            val stringBuilder = StringBuilder()
            result.forEach {
                stringBuilder.append(lSystem.grammarRules[it] ?: it.toString())
            }
            result = stringBuilder.toString()
        }

        result.forEach {
            lSystem.turtleRules.getOrDefault(it, StandStill()).function.invoke(this)
        }
    }

    /**
     * Pushes the current state to the stack
     */
    fun pushToStack() {
        stack.push(currentState)
    }

    /**
     * Loads the state from the stack
     */
    fun popStack() {
        if (stack.isNotEmpty()) {
            currentState = stack.pop()
        }
    }

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