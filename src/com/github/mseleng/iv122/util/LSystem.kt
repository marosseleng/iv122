package com.github.mseleng.iv122.util

/**
 * Sealed class representing the possible turtle directions
 *
 * @param
 * @property function a function to invoke on the turtle
 */
sealed class TurtleDirections(val function: Turtle.() -> Unit)

/**
 * A subclass of [TurtleDirections] representing the forward move
 *
 * @param amount the amount to move
 */
class Forward(amount: Double) : TurtleDirections({ forward(amount) })

/**
 * A subclass of [TurtleDirections] representing the backward move
 *
 * @param amount the amount to move
 */
class Backward(amount: Double) : TurtleDirections({ backward(amount) })

/**
 * A subclass of [TurtleDirections] representing the left rotation
 *
 * @param degrees the amount to turn
 */
class Left(degrees: Double) : TurtleDirections({ left(degrees) })

/**
 * A subclass of [TurtleDirections] representing the right rotation
 *
 * @param degrees the amount to turn
 */
class Right(degrees: Double) : TurtleDirections({ right(degrees) })

/**
 * A subclass of [TurtleDirections] representing the push to the stack
 */
class Push : TurtleDirections({ pushToStack() })

/**
 * A subclass of [TurtleDirections] representing the pop from the stack
 */
class Pop : TurtleDirections({ popStack() })

/**
 * A subclass of [TurtleDirections] representing the default fallback (the turtle does nothing)
 */
class StandStill : TurtleDirections({})

/**
 * A subclass of [TurtleDirections] representing the custom defined movement of the turtle
 */
class Custom(function: Turtle.() -> Unit): TurtleDirections(function)

/**
 * The typealias for the grammar rules within the L-System
 *
 * The map Char->String
 */
typealias LSystemGrammarRules = Map<Char, String>

/**
 * The typealias for the turtle rules within the L-System
 *
 * The map Char->TurtleDirections
 */
typealias LSystemTurtleRules = Map<Char, TurtleDirections>

/**
 * Class representing the L-system
 *
 * @property axiom the starting string
 * @property grammarRules the rules to apply while rewriting
 * @property turtleRules the rules to apply when controlling the turtle
 * @constructor Creates a L-System defined by its axiom, its grammar and turtle rules
 */
class LSystem(val axiom: String, val grammarRules: LSystemGrammarRules, val turtleRules: LSystemTurtleRules)


