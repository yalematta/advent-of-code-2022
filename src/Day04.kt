fun main() {

    fun parseInput(input: List<String>): List<List<Set<Int>>> {
        return input.map { line ->
            line.split(",")
                .map { section ->
                    section.split("-")
                        .map {
                            it.toInt()
                        }.let { (a, b) ->
                            (a..b).toSet()
                        }
                }
        }
    }

    fun part1(input: List<String>): Int {
        return parseInput(input).count { (a, b) ->
            a.containsAll(b) || b.containsAll(a)
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04_test")
    println(part1(input))
    println(part2(input))
}
