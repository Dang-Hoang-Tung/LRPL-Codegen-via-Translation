import java.io.File

fun readContent(name: String) = File("src", "$name.txt").readText()

it = Day05()
val testInput1 = readContent(it.testInputName())
val testInput2 = readContent(it.testInputName2())

val testResult1 = it.part1(testInput1)
println("First test result: $testResult1")
check(testResult1 == it.testResult1())

val testResult2 = it.part2(testInput2)
println("Second test result: $testResult2")
check(testResult2 == it.testResult2())
