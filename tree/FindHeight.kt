fun main() {
    val bst = BinarySearchTree<Int>()

    bst.insert(17)
    bst.insert(10)
    bst.insert(22)
    bst.insert(4)
    bst.insert(12)
    bst.insert(19)
    bst.insert(26)
    bst.insert(11)
    bst.insert(15)

    println("Pre-order Traversal: ${bst.preOrderTraversal()}")
    println("Height = ${getHeight(bst.getRoot())}")
}

fun getHeight(node: TreeNode<Int>?): Int {
    if(node == null) return 0
    val leftHeight = getHeight(node.left)
    val rightHeight = getHeight(node.right)
    return 1 + maxOf(leftHeight, rightHeight)
}