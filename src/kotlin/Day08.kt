fun main() {
    val testInput = readInput("Day08_test")
    val input = readInput("day08")

    val uniqueSignalsList = mutableListOf<MutableList<String>>()
    val fourDigitValuesList = mutableListOf<MutableList<String>>()

    fun getInitialList(input: List<String>) {
        input.forEach { line ->
            val lineParts = line.split(" | ")
            uniqueSignalsList.add(lineParts[0].split(" ").toMutableList())
            fourDigitValuesList.add(lineParts[1].split(" ").toMutableList())
        }
    }

    // Part 1
    fun part1(input: List<String>) {
        var count1478 = 0
        fourDigitValuesList.forEach { values ->
            values.forEach { value ->
                if (value.length == 2 || value.length == 4 || value.length == 3 || value.length == 7)
                    ++count1478
            }
        }
        println("count1478 = $count1478")
    }

    // Part 2
    /*

    0: 6
    6: 6
    9: 6

    2: 5
    3: 5
    5: 5

    1: 2
    4: 4
    7: 3
    8: 7

    a: diff(len(3), len(2)) : 1-7
    b: diff(len(3), len(2)) :
    c: diff(len(3), len(2)) :
    d: diff(len(7), len(6)) : 8-0
    e: diff(len(6), len(5)) : 6-5
    f: diff(len(5), len(5)) :
    g: diff(len(3), len(2)) :
    */
    fun part2(input: List<String>) {

    }

    getInitialList(input)
    part1(input)
    part2(input)
}













