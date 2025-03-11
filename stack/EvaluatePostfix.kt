fun evaluatePostFix(exp: String): Int? {
    val stack = Stack<Int>(exp.length)
    
    for(char in exp.toCharArray()) {
        if(char.isDigit()) {
            stack.push(char.digitToInt())
        } else {
            val right = stack.pop()
            val left = stack.pop()
            if(right != null && left != null) {
                val result = applyOperator(char, left, right)
                result?.let { stack.push(it) }   
            }
        }
    }
    
    return stack.pop()
}

fun applyOperator(op: Char, num1: Int, num2: Int): Int {
    return when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> num1 / num2 // Assuming integer division
        else -> throw IllegalArgumentException("Invalid operator: $op")
    }
}