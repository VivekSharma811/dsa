fun isSubset(array1: IntArray, array2: IntArray): Boolean {
    val setArray1 = hashSetOf<Int>()
    // Add all unique elements of array1 to the set
    for (num in array1) {
        if (!setArray1.contains(num)) {
            setArray1.add(num)
        }
    }

    // Check if every element of array2 exists in the set
    for (num in array2) {
        if (!setArray1.contains(num)) return false
    }

    return true
}

fun main() {
    val input1 = arrayOf(
        intArrayOf(9, 4, 7, 1, -2, 6, 5),
        intArrayOf(34, 19),
        intArrayOf(1, 2, 5, 0, 7, 4, 23),
        intArrayOf(-4, 6, 8, 1, 3, 14, 5, 7, 29),
        intArrayOf(52, 57, 23, -6, 22, -16, 78, 98, 46, 24, 19)
    )

    val input2 = arrayOf(
        intArrayOf(7, 1, -2),
        intArrayOf(34),
        intArrayOf(),
        intArrayOf(14, -4, 29),
        intArrayOf(7, -6, 8, -4)
    )

    for (i in input1.indices) {
        println("${i + 1}.\tArray1: ${input1[i].contentToString()}")
        println("\tArray2: ${input2[i].contentToString()}")
        println("\tResult: ${isSubset(input1[i], input2[i])}")
        println("-".repeat(100))
    }
}
