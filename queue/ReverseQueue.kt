fun reverseQueue(queue: Queue<Int>, k: Int): Queue<Int> {
    if(queue.isEmpty() || k < 0 || k > queue.getMaxSize()) {
        return queue
    }

    val stack = Stack<Int>(k)
    for(i in 0 until k) {
        queue.dequeue()?.let { stack.push(it) }
    }

    while(stack.isEmpty().not()) {
        stack.pop()?.let { queue.enqueue(it) }
    }

    val leftCount = queue.getMaxSize() - k
    for(i in 0 until leftCount) {
        queue.dequeue()?.let { queue.enqueue(it) }
    }

    return queue
}