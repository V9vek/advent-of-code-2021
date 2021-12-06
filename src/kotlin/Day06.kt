fun main() {
    val testInput = readInput("Day06_test")[0].split(",").map { it.toInt() }
    val input = readInput("day06")[0].split(",").map { it.toInt() }

    fun getFishMap(input: List<Int>): MutableMap<Int, Long> {
        val fishMap = mutableMapOf<Int, Long>()
        for (i in 0..8) fishMap[i] = 0      // initialize with 0
        input.forEach { time ->
            fishMap[time] = fishMap[time]!! + 1
        }
        return fishMap
    }

    fun logic1(input: List<Int>): Int {
        val fishList = input.toMutableList()

        for (i in 1..18) {
            for (j in fishList.indices) {
                if (fishList[j] == 0) {
                    fishList[j] = 6
                    fishList.add(8)
                } else {
                    --fishList[j]
                }
            }
        }
        return fishList.size
    }

    fun logic2(input: List<Int>): Long {
        val fishMap = getFishMap(input)

        for (i in 1..256) {
            val fishMap0 = fishMap[0]!!
            for (j in 1..8) {
                fishMap[j - 1] = fishMap[j]!!
            }
            fishMap[8] = fishMap0
            fishMap[6] = fishMap[6]!! + fishMap0
//            println("Day $i = $fishMap")
        }

        return fishMap.values.sum()
    }

    println(logic1(testInput))
    println(logic2(input))
}
