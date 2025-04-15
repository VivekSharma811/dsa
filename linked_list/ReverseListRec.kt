fun main() {
    val list = getList()
    println("Current List")
    list.printList()
    list.head = reverseListRec(list.head)
    println("New List")
    list.printList()
}

fun reverseListRec(head: SinglyLinkedList.Node?): SinglyLinkedList.Node? {
    if(head?.next == null) return head

    val newHead = reverseListRec(head.next)
    head.next?.next = head
    head.next = null
    return newHead
}