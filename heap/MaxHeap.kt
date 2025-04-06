class MaxHeap {
    private var heap = mutableListOf<Int>()

    private fun maxHeapify(index: Int) {
        val size = heap.size
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < size && heap[left] > heap[largest]) largest = left
        if (right < size && heap[right] > heap[largest]) largest = right

        if (largest != index) {
            heap[index] = heap[largest].also { heap[largest] = heap[index] }
            maxHeapify(largest)
        }
    }

    fun buildMaxHeap(array: IntArray) {
        heap = mutableListOf()
        array.forEach { heap.add(it) }
        for (i in heap.size / 2 - 1 downTo 0) {
            maxHeapify(i)
        }
    }

    fun insert(value: Int) {
        heap.add(value)
        var index = heap.size - 1
        while (index > 0) {
            val parent = (index - 1) / 2
            if (heap[index] > heap[parent]) {
                heap[index] = heap[parent].also { heap[parent] = heap[index] }
                index = parent
            } else break
        }
    }

    fun extractMax(): Int? {
        if (heap.isEmpty()) return null
        val max = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        maxHeapify(0)
        return max
    }

    fun peek(): Int? = heap.firstOrNull()

    fun isEmpty(): Boolean = heap.isEmpty()

    fun toList(): List<Int> = heap.toList()
}

fun main() {
    val maxHeap = MaxHeap()
    maxHeap.buildMaxHeap(intArrayOf(1, 4, 7, 12, 15, 14, 9, 2, 3, 16))

    println("Heap after insertions: ${maxHeap.toList()}")
    println("Max element: ${maxHeap.extractMax()}")
    println("Heap after extracting max: ${maxHeap.toList()}")
}