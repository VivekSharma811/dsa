class MinHeap {
    private var heap = mutableListOf<Int>()

    fun peek(): Int? = heap.firstOrNull()

    fun isEmpty(): Boolean = heap.isEmpty()

    fun toList() = heap.toList()

    fun buildMinHeap(array: IntArray) {
        heap = mutableListOf()
        array.forEach { heap.add(it) }
        for(i in heap.size/2-1 downTo 0) minHeapify(i)
    }

    fun minHeapify(index: Int) {
        val size = heap.size
        var smallest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if(left < size && heap[left] < heap[smallest]) smallest = left
        if(right < size && heap[right] < heap[smallest]) smallest = right
        if(smallest != index) {
            heap[index] = heap[smallest].also { heap[smallest] = heap[index] }
            minHeapify(smallest)
        }
    }

    fun insert(value: Int) {
        heap.add(value)
        var index = heap.size - 1
        while(index > 0) {
            val parent = (index-1)/2
            if(heap[index] < heap[parent]) {
                heap[index] = heap[parent].also { heap[parent] = heap[index] }
                index = parent
            } else break
        }
    }

    fun extractMin(): Int? {
        if(heap.isEmpty()) return null
        val min = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        minHeapify(0)
        return min
    }
}

fun main() {
    val minHeap = MinHeap()
    minHeap.buildMinHeap(intArrayOf(20, 5, 15, 30, 10, 25, 40))

    println("Heap after build: ${minHeap.toList()}")
    println("Min element: ${minHeap.extractMin()}")
    println("Heap after extracting min: ${minHeap.toList()}")
}