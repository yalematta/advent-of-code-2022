fun main() {

    fun part1(input: List<String>): String {
        val parse = input.map { it.split("\n") }.flatten()
        val emptySpaceIndex = parse.indexOfFirst { it.isBlank() }
        val padding = parse[emptySpaceIndex - 1].length + 1
        val crates = parse.slice(0 until emptySpaceIndex - 1)
        val paddedCrates = crates.map { it.padEnd(padding, ' ').chunked(4) }.reversed()
        val parsedCrates = parseCrates(paddedCrates)
        val moves = parse.slice(emptySpaceIndex + 1 until parse.size)
        val initialStack = List(parsedCrates.size) { index -> index + 1 to parsedCrates[index] }.toMap()

        moves.map { move ->
            val instruction = instructionParser(move)
            moveCrate(instruction, initialStack)
        }

        return initialStack.values.joinToString("") { it.last() }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}

data class Instruction(val move: Int, val from: Int, val to: Int)

fun instructionParser(input: String): Instruction {
    val parse = input.split(" ").chunked(2).associate { it.first() to it.last().toInt() }
    return Instruction(move = parse["move"]!!, from = parse["from"]!!, to = parse["to"]!!)
}

fun parseCrates(input: List<List<String>>): List<MutableList<String>> {
    val crates = List(input[0].size) { mutableListOf<String>() }
    for (i in input[0].indices) {
        for (value in input) {
            if (value[i].isNotBlank()) crates[i].add(value[i].filter { it.isLetter() })
        }
    }
    return crates
}
fun moveCrate(instruction: Instruction, crates: Map<Int, MutableList<String>>) {
    repeat(instruction.move) {
        val topCrate = crates[instruction.from]?.last()
        crates[instruction.from]?.removeLast()
        if (topCrate != null) {
            crates[instruction.to]?.add(topCrate)
        }
    }
}
