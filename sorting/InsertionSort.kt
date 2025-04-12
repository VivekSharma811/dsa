fun insertionSort(array: IntArray) {
    val n = array.size

    for(i in 1 until n) {
        val key = array[i]
        var j = i -1

        // Shift elements till i-1 that are greater than key
        while(j >= 0 && array[j]> key) {
            array[j+1] = array[j]
            j--
        }
        array[j+1] = key
    }
}