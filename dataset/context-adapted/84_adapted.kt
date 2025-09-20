/**
 * 1006.笨阶乘 https://leetcode-cn.com/problems/clumsy-factorial/
 *
 * 解：以N=10为例，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *                            = (10 * 9 / 8) + (7) + (-6 * 5 / 4) + (3) + (-2 * 1)
 * 以每个括号内的值为单位，不停累加即可得出最终值
 */
fun clumsy(N: Int): Int {
    require(N >= 0)
    var result = 0
    var i = 0
    while (i < N) {
        val pair = getValue(N, i)
        result += pair.first
        i = pair.second
    }
    return result
}

private fun getValue(N: Int, i: Int): Pair<Int, Int> {
    require(i >= 0)
    var value = N - i
    if (i % 4 == 3) return value to i + 1
    check(i % 4 == 0)
    if (i < N - 1) {
        value *= N - i - 1
        if (i < N - 2) {
            value /= N - i - 2
        }
    }
    return if (i == 0) {
        value to 3
    } else {
        value * -1 to i + 3
    }
}
