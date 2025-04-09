fun findSymmetric(nums: Array<IntArray>): List<List<Int>> {
    val lookup = mutableSetOf<List<Int>>()
    val result = mutableListOf<List<Int>>()

    for (pair in nums) {
        val first = pair[0]
        val second = pair[1]
        val normal = listOf(first, second)
        val reversed = listOf(second, first)

        if (lookup.contains(reversed)) {
            result.add(normal)
            result.add(reversed)
        } else {
            lookup.add(normal)
        }
    }

    return result
}

fun main() {
    val testCases = arrayOf(
        arrayOf(intArrayOf(1, 2), intArrayOf(4, 6), intArrayOf(4, 3), intArrayOf(6, 4), intArrayOf(5, 9), intArrayOf(3, 4), intArrayOf(9, 5)),
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 5), intArrayOf(6, 7)),
        arrayOf(intArrayOf(1, 9), intArrayOf(9, 1)),
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)),
        arrayOf(intArrayOf(-8, -4), intArrayOf(7, 7), intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(-4, -8))
    )

    testCases.forEachIndexed { index, testCase ->
        println("${index + 1}.\tInput Array: ${testCase.joinToString(prefix = "[", postfix = "]") { it.contentToString() }}")
        val symmetric = findSymmetric(testCase)
        println("\n\tSymmetric pairs: $symmetric")
        println("-".repeat(100))
    }
}
