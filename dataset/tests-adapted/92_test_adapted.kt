val input = """
    be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
    edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
    fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
    fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
    aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
    fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
    dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
    bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
    egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
    gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce
""".trimIndent().lines()

fun main() {

    // Test 1: 1,4,7,8 appears 26 times
    run {
        val result = findNumbers(input)
        if (result != 26) {
            error("Test failed: Expected 26 but got $result")
        }
    }

    // Test 2: output values sum is 61229
    run {
        val result = findOutputSum(input)
        if (result != 61229) {
            error("Test failed: Expected 61229 but got $result")
        }
    }

    // Test 3: output value is 5353
    run {
        val result = outputValue(
            "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab".split(" "),
            "cdfeb fcadb cdfeb cdbaf".split(" ")
        )
        if (result != 5353) {
            error("Test failed: Expected 5353 but got $result")
        }
    }

    println("All tests passed!")
}
