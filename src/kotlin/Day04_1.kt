fun main() {
    val testInput = readInput("Day04_test")
    val input = readInput("day04")

    var boardCount = 0
    val rowCount = 5
    val elementCount = 5

    fun getDrawnNumbers(input: List<String>) = input[0].split(",").map { it.toInt() }

    fun getBingoBoards(input: List<String>): MutableList<Array<IntArray>> {
        val boards = mutableListOf<Array<IntArray>>()
        for (i in 2 until input.size step 6) {
            val matrixList = mutableListOf<IntArray>()
            for (j in 0..4) {
                val line = input[i + j].split(" ").filter { it.isNotBlank() }.map { it.toInt() }
                matrixList.add(line.toIntArray())
            }
            ++boardCount
            boards.add(matrixList.toTypedArray())
        }

        return boards
    }

    fun getVisitedBoard(input: List<String>): MutableList<Array<IntArray>> {
        val boards = mutableListOf<Array<IntArray>>()

        for (i in 2 until input.size step 6) {
            val matrixList = mutableListOf<IntArray>()
            for (j in 0..4) {
                val line = intArrayOf(0, 0, 0, 0, 0)
                matrixList.add(line)
            }
            boards.add(matrixList.toTypedArray())
        }

        return boards
    }

    fun checkForBingo(board: Array<IntArray>): Boolean {
        for (i in 0 until rowCount) {
            var sum = 0
            for (j in 0 until elementCount) sum += board[i][j]
            if (sum == 5) return true
        }

        for (i in 0 until rowCount) {
            var sum = 0
            for (j in 0 until elementCount) sum += board[j][i]
            if (sum == 5) return true
        }

        return false
    }

    fun showVisitedBoard(visited: MutableList<Array<IntArray>>) {
        for (i in 0 until boardCount) {
            for (j in 0 until rowCount) {
                for (k in 0 until elementCount) {
                    print("${visited[i][j][k]} ")
                }
                println()
            }
            println("-------------")
        }
    }

    fun logic1(input: List<String>): Int {
        val nums = getDrawnNumbers(input = input)
        val boards = getBingoBoards(input = input)
        val visited = getVisitedBoard(input = input)
        var winBoard = -1
        var winNumber = -1
        var gotRow = false
        var gotBoard = false

        for (num in nums) {
            for (i in 0 until boardCount) {
                for (j in 0 until rowCount) {
                    gotRow = false
                    for (k in 0 until elementCount) {
                        if (boards[i][j][k] == num) {
//                            println("num = $num, board = $i, row = $j, elementIndex = $k")
                            visited[i][j][k] = 1
                            gotRow = true

                            if (checkForBingo(board = visited[i])) {
//                                println("-------BINGO-----")
                                gotBoard = true
                                winBoard = i
                                winNumber = num
                            }

//                            showVisitedBoard(visited)
                            break
                        }
                    }
                    if (gotRow) break
                }
                if (gotBoard) break
            }
            if (gotBoard) break
        }

        println("winBoard = $winBoard, winNumber = $winNumber")

        var sumUnvisited = 0
        visited[winBoard].forEachIndexed { i, row ->
            row.forEachIndexed { j, element ->
                if (element == 0) {
                    sumUnvisited += boards[winBoard][i][j]
                }
            }
        }

        return sumUnvisited * winNumber
    }

    println(logic1(input))
}
























