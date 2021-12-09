fun main() {
    val testInput = readInput("Day09_test")
    val input = readInput("day09")

    val matrix = mutableListOf<MutableList<Int>>()

    fun getInitialList(input: List<String>) {
        input.forEach { line ->
            val row = mutableListOf<Int>()
            line.forEach { element ->
                row.add(Character.getNumericValue(element))
            }
            matrix.add(row)
        }
    }

    // Part 1
    fun part1() {
        var sum = 0
        val rowLen = matrix.size - 1
        val colLen = matrix[0].size - 1

        for (i in 0..rowLen) {
            for (j in 0..colLen) {
                val element = matrix[i][j]
                val up = if (i - 1 < 0) Int.MAX_VALUE else matrix[i - 1][j]
                val down = if (i + 1 > rowLen) Int.MAX_VALUE else matrix[i + 1][j]
                val left = if (j - 1 < 0) Int.MAX_VALUE else matrix[i][j - 1]
                val right = if (j + 1 > colLen) Int.MAX_VALUE else matrix[i][j + 1]

                if (element < up && element < down && element < left && element < right) {
                    sum += element + 1
                }
            }
        }

        println(sum)
    }

    // Part 2
    fun part2() {

    }

    getInitialList(testInput)
    part1()
    part2()
}













