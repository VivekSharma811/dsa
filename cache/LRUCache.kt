import java.util.HashMap

class LRUCache(private val capacity: Int) {
    private data class Node(
        var key: Int,
        var value: Int,
        var next: Node? = null,
        var prev: Node? = null
    )

    private val map = java.util.HashMap<Int, Node>()
    private var head = Node(0,0)
    private var tail = Node(0,0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if(node != null) {
            node.value = value
            moveToFront(node)
        } else {
            if(map.size == capacity) {
                val lru = tail.prev!!
                remove(lru)
                map.remove(lru.key)
            }
            val newNode = Node(key, value)
            addToFront(newNode)
            map[key] = newNode
        }
    }

    private fun moveToFront(node: Node) {
        remove(node)
        addToFront(node)
    }

    private fun remove(node: Node) {
        node.next!!.prev = node.prev
        node.prev!!.next = node.next
    }

    private fun addToFront(node: Node) {
        node.next = head.next
        node.prev = head
        head.next!!.prev = node
        head.next = node
    }

    fun printCacheState() {
        var node = head.next
        print("🧠 Cache State: ")
        while (node != null && node != tail) {
            print("[${node.key}:${node.value}] → ")
            node = node.next
        }
        println("null")
    }
}

fun main() {
    val cache = LRUCache(2)

    cache.put(1, 10)
    cache.put(2, 20)
    cache.printCacheState()

    cache.get(1)
    cache.printCacheState()

    cache.put(3, 30)
    cache.printCacheState()
}
