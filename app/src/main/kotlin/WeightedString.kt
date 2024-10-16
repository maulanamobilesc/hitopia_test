fun getCharWeight(c: Char): Int {
    return c - 'a' + 1
}

fun weightedStrings(s: String, queries: List<Int>): List<String> {
    val weights = mutableSetOf<Int>()
    var currentChar: Char? = null
    var consecutiveCount = 0

    for (char in s) {
        val charWeight = getCharWeight(char)

        if (char == currentChar) {
            consecutiveCount++
        } else {
            currentChar = char
            consecutiveCount = 1
        }

        for (i in 1..consecutiveCount) {
            weights.add(charWeight * i)
        }
    }

    return queries.map { query ->
        if (query in weights) "Yes" else "No"
    }
}

fun main() {
    val inputPair = listOf(Pair("abbcccd", listOf(1, 3, 9, 8)), Pair("aaebcc", listOf(2, 3, 4, 1)),Pair("abcd", listOf(1, 2, 3, 4)))

    println("\n\n**************************")
    println("Weighted Strings Challenge")

    for(input in inputPair){
        val s = input.first
        val queries = input.second
        val result = weightedStrings(s, queries)
        println("--------------------------")
        println("s: $s")
        println("queries: $queries")
        println("result: $result")
        println("--------------------------")
    }
}
