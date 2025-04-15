fun main() {
    val list = getList()
    println("Current List")
    list.printList()
    list.head = reverseKGroup(list.head, 2)
    println("New List")
    list.printList()
}

fun reverseKGroup(head: SinglyLinkedList.Node?, k: Int): SinglyLinkedList.Node? {
    if(head == null || k ==1) return head

    var count = 0
    var node = head
    while(node != null && count < k) {
        node = node.next
        count++
    }

    if(count == k) {
        var prev: SinglyLinkedList.Node? = null
        var current = head
        var next: SinglyLinkedList.Node?

        var i = 0

        while(i<k && current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
            i++
        }

        head.next = reverseKGroup(node, k)

        return prev
    }

    return head
}