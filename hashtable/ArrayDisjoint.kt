fun isDisjoint(arr1: IntArray, arr2: IntArray): Boolean {
    val hSet = HashSet<Int>()
    // Add all elements of arr1 to the set
    for (num in arr1) {
        if (!hSet.contains(num)) hSet.add(num)
    }

    // Check if any element in arr2 is also in arr1
    for (num in arr2) {
        if (hSet.contains(num)) return false
    }
    return true
}

fun main() {
    val inputArray1 = arrayOf(
        intArrayOf(2, 5, 10, 30, 45),
        intArrayOf(-5, -42, -31, -21, -10),
        intArrayOf(10, 20, -30, -40, 50),
        intArrayOf(100, 300),
        intArrayOf(500)
    )

    val inputArray2 = arrayOf(
        intArrayOf(3, 6, 13, 20, 23),
        intArrayOf(-1, -3, -5, -22, -15),
        intArrayOf(60, 70, 80, 90, 100),
        intArrayOf(300, 100),
        intArrayOf(200)
    )

    for (i in inputArray1.indices) {
        println("${i + 1}.\tArray1: ${inputArray1[i].contentToString()}")
        println("\tArray2: ${inputArray2[i].contentToString()}")
        println("\n\tResult: ${isDisjoint(inputArray1[i], inputArray2[i])}")
        println("-".repeat(100))
    }
}
