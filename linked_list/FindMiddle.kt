fun findMiddle() {
    val list = getIntLinkedList()
    var slowPointer = list.headNode
    var fastPointer = list.headNode
    
    while(fastPointer != null && fastPointer.nextNode != null) {
        fastPointer = fastPointer.nextNode?.nextNode
        slowPointer = slowPointer?.nextNode
    }
    print("${slowPointer?.data}")
}