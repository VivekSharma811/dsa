fun main() {
    val bst = BinarySearchTree<Int>()

    bst.insert(22)
    bst.insert(12)
    bst.insert(32)
    bst.insert(8)
    bst.insert(18)
    bst.insert(25)
    bst.insert(36)
    bst.insert(6)
    bst.insert(10)
    bst.insert(14)
    bst.insert(19)
    bst.insert(24)
    bst.insert(26)
    bst.insert(34)
    bst.insert(38)

    println("In-order Traversal: ${bst.preOrderTraversal()}")

    val list = findAncestors(bst.getRoot(), 26)
    print("List -> ")
    list.reversed().forEach {
        print("$it, ")
    }
}

fun findAncestors(node: TreeNode<Int>?, k: Int): List<Int> {
    val ancestors = mutableListOf<Int>()
    findAncestorsRec(node, k, ancestors)
    return ancestors
}

fun findAncestorsRec(node: TreeNode<Int>?, k: Int, ancestors: MutableList<Int>): Boolean {
    if(node == null) return false

    if(node.value == k) return true

    val found = if(k < node.value) {
        findAncestorsRec(node.left, k, ancestors)
    } else {
        findAncestorsRec(node.right, k, ancestors)
    }

    if(found) {
        ancestors.add(node.value)
        return true
    }
    return false
}