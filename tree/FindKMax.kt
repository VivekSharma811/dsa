fun main() {
    val bst = BinarySearchTree<Int>()

    bst.insert(10)
    bst.insert(3)
    bst.insert(2)
    bst.insert(4)
    bst.insert(13)
    bst.insert(11)
    bst.insert(14)

    println("In-order Traversal: ${bst.inOrderTraversal()}")

    println("Node: ${findKthMax(bst.getRoot(), 6)}")
}

fun <T : Comparable<T>> findKthMax(root: TreeNode<T>?, k: Int): T? {
    var count = 0
    var result: T? = null

    fun reverseInOrder(node: TreeNode<T>?) {
        if (node == null || count >= k) return

        reverseInOrder(node.right)

        count++
        if (count == k) {
            result = node.value
            return
        }

        reverseInOrder(node.left)
    }

    reverseInOrder(root)
    return result
}