class Queue<V>(private val maxSize: Int) {
    private val array: Array<Any?> = arrayOfNulls(maxSize) // Using Array<Any?> for generic storage
    private var front: Int = 0
    private var back: Int = -1
    private var currentSize: Int = 0

    // Returns the maximum size capacity
    fun getMaxSize(): Int = maxSize

    // Returns the current number of elements in the queue
    fun getCurrentSize(): Int = currentSize

    // Returns true if the Queue is empty
    fun isEmpty(): Boolean = currentSize == 0

    // Returns true if the Queue is full
    fun isFull(): Boolean = currentSize == maxSize

    // Returns the front element of the queue
    fun top(): V? {
        if (isEmpty()) return null
        return array[front] as V
    }

    // Adds an element to the queue
    fun enqueue(value: V) {
        if (isFull()) return
        back = (back + 1) % maxSize // Circular increment
        array[back] = value
        currentSize++
    }

    // Removes an element from the front of the queue and returns it
    fun dequeue(): V? {
        if (isEmpty()) return null
        val temp = array[front] as V
        front = (front + 1) % maxSize // Circular increment
        currentSize--
        return temp
    }

    fun printQueue() {
        if (isEmpty()) {
            println("Queue is Empty!")
            return
        }
        print("Queue: ")
        var index = front
        repeat(currentSize) {
            print("${array[index]} -> ")
            index = (index + 1) % maxSize // Circular traversal
        }
        println("null")
    }
}

// ✅ Example Usage
fun main() {
    val queue = Queue<Int>(5)
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    println("Front Element: ${queue.top()}") // Output: 10
    println("Dequeued: ${queue.dequeue()}") // Output: 10
    println("Dequeued: ${queue.dequeue()}") // Output: 20
    println("Is Queue Empty? ${queue.isEmpty()}") // Output: false
}
