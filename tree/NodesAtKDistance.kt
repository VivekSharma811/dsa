fun main() {
    val bst = BinarySearchTree<Int>()

    bst.insert(10)
    bst.insert(4)
    bst.insert(20)
    bst.insert(2)
    bst.insert(30)
    bst.insert(6)

    println("Pre-order Traversal: ${bst.preOrderTraversal()}")
    val list = nodesAtKDistance(bst.getRoot(), 2)
    print("List -> ")
    list.reversed().forEach {
        print("$it, ")
    }
}

fun nodesAtKDistance(node: TreeNode<Int>?, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    dfs(node, k, result)
    return result
}

fun dfs(node: TreeNode<Int>?, k: Int, result: MutableList<Int>) {
    if(node == null) return

    if(k == 0) {
        result.add(node!!.value)
        return
    }

    dfs(node.left, k-1, result)
    dfs(node.right, k-1, result)
}