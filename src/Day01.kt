fun main() {

    fun part1(input: List<String>): Int {
        val elves = mutableListOf(0)
        input.forEach { line ->
            if (line.isBlank()) elves.add(0)
            else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
        }
        return elves.max()
    }

    fun part2(input: List<String>): Int {
        val elves = mutableListOf(0)
        input.forEach { line ->
            if (line.isBlank()) elves.add(0)
            else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
        }
        return elves.sortedDescending().subList(0, 3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
