package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.*

/**
 * @suppress
 */
fun kochLSystem(): List<Line> {
    return Turtle(
            LSystem(
                    "F--F--F",
                    mapOf('F' to "F+F--F+F"),
                    mapOf('F' to Forward(10.0),
                            '+' to Right(60.0),
                            '-' to Left(60.0))),
            3,
            Turtle.State(position = Coordinates(10, 250)))
            .lines
}

/**
 * @suppress
 */
fun sierpinskiLSystem(): List<Line> {
    return Turtle(
            LSystem(
                    "-A+B+A",
                    mapOf('A' to "B-A-B",
                            'B' to "A+B+A"),
                    mapOf('A' to Forward(3.0),
                            'B' to Forward(9.0),
                            '+' to Right(60.0),
                            '-' to Left(60.0))),
            6,
            Turtle.State(position = Coordinates(10, 690)))
            .lines
}

/**
 * @suppress
 */
fun treeLSystem(): List<Line> {
    return Turtle(
            LSystem(
                    "A",
                    mapOf('A' to "F[+A]-A",
                            'F' to "FF"),
                    mapOf('A' to Forward(3.0),
                            'F' to Forward(3.0),
                            '[' to Push(),
                            ']' to Pop(),
                            '+' to Right(45.0),
                            '-' to Left(45.0))),
            8,
            Turtle.State(Coordinates(350, 700), 90.0, true))
            .lines
}

/**
 * @suppress
 */
fun hilbertLSystem(): List<Line> {
    return Turtle(
            LSystem(
                    "A",
                    mapOf(
                            'A' to "-BF+AFA+FB-",
                            'B' to "+AF-BFB-FA+"),
                    mapOf(
                            'A' to StandStill(),
                            'B' to StandStill(),
                            'F' to Forward(15.0),
                            '+' to Right(90.0),
                            '-' to Left(90.0))),
            6,
            Turtle.State(position = Coordinates(10, 990))).lines
}

/**
 * @suppress
 */
fun hilbertLSystem2(): List<Line> {
    return Turtle(
            LSystem(
                    "A",
                    mapOf(
                            'A' to "-BF+AFA+FB-",
                            'B' to "+AF-BFB-FA+"),
                    mapOf(
                            'A' to StandStill(),
                            'B' to StandStill(),
                            'F' to Forward(15.0),
                            '+' to Right(89.0),
                            '-' to Left(91.0))),
            6,
            Turtle.State(position = Coordinates(10, 990))).lines
}

/**
 * Edge-rewriting
 *
 * @suppress
 */
fun plant1(): List<Line> {
    return Turtle(
            LSystem(
                    "F",
                    mapOf('F' to "F[+F]F[-F]F"),
                    mapOf(
                            'F' to Forward(4.0),
                            '+' to Right(25.7),
                            '-' to Left(25.7),
                            '[' to Push(),
                            ']' to Pop())),
            5,
            Turtle.State(position = Coordinates(250, 990), direction = 90.0)).lines
}

/**
 * Node-rewriting
 *
 * @suppress
 */
fun plant2(): List<Line> {
    return Turtle(
            LSystem(
                    "X",
                    mapOf('X' to "F[+X]F[-X]+X",
                            'F' to "FF"),
                    mapOf(
                            'F' to Forward(3.5),
                            '+' to Right(20.0),
                            '-' to Left(20.0),
                            '[' to Push(),
                            ']' to Pop())),
            7,
            Turtle.State(position = Coordinates(250, 990), direction = 90.0)).lines
}

/**
 * Node-rewriting
 *
 * @suppress
 */
fun plant3(): List<Line> {
    return Turtle(
            LSystem(
                    "X",
                    mapOf('X' to "F[+X][-X]FX",
                            'F' to "FF"),
                    mapOf(
                            'F' to Forward(3.8),
                            '+' to Right(25.7),
                            '-' to Left(25.7),
                            '[' to Push(),
                            ']' to Pop())),
            7,
            Turtle.State(position = Coordinates(250, 990), direction = 90.0)).lines
}

/**
 * Node-rewriting
 *
 * @suppress
 */
fun plant4(): List<Line> {
    return Turtle(
            LSystem(
                    "X",
                    mapOf('X' to "F[+X][-X]*FX", 'F' to "FF"),
                    mapOf(
                            'F' to Forward(1.5),
                            '*' to Right(3.7),
                            '+' to Right(45.7),
                            '-' to Left(45.7),
                            '[' to Push(),
                            ']' to Pop())),
            7,
            Turtle.State(position = Coordinates(500, 990), direction = 90.0)).lines
}

/**
 * @suppress
 */
fun kochIsland(): List<Line> {
    return Turtle(
            LSystem(
                    "F-F-F-F",
                    mapOf('F' to "F-F+F+FF-F-F+F"),
                    mapOf(
                            'F' to Forward(7.0),
                            '+' to Right(90.0),
                            '-' to Left(90.0))),
            3,
            Turtle.State(position = Coordinates(600, 600), direction = 90.0)).lines
}

/**
 * @suppress
 */
fun kochIsland2(): List<Line> {
    return Turtle(
            LSystem(
                    "F-F-F-F",
                    mapOf('F' to "F-F+F+FF-F-F+F"),
                    mapOf(
                            'F' to Forward(7.0),
                            '+' to Right(89.7),
                            '-' to Left(90.2))),
            3,
            Turtle.State(position = Coordinates(600, 600), direction = 90.0)).lines
}

/**
 * @suppress
 */
fun dragonCurve(): List<Line> {
    return Turtle(
            LSystem(
                    "FX",
                    mapOf(
                            'Y' to "-FX-Y",
                            'X' to "X+YF+"),
                    mapOf(
                            'F' to Forward(15.0),
                            '+' to Right(90.0),
                            '-' to Left(90.0))),
            14,
            Turtle.State(position = Coordinates(2300, 800), direction = 90.0)).lines
}

/**
 * @suppress
 */
fun plant5(): List<Line> {
    return Turtle(
            LSystem(
                    "X",
                    mapOf(
                            'X' to "F-[[X]+X]+F[+FX]-X",
                            'F' to "FF"),
                    mapOf(
                            'F' to Forward(3.5),
                            '+' to Right(25.0),
                            '-' to Left(25.0),
                            '[' to Push(),
                            ']' to Pop())),
            7,
            Turtle.State(position = Coordinates(100, 1000), direction = 65.0)).lines
}