fun deleteElement() {
    val list = getIntLinkedList()
    var current = list.headNode
    var previous: SinglyLinkedList.Node<Int>? = null
    val element = 30

    if(current?.data == element) {
        list?.headNode = list.headNode?.nextNode
        list.printList()
        return
    }

    while(current?.nextNode != null) {
        if(current.data == element) {
            previous?.nextNode = current.nextNode
            current.nextNode = null
            break
        }
        previous = current
        current = current.nextNode
    }
    list.printList()
}