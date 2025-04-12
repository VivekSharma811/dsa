fun maxSubArray(array: IntArray): Int {
    var maxSoFar = array[0]
    var currentMax = array[0]

    for(i in 1 until array.size) {
        currentMax = maxOf(array[i], currentMax + array[i])
        maxSoFar = maxOf(maxSoFar, currentMax)
    }

    return maxSoFar
}