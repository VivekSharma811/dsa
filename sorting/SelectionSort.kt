// Start putting smallest element at the start of array.
fun selectionSort(array: IntArray) {
    val n = array.size

    for(i in 0 until n -1) {
        var minIndex = i
        for(j in i + 1 until n) {
            if(array[j] < array[minIndex]) minIndex = j
        }

        if(minIndex != i) {
            array[i] = array[minIndex].also { array[minIndex] = array[i] }
        }
    }
}

fun main() {
    val array = intArrayOf(3,1,9,2,6,4)
    selectionSort(array)
    array.forEach { print(it) }
}