class SinglyLinkedList<T> {
    // Node class without `inner`
    class Node<T>(var data: T, var nextNode: Node<T>? = null)

    var headNode: Node<T>? = null
    var size: Int = 0
        private set

    fun isEmpty(): Boolean = headNode == null

    fun insertAtHead(data: T) {
        val newNode = Node(data) // ✅ No need for an instance of `SinglyLinkedList`
        newNode.nextNode = headNode
        headNode = newNode
        size++
    }

    fun printList() {
        if (isEmpty()) {
            println("List is Empty!")
            return
        }
        var temp = headNode
        print("List: ")
        while (temp != null) {
            print("${temp.data} -> ")
            temp = temp.nextNode
        }
        println("null")
    }
}

// ✅ Example Usage
fun main() {
    val list = SinglyLinkedList<Int>()
    list.insertAtHead(10)
    list.insertAtHead(20)
    list.insertAtHead(30)

    list.printList() // Output: List: 30 -> 20 -> 10 -> null
}
