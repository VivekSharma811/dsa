fun main() {
    val list = SinglyLinkedList()
    val node5 = SinglyLinkedList.Node(50)
    val node4 = SinglyLinkedList.Node(40, node5)
    val node3 = SinglyLinkedList.Node(30, node4)
    val node2 = SinglyLinkedList.Node(20, node3)
    val node1 = SinglyLinkedList.Node(10, node2)
    node5.next = node2
    list.head = node1

    findLoopAndOrigin(list.head)?.let { node ->
        println("Loop found, originating at ${node.data}")
    } ?: println("No loop")
}

fun findLoopAndOrigin(head: SinglyLinkedList.Node?): SinglyLinkedList.Node? {
    var slow = head
    var fast = head

    while(fast?.next != null && fast?.next?.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if(slow == fast) {
            var start = head
            while(start != slow) {
                start = start?.next
                slow = slow?.next
            }
            return slow
        }
    }

    return null
}