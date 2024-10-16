Problem: Balanced Bracket Checking

Time Complexity:

    The algorithm makes a single pass through the input string, processing each character exactly once.
    Each character is either pushed onto or popped from the stack, both of which are constant-time operations.
    Thus, the time complexity of the algorithm is O(n), where n is the length of the string.

Space Complexity:

    The space complexity is dominated by the stack, which stores unmatched opening brackets.
    In the worst case, all characters might be opening brackets, leading to a stack of size n.
    Hence, the space complexity is O(n).