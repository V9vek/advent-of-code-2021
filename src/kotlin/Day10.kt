fun main() {
    val testInput = readInput("Day10_test")
    val input = readInput("day10")

    val corruptedLines = mutableListOf<Int>()

    // Part 1
    fun part1() {
        var score = 0

        input.forEachIndexed { i, chunk ->
            val stack = mutableListOf<Char>()
            chunk.forEach { bracket ->
                if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
                    stack.add(bracket)
                    return@forEach
                }

                if (bracket == ')' && stack.removeLast() != '(') {
                    score += 3
                    corruptedLines.add(i)
                    return@forEach
                } else if (bracket == ']' && stack.removeLast() != '[') {
                    score += 57
                    corruptedLines.add(i)
                    return@forEach
                } else if (bracket == '}' && stack.removeLast() != '{') {
                    score += 1197
                    corruptedLines.add(i)
                    return@forEach
                } else if (bracket == '>' && stack.removeLast() != '<') {
                    score += 25137
                    corruptedLines.add(i)
                    return@forEach
                }
            }
        }

        println(score)
    }

    // Part 2
    fun part2() {
        val scoreList = mutableListOf<Long>()

        input.forEachIndexed { i, chunk ->
            val stack = mutableListOf<Char>()

            if (!corruptedLines.contains(i)) {
                chunk.forEach { bracket ->
                    if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
                        stack.add(bracket)
                        return@forEach
                    }

                    if (bracket == ')' || bracket == ']' || bracket == '}' || bracket == '>') {
                        stack.removeLast()
                    }
                }

                var score = 0L
                stack.reversed().forEach {
                    when (it) {
                        '(' -> score = (5 * score) + 1
                        '[' -> score = (5 * score) + 2
                        '{' -> score = (5 * score) + 3
                        '<' -> score = (5 * score) + 4
                    }
                }
                scoreList.add(score)
            }
        }

        scoreList.sort()
        println(scoreList[scoreList.size / 2])
    }

    part1()
    part2()
}













