fun main() {
    reverseInGroups()
}

fun reverseInGroups() {
    val list = getSinglyLinkedList()
    println("Current List")
    list.printList()
    val node = reverseKGroupsRec(list.head, 3)
    println("New List")
    list.printList(node)
}

fun reverseKGroupsRec(head: SinglyLinkedList.Node?, k: Int): SinglyLinkedList.Node? {
    if(head == null || k == 1) return head

    var count = 0
    var node = head

    while(node != null && count < k) {
        node = node.next
        count++
    }

    if(count < k) return head

    var prev: SinglyLinkedList.Node? = null
    var current = head
    var next: SinglyLinkedList.Node?

    repeat(k) {
        next = current?.next
        current?.next = prev
        prev = current
        current = next
    }

    head?.next = reverseKGroupsRec(current, k)

    return prev
}
