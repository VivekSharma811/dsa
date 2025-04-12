fun quickSort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1) {
    if (left < right) {
        val pivotIndex = choosePivot(left, right)
        val newPivotIndex = partition(arr, left, right, pivotIndex)
        quickSort(arr, left, newPivotIndex - 1)
        quickSort(arr, newPivotIndex + 1, right)
    }
}

fun partition(arr: IntArray, left: Int, right: Int, pivotIndex: Int): Int {
    val pivotValue = arr[pivotIndex]
    arr[pivotIndex] = arr[right].also { arr[right] = arr[pivotIndex] } // move pivot to end
    var storeIndex = left

    for (i in left until right) {
        if (arr[i] < pivotValue) {
            arr[i] = arr[storeIndex].also { arr[storeIndex] = arr[i] }
            storeIndex++
        }
    }

    arr[storeIndex] = arr[right].also { arr[right] = arr[storeIndex] } // move pivot to final place
    return storeIndex
}

fun choosePivot(left: Int, right: Int): Int {
    val rand = java.util.Random()
    val i1 = left + rand.nextInt(right - left + 1)
    val i2 = left + rand.nextInt(right - left + 1)
    val i3 = left + rand.nextInt(right - left + 1)
    return maxOf(minOf(i1, i2), minOf(maxOf(i1, i2), i3))
}

fun main() {
    val array = intArrayOf(3,1,9,2,6,4)
    quickSort(array)
    array.forEach { print(it) }
}
