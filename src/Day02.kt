fun main() {

    fun part1(input: List<String>): Int {
        var score = 0
        val rounds = input.windowed(1).map { round ->
            round.map {
                it.toCharArray()
            }
        }
        for (line in rounds.indices) {
            rounds[line].forEach {
                score += when (it[0]) {
                    'A' -> when (it[2]) {
                        'X' -> 1 + 3
                        'Y' -> 2 + 6
                        'Z' -> 3 + 0
                        else -> 0
                    }

                    'B' -> when (it[2]) {
                        'X' -> 1 + 0
                        'Y' -> 2 + 3
                        'Z' -> 3 + 6
                        else -> 0
                    }

                    'C' -> when (it[2]) {
                        'X' -> 1 + 6
                        'Y' -> 2 + 0
                        'Z' -> 3 + 3
                        else -> 0
                    }

                    else -> 0
                }
            }
        }
        return score
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
