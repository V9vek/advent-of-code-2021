fun main() {
    val testInput = readInput("Day01_test").map { it.toInt() }
    val input = readInput("day01").map { it.toInt() }

    fun logic1(input: List<Int>): Int {
        return input.size
    }

    fun logic2(input: List<Int>): Int {
        return input.size
    }

    println(logic1(testInput))
    println(logic2(testInput))
}
