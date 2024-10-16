fun isBalanced(input: String): String {
    val stack = mutableListOf<Char>()
    val matchingBrackets = mapOf(')' to '(', '}' to '{', ']' to '[')

    for (char in input) {
        when (char) {
            '(', '{', '[' -> stack.add(char)
            ')', '}', ']' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != matchingBrackets[char]) {
                    return "NO"
                }
            }
        }
    }


    return if (stack.isEmpty()) "YES" else "NO"
}

fun main() {

    println("\n\n**************************")
    println("Balanced Brackets Challenge")

    val inputList = listOf("{ [ ( ) ] }","{ [ ( ] ) }","{ ( ( [ ] ) [ ] ) [ ] }")

    for(input in inputList){
        println("--------------------------")
        println("Input: $input")
        println("Output: ${isBalanced(input)}")
        println("--------------------------")
    }
}