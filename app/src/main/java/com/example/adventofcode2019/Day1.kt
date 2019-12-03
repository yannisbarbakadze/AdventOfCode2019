package com.example.adventofcode2019

import kotlin.math.floor

fun main() {
    println(part1())
    println(part2())
}

/**
 * Create a list containing the results of applying the division and subtraction to floor
 * and return their sum.
 */
private fun part1(): Int {
    val fuel = Utils.readFile("input1.txt").map { floor(it.toDouble().div(3).minus(2)) }
    return fuel.sum().toInt()
}

/**
 *  Calculate the initial fuel and add the additional fuel to the total recursively
 *  until the additional fuel is <= 0
 */
private fun part2(): Int {
    return Utils.readFile("input1.txt").map {
        val initialFuel = (it.toInt() / 3 - 2)
        initialFuel + additionalFuel(initialFuel)
    }.sum()
}

fun additionalFuel(fuel: Int): Int {
    val extraFuel = fuel / 3 - 2
    return if (extraFuel <= 0) 0 else extraFuel + additionalFuel(extraFuel)
}
