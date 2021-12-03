fun main() {
    val testInput = readInput("Day02_test")
    val input = readInput("day02")

    fun logic1(input: List<String>): Int {
        var height = 0
        var depth = 0

        for (course in input) {
            val splitString = course.split(" ")
            val direction = splitString[0]
            val metric = splitString[1].toInt()
            when (direction) {
                "up" -> depth -= metric
                "down" -> depth += metric
                "forward" -> height += metric
            }
        }

        return height * depth
    }

    fun logic2(input: List<String>): Int {
        var height = 0
        var depth = 0
        var aim = 0

        for (course in input) {
            val splitString = course.split(" ")
            val direction = splitString[0]
            val metric = splitString[1].toInt()
            when (direction) {
                "up" -> aim -= metric
                "down" -> aim += metric
                "forward" -> {
                    height += metric
                    depth += aim * metric
                }
            }
        }

        return height * depth
    }

    println(logic1(input))
    println(logic2(input))
}













