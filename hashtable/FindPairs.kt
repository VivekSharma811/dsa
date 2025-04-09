fun findPairs(nums: IntArray): Array<IntArray>? {
    val map = mutableMapOf<Int, IntArray>()

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            val sum = nums[i] + nums[j]

            if (map.containsKey(sum)) {
                return arrayOf(map[sum]!!, intArrayOf(nums[i], nums[j]))
            } else {
                map[sum] = intArrayOf(nums[i], nums[j])
            }
        }
    }
    return null // No matching pairs
}

fun main() {
    val numsList = arrayOf(
        intArrayOf(3, 4, 7, 1, 12, 9, 0),
        intArrayOf(1, 2, 3, 5, 8),
        intArrayOf(10, 20, 30, 40, 50, 60, 70, 5, 65, 15, 25),
        intArrayOf(-5, -3, -1, 0, 2, 4, 6),
        intArrayOf(0, 1, 2, 3, 4, 99)
    )

    numsList.forEachIndexed { index, nums ->
        println("${index + 1}.\tnums = ${nums.contentToString()}")
        val result = findPairs(nums)
        if (result != null) {
            println("\tFound pairs: ${result.contentDeepToString()}")
        } else {
            println("\tNo matching pairs found.")
        }
        println("-".repeat(100))
    }
}
