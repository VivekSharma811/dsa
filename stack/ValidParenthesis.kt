fun main() {
    val result = validParenthesis("{}[]({[()]})")
    println(result)
}

fun validParenthesis(exp: String): Boolean {
    val stack = Stack<Char>(exp.length)
    for(char in exp.toCharArray()) {
        if(char == '}' || char == ']' || char == ')') {
            if(stack.isEmpty()) return false
            val topChar = stack.pop()
            if(char == '}' && topChar != '{' || char == ']' && topChar != '[' || char == ')' && topChar != '(') return false
        } else {
            stack.push(char)
        }
    }
    return stack.isEmpty()
}