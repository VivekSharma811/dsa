fun main() {
    val stack = getStack()
    stack.printStack()
    sortStack(stack)
    stack.printStack()
}

fun sortStack(stack: Stack<Int>): Stack<Int> {
    if(stack.isEmpty().not()) {
        val value = stack.pop()
        sortStack(stack)
        insertInStack(stack, value)
    }
    return stack
}

fun insertInStack(stack: Stack<Int>, value: Int?) {
    if(value == null) return

    if(stack.isEmpty() || (stack.top() ?: Int.MIN_VALUE) > value) {
        value?.let { stack.push(value) }
    } else {
        val temp = stack.pop()
        insertInStack(stack, value)
        temp?.let { stack.push(temp) }
    }
}

fun getStack(): Stack<Int> {
    val stack = Stack<Int>(10)
    stack.push(10)
    stack.push(1)
    stack.push(15)
    stack.push(5)
    stack.push(20)
    stack.push(7)
    stack.push(30)
    stack.push(3)
    stack.push(19)
    return stack
}