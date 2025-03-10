class Stack<V>(private val maxSize: Int) {
    private var top: Int = -1 // Initially, the stack is empty
    private val array: Array<Any?> = arrayOfNulls(maxSize) // Using Array<Any?> to store generic values

    // Returns the maximum size capacity
    fun getMaxSize(): Int = maxSize

    // Returns true if Stack is empty
    fun isEmpty(): Boolean = top == -1

    // Returns true if Stack is full
    fun isFull(): Boolean = top == maxSize - 1

    // Returns the value at the top of Stack
    fun top(): V? {
        if (isEmpty()) return null
        return array[top] as V
    }

    // Inserts a value to the top of Stack
    fun push(value: V) {
        if (isFull()) {
            println("Stack is Full!")
            return
        }
        array[++top] = value // Increment top and add value
    }

    // Removes a value from top of Stack and returns it
    fun pop(): V? {
        if (isEmpty()) return null
        return array[top--] as V // Return value at top and decrement top
    }
}

// ✅ Example Usage
fun main() {
    val stack = Stack<Int>(5)
    stack.push(10)
    stack.push(20)
    stack.push(30)

    println("Top Element: ${stack.top()}") // Output: 30
    println("Popped: ${stack.pop()}") // Output: 30
    println("Popped: ${stack.pop()}") // Output: 20
    println("Is Stack Empty? ${stack.isEmpty()}") // Output: false
}
