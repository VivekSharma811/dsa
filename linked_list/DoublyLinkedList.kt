class DoublyLinkedList<T> {
    // Node class for Doubly Linked List
    class Node<T>(var data: T, var prevNode: Node<T>? = null, var nextNode: Node<T>? = null)

    var headNode: Node<T>? = null
    var tailNode: Node<T>? = null
    var size: Int = 0
        private set

    fun isEmpty(): Boolean = headNode == null

    // Insert at Head
    fun insertAtHead(data: T) {
        val newNode = Node(data, prevNode = null, nextNode = headNode)
        if (headNode != null) {
            headNode!!.prevNode = newNode
        } else {
            tailNode = newNode // If list was empty, set tail as well
        }
        headNode = newNode
        size++
    }

    // Insert at Tail
    fun insertAtTail(data: T) {
        if (isEmpty()) {
            insertAtHead(data)
            return
        }
        val newNode = Node(data, prevNode = tailNode, nextNode = null)
        tailNode!!.nextNode = newNode
        tailNode = newNode
        size++
    }

    // Delete a node
    fun deleteNode(data: T) {
        var temp = headNode
        while (temp != null) {
            if (temp.data == data) {
                if (temp.prevNode != null) {
                    temp.prevNode!!.nextNode = temp.nextNode
                } else {
                    headNode = temp.nextNode // Update head if first node is deleted
                }

                if (temp.nextNode != null) {
                    temp.nextNode!!.prevNode = temp.prevNode
                } else {
                    tailNode = temp.prevNode // Update tail if last node is deleted
                }

                size--
                return
            }
            temp = temp.nextNode
        }
    }

    // Print List in Forward Order
    fun printList() {
        if (isEmpty()) {
            println("List is Empty!")
            return
        }
        var temp = headNode
        print("List (Forward): ")
        while (temp != null) {
            print("${temp.data} ⇄ ")
            temp = temp.nextNode
        }
        println("null")
    }

    // Print List in Reverse Order
    fun printReverse() {
        if (isEmpty()) {
            println("List is Empty!")
            return
        }
        var temp = tailNode
        print("List (Reverse): ")
        while (temp != null) {
            print("${temp.data} ⇄ ")
            temp = temp.prevNode
        }
        println("null")
    }
}

// ✅ Example Usage
fun main() {
    val list = DoublyLinkedList<Int>()
    list.insertAtHead(10)
    list.insertAtHead(20)
    list.insertAtTail(5)
    list.insertAtTail(2)

    list.printList() // Output: List (Forward): 20 ⇄ 10 ⇄ 5 ⇄ 2 ⇄ null
    list.printReverse() // Output: List (Reverse): 2 ⇄ 5 ⇄ 10 ⇄ 20 ⇄ null

    list.deleteNode(10)
    list.printList() // Output: List (Forward): 20 ⇄ 5 ⇄ 2 ⇄ null
}
