fun bubbleSort(array: IntArray) {
    val n = array.size

    for(i in 0 until n-1) {
        var swapped = false

        for(j in 0 until n-i-1) {
            if(array[j] > array[j+1]) {
                array[j] = array[j+1].also { array[j+1] = array[j] }
                swapped = true
            }
        }

        if(swapped.not()) break
    }
}