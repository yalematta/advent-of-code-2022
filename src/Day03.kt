
fun main() {

    fun findCommonItems(sacks: List<String>): Set<Char> {
        return sacks
            .map { it.toSet() }
            .reduce { init, item -> init.intersect(item) }
    }

    fun getPriority(commonChars: Set<Char>): Int {
        val items = ('a'..'z') + ('A'..'Z')
        var priority = 0
        commonChars.forEach { char ->
            priority += items.indexOf(char) + 1
        }
        return priority
    }

    fun part1(input: List<String>): Int {
        var priority = 0
        input.forEach { rucksack ->
            val length: Int = rucksack.length
            val firstComp: String = rucksack.substring(0, length / 2)
            val secondComp: String = rucksack.substring(length / 2)
            val commonItems = findCommonItems(listOf(firstComp, secondComp))
            priority += getPriority(commonItems)
        }
        return priority
    }

    fun part2(input: List<String>): Int {
        val windowSize = 3
        var priority = 0
        val groups =  input.windowed(size = windowSize, step = windowSize)
        groups.forEach { sacks ->
            val unique = findCommonItems(sacks)
            priority += getPriority(unique)
        }
        return priority
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
