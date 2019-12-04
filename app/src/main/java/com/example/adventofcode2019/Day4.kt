package com.example.adventofcode2019

private val input = 172851..675869

fun main() {
    println(findPossiblePasswords(input))
}

private fun findPossiblePasswords(input: IntRange) {
    var countForPart1 = 0
    var countForPart2 = 0

    for (i in input) {
        val numAsCharArray = i.toString().map { it }
        if (areDigitsIncreasing(numAsCharArray)) {
            if (hasAtLeastOneDouble(numAsCharArray)) {
                countForPart1++
            }
            if (hasExactlyTwoDoubles(numAsCharArray)) {
                countForPart2++
            }

        }
    }
    println(countForPart1)
    println(countForPart2)
}

fun areDigitsIncreasing(numAsChar: List<Char>): Boolean {
    return numAsChar == numAsChar.sorted()
}

fun hasAtLeastOneDouble(numAsChar: List<Char>): Boolean {
    return numAsChar.groupBy { it }.filter { it.value.size >= 2 }.isNotEmpty()
}

fun hasExactlyTwoDoubles(numAsChar: List<Char>): Boolean {
    return numAsChar.groupBy { it }.filter { it.value.size == 2 }.isNotEmpty()
}
