class SinglyLinkedList<T> {

    // Node inner class
    inner class Node(var data: T, var nextNode: Node? = null)

    var headNode: Node? = null // Head node of the linked list
    var size: Int = 0          // Size of the linked list

    // Function to check if list is empty
    fun isEmpty(): Boolean = headNode == null

    // Inserts new data at the head of the linked list
    fun insertAtHead(data: T) {
        val newNode = Node(data)
        newNode.nextNode = headNode
        headNode = newNode
        size++
    }

    // Helper function to print the list
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

// 🔹 Example Usage
fun main() {
    val list = SinglyLinkedList<Int>()
    list.insertAtHead(10)
    list.insertAtHead(20)
    list.insertAtHead(30)

    list.printList() // Output: List: 30 -> 20 -> 10 -> null
}
