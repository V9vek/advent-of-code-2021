data class Point(val x: Int, val y: Int)
data class LineSegment(val p1: Point, val p2: Point)

fun main() {
    val testInput = readInput("Day05_test")
    val input = readInput("day05")
    var max = 0

    fun getLineSegmentsList(input: List<String>): MutableList<LineSegment> {
        val pointsList = mutableListOf<Point>()
        val lineSegmentsList = mutableListOf<LineSegment>()
        for (line in input) {
            line.split(" -> ").forEach { point ->
                val x = point.split(",")[0].toInt()
                val y = point.split(",")[1].toInt()
                if (x > y && x > max) {
                    max = x
                } else if (y > x && y > max) {
                    max = y
                }
                pointsList.add(Point(x = x, y = y))
            }
        }
        for (i in 0 until pointsList.size step 2) {
            lineSegmentsList.add(LineSegment(p1 = pointsList[i], p2 = pointsList[i + 1]))
        }
        return lineSegmentsList
    }

    fun getMaxSizeMatrix(): Array<IntArray> {
        return Array(max + 1) { IntArray(max + 1) { 0 } }
    }

    fun printMatrix(matrix: Array<IntArray>) {
        for (i in 0..max) {
            for (j in 0..max) {
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

    fun findNumberOfOverlappingLines(matrix: Array<IntArray>): Int {
        var count = 0
        for (i in 0..max) {
            for (j in 0..max) {
                if (matrix[i][j] > 1) ++count
            }
        }

        return count
    }

    fun logic1(input: List<String>): Int {
        val lineSegmentsList = getLineSegmentsList(input)
        val matrix = getMaxSizeMatrix()

        lineSegmentsList.forEachIndexed { i, ls ->
            if (ls.p1.x == ls.p2.x) {
                val x = ls.p1.x
                var startY = ls.p1.y
                var endY = ls.p2.y
                val diff = startY - endY
                if (diff > 0) {
                    startY = ls.p2.y
                    endY = ls.p1.y
                }
//                println("X = $x, startY = $startY, endY = $endY")
                for (j in startY..endY) {
                    matrix[j][x] += 1
                }
//                printMatrix(matrix)
            } else if (ls.p1.y == ls.p2.y) {
                val y = ls.p1.y
                var startX = ls.p1.x
                var endX = ls.p2.x
                val diff = startX - endX
                if (diff > 0) {
                    startX = ls.p2.x
                    endX = ls.p1.x
                }
//                println("startX = $startX, endX = $endX, Y = $y")
                for (j in startX..endX) {
                    matrix[y][j] += 1
                }
//                printMatrix(matrix)
            }
        }

        return findNumberOfOverlappingLines(matrix)
    }

    fun logic2(input: List<String>): Int {
        return input.size
    }

    println(logic1(input))
    println(logic2(testInput))
}
