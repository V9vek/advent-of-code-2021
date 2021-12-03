fun main() {
    val testInput = readInput("Day03_test")
    val input = readInput("day03")

    fun logic1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""

        for (bitIndex in 0 until input[0].length) {
            var count1 = 0
            var count0 = 0
            for (elementIndex in 0 until input.size) {
                if (input[elementIndex][bitIndex] == '1') ++count1
                else ++count0
            }

            if (count1 > count0) {
                gamma += 1
                epsilon += 0
            } else {
                gamma += 0
                epsilon += 1
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun logic2(input: List<String>): Int {
        var oxygenList = input
        var co2List = input

        // oxygen rating
        for (bitIndex in 0 until input[0].length) {
            var count1 = 0
            var count0 = 0
            for (elementIndex in 0 until oxygenList.size) {
                if (oxygenList[elementIndex][bitIndex] == '1') ++count1
                else ++count0
            }

            oxygenList = if (count1 >= count0) {
                oxygenList.filter { it[bitIndex] == '1' }
            } else {
                oxygenList.filter { it[bitIndex] == '0' }
            }

            if (oxygenList.size == 1) break
        }

        // co2 rating
        for (bitIndex in 0 until input[0].length) {
            var count1 = 0
            var count0 = 0
            for (elementIndex in 0 until co2List.size) {
                if (co2List[elementIndex][bitIndex] == '1') ++count1
                else ++count0
            }

            co2List = if (count1 >= count0) {
                co2List.filter { it[bitIndex] == '0' }
            } else {
                co2List.filter { it[bitIndex] == '1' }
            }

            if (co2List.size == 1) break
        }

        return oxygenList[0].toInt(2) * co2List[0].toInt(2)
    }

    println(logic1(input))
    println(logic2(input))
}











