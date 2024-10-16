fun findHighestPalindrome(s: CharArray, k: Int): String {
    val n = s.size
    val result = recursivePalindrome(s, 0, n - 1, k)
    return result ?: "-1"
}

fun recursivePalindrome(s: CharArray, left: Int, right: Int, k: Int): String? {
    if (left > right) {
        return String(s)
    }

    if (k < 0) {
        return null
    }

    return if (s[left] == s[right]) {
        if (s[left] != '9') {//same but not 9
            checkMaxDigit(s, left, right, k)
        } else {//same and it's 9`
            recursivePalindrome(s, left + 1, right - 1, k)
        }
    } else {
        checkMaxDigit(s, left, right, k)
    }
}

fun checkMaxDigit(
    s: CharArray,
    left: Int,
    right: Int,
    k: Int,
): String? {
    val kDecrement = if ((k < 2) || (k >= 2 && (s[left] == '9' || s[right] == '9'))) 1 else 2
    val maxDigit = if (k < 2) maxOf(s[left], s[right]) else '9'
    s[left] = maxDigit
    s[right] = maxDigit


    return recursivePalindrome(s, left + 1, right - 1, k - kDecrement)
}

fun main() {
    val inputList = listOf(Pair("3943", 1),Pair("932239", 2),Pair("18239", 1))

    println("\n\n**************************")
    println("Highest Palindrome Challenge")

    for (input in inputList) {
        println("--------------------------")
        println("s: ${input.first}")
        println("k: ${input.second}")
        println("Output: ${findHighestPalindrome(input.first.toCharArray(), input.second)}")
        println("--------------------------")
    }
}
