// Insert element at Tail of Linked List
fun insertAtTail() {
    val list = getIntLinkedList()
    val newNode = SinglyLinkedList.Node(5)
    if(list.isEmpty()) {
        list.headNode = newNode
    } else {
        var current = list.headNode
        while(current?.nextNode != null) {
            current = current.nextNode
        }
        current?.nextNode = newNode
    }
    list.printList()
}

fun getIntLinkedList(): SinglyLinkedList<Int> {
    val list = SinglyLinkedList<Int>()
    list.insertAtHead(10)
    list.insertAtHead(20)
    list.insertAtHead(30)
    return list
}
