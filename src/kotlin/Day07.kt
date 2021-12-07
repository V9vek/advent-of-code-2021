import kotlin.math.abs

fun main() {
    val testInput = readInput("Day07_test")[0].split(",").map { it.toInt() }
    val input = readInput("day07")[0].split(",").map { it.toInt() }

    fun getCostToPos1(input: List<Int>, pos1: Int): Int {
        var cost = 0
        input.forEach { pos ->
            cost += abs(pos - pos1)
        }
        return cost
    }

    fun getCostToPos2(input: List<Int>, pos2: Int): Int {
        var cost = 0
        input.forEach { pos ->
            val n = abs(pos - pos2)
            cost += n * (n + 1) / 2
        }
        return cost
    }

    // Part 1
    fun part1(input: List<Int>): Int {
        val min = input.minOf { it }
        val max = input.maxOf { it }

        var minCost = Int.MAX_VALUE

        for (i in min..max) {
            val cost = getCostToPos1(input, i)
            if (cost < minCost) {
                minCost = cost
            }
        }
        return minCost
    }

    // Part 2
    fun part2(input: List<Int>): Int {
        val min = input.minOf { it }
        val max = input.maxOf { it }

        var minCost = Int.MAX_VALUE

        for (i in min..max) {
            val cost = getCostToPos2(input, i)
            if (cost < minCost) {
                minCost = cost
            }
        }
        return minCost
    }

    println(part1(input))
    println(part2(input))
}
