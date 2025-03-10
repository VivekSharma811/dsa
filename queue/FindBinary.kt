fun findBinary() {
    val n = 5
    val result = arrayOfNulls<String>(n)
    val queue = Queue<String>(n)

    queue.enqueue("1")

    for(i in 0 until n) {
        result[i] = queue.dequeue()

        val s1 = result[i] + "0"
        val s2 = result[i] + "1"

        queue.enqueue(s1)
        queue.enqueue(s2)
    }

    println(result.joinToString())
}