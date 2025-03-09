fun findLength() {
    val list = getIntLinkedList()
    var current = list.headNode
    var size = 0
    
    while(current != null) {
        current = current.nextNode
        size++
    }
    print("${size}")
}