fun main() {

    fun findCommonItems( s1: String,  s2: String): Set<Char> {
        val set: MutableSet<Char>  =  HashSet<Char>()
        for (c in s1.toCharArray()) {
            if (s2.indexOf(c) >= 0) {
                set.add(c)
            }
        }
        return set
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
            val commonItems = findCommonItems(firstComp, secondComp)
            priority += getPriority(commonItems)
        }
        return priority
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
