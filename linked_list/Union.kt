fun main() {
    val list = getIntLinkedList()
    val list2 = getIntLinkedList2()
    list.printList()
    list.headNode = union(list?.headNode, list2?.headNode)
    list?.printList()
}

fun union(head1: SinglyLinkedList.Node<Int>?, head2: SinglyLinkedList.Node<Int>?): SinglyLinkedList.Node<Int>? {
    if(head1 == null) {
        return head2
    }
    if(head2 == null) {
        return head1
    }
    var current = head1
    while(current?.nextNode != null) {
        current = current.nextNode
    }
    current?.nextNode = head2
    return removeDuplicateElements(head1)
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