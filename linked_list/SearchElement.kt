fun searchElement(): Boolean {
    val list = getIntLinkedList()
    var current = list.headNode
    val value = 20

    while(current?.nextNode != null) {
        if(current.data == value) {
            print("Found")
            return true
        }
        current = current.nextNode
    }
    print("Not found")
    return false
}