package AOC2022.Day04

import AOC2022.readInput

fun main() {



    fun part1(input: List<String>): Int {
        var encapsulatedcount = 0
        input.forEachIndexed { i, s ->

            val parts = s.split(",","-")
            val min1= parts[0].toInt()
            val max1 = parts[1].toInt()
            val min2 = parts[2].toInt()
            val max2 = parts[3].toInt()

            if (min1 <= min2 && max1>=max2){
                encapsulatedcount+=1
            }
            else if (min2 <= min1 && max2>= max1){
                encapsulatedcount+=1
            }
        }

        return encapsulatedcount
    }

    fun part2(input: List<String>): Int {
        var noOverlap = 0
        input.forEachIndexed { i, s ->

            val parts = s.split(",","-")
            val min1= parts[0].toInt()
            val max1 = parts[1].toInt()
            val min2 = parts[2].toInt()
            val max2 = parts[3].toInt()

            if (max1 < min2){
                noOverlap +=1
                println("No Overlap")
            }
            else if (max2 < min1){
                noOverlap +=1
                println("No Overlap")
            }


        }

        return input.size-noOverlap


    }


    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))

}




