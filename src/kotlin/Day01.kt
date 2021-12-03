fun main() {
    val testInput = readInput("Day01_test").map { it.toInt() }
    val input = readInput("day01").map { it.toInt() }

    fun logic1(input: List<Int>): Int {
        var count = 0
        var prevDepth = input[0]

        for (depth in input) {
            if (depth > prevDepth) ++count
            prevDepth = depth
        }

        return count
    }

    fun logic2(input: List<Int>): Int {
        var count = 0
        var prevSum = input[0] + input[1] + input[2]

        for (i in 1..(input.size - 3)) {
            val sum = input[i] + input[i+1] + input[i+2]
            if (sum > prevSum) ++count
            prevSum = sum
        }

        return count
    }

    println(logic1(input))
    println(logic2(input))
}
