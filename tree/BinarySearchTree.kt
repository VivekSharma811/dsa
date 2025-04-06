// Define the generic Node
data class TreeNode<T : Comparable<T>>(
    var value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

// Define the generic BST class
class BinarySearchTree<T : Comparable<T>> {

    private var root: TreeNode<T>? = null

    fun getRoot() = root

    // Insert a value into the tree
    fun insert(value: T) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: TreeNode<T>?, value: T): TreeNode<T> {
        if (node == null) return TreeNode(value)

        if (value < node.value) {
            node.left = insertRec(node.left, value)
        } else if (value > node.value) {
            node.right = insertRec(node.right, value)
        }

        return node
    }

    // Search for a value
    fun search(value: T): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(node: TreeNode<T>?, value: T): Boolean {
        return when {
            node == null -> false
            value == node.value -> true
            value < node.value -> searchRec(node.left, value)
            else -> searchRec(node.right, value)
        }
    }

    // In-order traversal
    fun inOrderTraversal(): List<T> {
        val result = mutableListOf<T>()
        inOrderRec(root, result)
        return result
    }

    private fun inOrderRec(node: TreeNode<T>?, result: MutableList<T>) {
        if (node != null) {
            inOrderRec(node.left, result)
            result.add(node.value)
            inOrderRec(node.right, result)
        }
    }

    fun preOrderTraversal(): List<T> {
        val result = mutableListOf<T>()
        preOrderRec(root, result)
        return result
    }

    private fun preOrderRec(node: TreeNode<T>?, result: MutableList<T>) {
        if (node != null) {
            result.add(node.value)
            preOrderRec(node.left, result)
            preOrderRec(node.right, result)
        }
    }

    fun postOrderTraversal(): List<T> {
        val result = mutableListOf<T>()
        postOrderRec(root, result)
        return result
    }

    private fun postOrderRec(node: TreeNode<T>?, result: MutableList<T>) {
        if (node != null) {
            postOrderRec(node.left, result)
            postOrderRec(node.right, result)
            result.add(node.value)
        }
    }

    // Delete a value from the tree
    fun delete(value: T) {
        root = deleteRec(root, value)
    }

    private fun deleteRec(node: TreeNode<T>?, value: T): TreeNode<T>? {
        if (node == null) return null

        when {
            value < node.value -> node.left = deleteRec(node.left, value)
            value > node.value -> node.right = deleteRec(node.right, value)
            else -> {
                if (node.left == null) return node.right
                if (node.right == null) return node.left

                node.value = minValue(node.right!!)
                node.right = deleteRec(node.right, node.value)
            }
        }
        return node
    }

    private fun minValue(node: TreeNode<T>): T {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.value
    }
}
