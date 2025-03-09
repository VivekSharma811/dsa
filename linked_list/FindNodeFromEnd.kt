fun findNodeFromEnd() {
    val list = getIntLinkedList()
    list.printList()
    val count = 2
    var i = 0
    var element = list.headNode
    var end = list.headNode
    
    while(i < count) {
        end = end?.nextNode
        i++
    }
    while(end != null) {
        end = end.nextNode
        element = element?.nextNode
    }
    print("${element?.data}")
}