package com.example.adventofcode2019

private val input = Utils.readText("input2.txt").split(",").map { it.trim().toInt() }

fun main() {
    println(part1(12, 2))
    println(part2())
}

private fun part1(noun: Int, verb: Int): Int {
    val input = input.toMutableList()
    input[1] = noun
    input[2] = verb
    for (i in input.indices step 4) {
        when (input[i]) {
            1 -> input[input[i + 3]] = input[input[i + 1]] + input[input[i + 2]]
            2 -> input[input[i + 3]] = input[input[i + 1]] * input[input[i + 2]]
            99 -> return input[0]
        }
    }
    return input[0]
}

private fun part2(): Int {
    for (noun in 0..99) {
        for (verb in 0..99) {
            if (part1(noun, verb) == 19690720) {
                return (noun * 100) + verb
            }
        }
    }
    throw IllegalStateException("Cannot find necessary noun/verb to produce the output 19690720")
}