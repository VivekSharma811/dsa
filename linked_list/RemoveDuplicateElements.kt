fun main() {
    val list = getIntLinkedList()
    list.printList()
    list.headNode = removeDuplicateElements(list?.headNode)
    list.printList()
}

fun removeDuplicateElements(head: SinglyLinkedList.Node<Int>?): SinglyLinkedList.Node<Int>? {
    val list = getIntLinkedList()
    var outerNode = head

    while(outerNode != null) {
        var innerNode = outerNode
        while(innerNode != null && innerNode.nextNode != null) {
            if(innerNode.nextNode?.data == outerNode.data) {
                innerNode.nextNode = innerNode.nextNode?.nextNode
            } else {
                innerNode = innerNode.nextNode
            }
        }
        outerNode = outerNode.nextNode
    }
    return head
}