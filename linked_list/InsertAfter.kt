fun insertAfter() {
    val list = getIntLinkedList()
    val newNode = SinglyLinkedList.Node(5)
    val after = 20
    var current = list.headNode
    while(current != null && current.data != after) {
        current = current.nextNode
    }
    current?.let {
        newNode.nextNode = current?.nextNode
        current.nextNode = newNode
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
