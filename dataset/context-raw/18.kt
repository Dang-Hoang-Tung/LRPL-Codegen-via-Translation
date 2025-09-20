package com.adventofcode.year2021.day3.part2

import com.adventofcode.year2021.day
import java.math.BigInteger

fun List<String>.mostCommonBit(column: Int): Char {
  return when (count { it[column] == '1' } >= count { it[column] == '0' }) {
    true -> '1'
    else -> '0'
  }
}

fun List<String>.leastCommonBit(column: Int): Char {
  return when (count { it[column] == '0' } <= count { it[column] == '1' }) {
    true -> '0'
    else -> '1'
  }
}

tailrec fun List<String>.filterBy(detectBitCriteria: List<String>.(Int) -> Char, column: Int = 0): BigInteger {
  val bitCriteria = detectBitCriteria(column)
  val foundedNumbers = filter { it[column] == bitCriteria }
  return when (foundedNumbers.size > 1) {
    true -> foundedNumbers.filterBy(detectBitCriteria, column + 1)
    else -> BigInteger(foundedNumbers.first(), 2)
  }
}


fun main() {
  val allBinaryNumbers = day(3)
  val oxygenGeneratorRating = allBinaryNumbers.filterBy(List<String>::mostCommonBit)
  val co2ScrubberRating = allBinaryNumbers.filterBy(List<String>::leastCommonBit)
  println(oxygenGeneratorRating * co2ScrubberRating)
}
