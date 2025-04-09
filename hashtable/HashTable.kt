class HashEntry(
    val key: String,
    var value: Int,
    var next: HashEntry? = null
)

class HashTable {
    private val slots = 10
    private var size = 0
    private val bucket = Array<HashEntry?>(slots) { null }

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

    private fun getIndex(key: String): Int {
        val hashCode = key.hashCode()
        return ((hashCode % slots) + slots) % slots // Handles negative hash codes
    }

    fun insert(key: String, value: Int) {
        val index = getIndex(key)
        var head = bucket[index]

        // Check if key exists and update value
        var current = head
        while (current != null) {
            if (current.key == key) {
                current.value = value
                return
            }
            current = current.next
        }

        // Insert at head of list
        val newEntry = HashEntry(key, value)
        newEntry.next = head
        bucket[index] = newEntry
        size++

        // Resize if load factor > 0.6
        if (size.toDouble() / slots >= 0.6) {
            resize()
        }
    }

    private fun resize() {
        val oldBucket = bucket
        slots *= 2
        bucket = arrayOfNulls(slots)
        size = 0

        for (entry in oldBucket) {
            var head = entry
            while (head != null) {
                insert(head.key, head.value)
                head = head.next
            }
        }
    }

    fun getValue(key: String): Int? {
        val index = getIndex(key)
        var head = bucket[index]

        while (head != null) {
            if (head.key == key) {
                return head.value
            }
            head = head.next
        }

        return null
    }

    fun delete(key: String): Int? {
        val index = getIndex(key)
        var head = bucket[index]
        var prev: HashEntry? = null

        // Traverse the linked list at the given index
        while (head != null) {
            if (head.key == key) break
            prev = head
            head = head.next
        }

        // If the key was not found
        if (head == null) return null

        // Reduce the size
        size--

        // Remove the node
        if (prev != null) {
            prev.next = head.next
        } else {
            bucket[index] = head.next
        }

        return head.value
    }
}
