package com.terencepeh.leetcodepractice

fun sum(arr: IntArray): Int {
    println("Size = ${arr.size}")
    return when {
        arr.isEmpty() -> 0
        else -> arr[0] + sum(arr.copyOfRange(1, arr.size))
    }
}

fun count(list: List<Any>): Int {
    return when {
        list.isEmpty() -> 0
        else -> 1 + count(list.subList(1, list.size))
    }
}

private fun max(list: IntArray): Int = when {
    list.size == 2 -> if (list[0] > list[1]) list[0] else list[1]
    else -> {
        val subMax = max(list.copyOfRange(1, list.size))
        if (list[0] > subMax) list[0] else subMax
    }
}

fun main() {
    println(sum(intArrayOf(1, 2, 3, 4, 5)))
    println(count(listOf(1, 2, 3, 4, 5)))
    println(max(intArrayOf(1, 5, 10, 25, 16, 1))) // 25
}
