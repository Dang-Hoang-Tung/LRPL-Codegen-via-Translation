/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 23 - A Long Walk
 * Problem Description: http://adventofcode.com/2023/day/23
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day23/
 */

import kotlin.math.max

import kotlin.math.absoluteValue

data class Point2D(val x: Int, val y: Int) {
    fun neighbors(): Set<Point2D> =
        setOf(
            this + NORTH_WEST,
            this + NORTH,
            this + NORTH_EAST,
            this + WEST,
            this + EAST,
            this + SOUTH_WEST,
            this + SOUTH,
            this + SOUTH_EAST
        )

    fun cardinalNeighbors(): Set<Point2D> =
        setOf(
            this + NORTH,
            this + EAST,
            this + SOUTH,
            this + WEST
        )

    fun distanceTo(other: Point2D): Int =
        (x - other.x).absoluteValue + (y - other.y).absoluteValue

    operator fun minus(other: Point2D): Point2D =
        Point2D(x - other.x, y - other.y)

    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    operator fun times(amount: Int): Point2D =
        Point2D(x * amount, y * amount)

    companion object {
        val ORIGIN = Point2D(0, 0)
        val NORTH = Point2D(0, -1)
        val EAST = Point2D(1, 0)
        val SOUTH = Point2D(0, 1)
        val WEST = Point2D(-1, 0)
        val NORTH_WEST = NORTH + WEST
        val NORTH_EAST = NORTH + EAST
        val SOUTH_WEST = SOUTH + WEST
        val SOUTH_EAST = SOUTH + EAST
    }
}

fun Array<CharArray>.isSafe(at: Point2D) =
    at.y in this.indices && at.x in this[at.y].indices

operator fun Array<CharArray>.set(at: Point2D, c: Char) {
    this[at.y][at.x] = c
}

operator fun Array<CharArray>.get(at: Point2D): Char =
    this[at.y][at.x]

fun Array<CharArray>.swap(a: Point2D, b: Point2D) {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}


class Day23(input: List<String>) {

    private val grid = input.map { it.toCharArray() }.toTypedArray()
    private val start = Point2D(input.first().indexOfFirst { it == '.' }, 0)
    private val goal = Point2D(input.last().indexOfFirst { it == '.' }, input.lastIndex)

    fun solvePart1(): Int =
        traverse { location ->
            location.cardinalNeighbors()
                .filter { grid.isSafe(it) }
                .filter { newLocation -> grid[newLocation].matchesDirection(newLocation - location) }
                .map { it to 1 }
        }

    fun solvePart2(): Int {
        val reducedGrid = reduceGrid()
        return traverse { location ->
            reducedGrid
                .getValue(location)
                .map { it.key to it.value }
        }
    }

    private fun Char.matchesDirection(direction: Point2D): Boolean =
        when (this) {
            '^' -> Point2D.NORTH == direction
            '<' -> Point2D.WEST == direction
            'v' -> Point2D.SOUTH == direction
            '>' -> Point2D.EAST == direction
            '.' -> true
            else -> false
        }

    private fun traverse(nextLocations: (Point2D) -> List<Pair<Point2D, Int>>): Int {
        var best = 0
        val visited = mutableSetOf<Point2D>()

        fun traverseWork(location: Point2D, steps: Int):Int {
            if (location == goal) {
                best = max(steps, best)
                return best
            }
            visited += location
            nextLocations(location)
                .filter { (place, _) -> place !in visited }
                .forEach { (place, distance) -> traverseWork(place, distance + steps) }
            visited -= location
            return best
        }

        return traverseWork(start, 0)
    }

    private fun reduceGrid(): Map<Point2D, Map<Point2D, Int>> =
        grid.findDecisionPoints().let { decisionPoints ->
            decisionPoints.associateWith { point ->
                reduceGridFromPoint(point, decisionPoints)
            }
        }

    private fun reduceGridFromPoint(from: Point2D, toAnyOther: Set<Point2D>): Map<Point2D, Int> {
        val queue = ArrayDeque<Pair<Point2D, Int>>().apply {
            add(from to 0)
        }
        val seen = mutableSetOf(from)
        val answer = mutableMapOf<Point2D, Int>()
        while (queue.isNotEmpty()) {
            val (location, distance) = queue.removeFirst()
            if (location != from && location in toAnyOther) {
                answer[location] = distance
            } else {
                location.cardinalNeighbors()
                    .filter { grid.isSafe(it) }
                    .filter { grid[it] != '#' }
                    .filter { it !in seen }
                    .forEach {
                        seen += it
                        queue.add(it to distance + 1)
                    }
            }
        }
        return answer
    }

    private fun Array<CharArray>.findDecisionPoints() = buildSet {
        add(start)
        add(goal)
        this@findDecisionPoints.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                if (c != '#') {
                    Point2D(x, y).apply {
                        if (cardinalNeighbors()
                                .filter { grid.isSafe(it) }
                                .filter { grid[it] != '#' }.size > 2
                        ) {
                            add(this)
                        }
                    }
                }
            }
        }
    }
}