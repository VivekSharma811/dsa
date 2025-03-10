class TwoStacks<V>(private val arraySize: Int) {
    private val array: Array<Any?> = arrayOfNulls(arraySize) // Generic storage
    private var top1: Int = -1
    private var top2: Int = arraySize

    // Push element to Stack 1
    fun push1(value: V) {
        if (top1 < top2 - 1) {
            array[++top1] = value
        } else {
            throw StackOverflowError("Stack 1 Overflow")
        }
    }

    // Push element to Stack 2
    fun push2(value: V) {
        if (top1 < top2 - 1) {
            array[--top2] = value
        } else {
            throw StackOverflowError("Stack 2 Overflow")
        }
    }

    // Pop element from Stack 1
    fun pop1(): V? {
        return if (top1 >= 0) {
            array[top1--] as V
        } else {
            throw NoSuchElementException("Stack 1 Underflow")
        }
    }

    // Pop element from Stack 2
    fun pop2(): V? {
        return if (top2 < arraySize) {
            array[top2++] as V
        } else {
            throw NoSuchElementException("Stack 2 Underflow")
        }
    }
}

// ✅ Example Usage
fun main() {
    val twoStacks = TwoStacks<Int>(5)

    twoStacks.push1(1)
    twoStacks.push1(2)
    twoStacks.push2(10)
    twoStacks.push2(9)

    println("Pop from Stack 1: ${twoStacks.pop1()}") // Output: 2
    println("Pop from Stack 2: ${twoStacks.pop2()}") // Output: 9
}
