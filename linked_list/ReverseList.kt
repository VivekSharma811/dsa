fun main() {
    val list = getList()
    println("Current List")
    list.printList()
    list.head = reverseList(list.head)
    println("New List")
    list.printList()
}

fun reverseList(head: SinglyLinkedList.Node?): SinglyLinkedList.Node? {
    var current = head
    var prev: SinglyLinkedList.Node? = null

    while(current != null) {
        val next = current?.next
        current?.next = prev
        prev = current
        current = next
    }

    return prev
}
