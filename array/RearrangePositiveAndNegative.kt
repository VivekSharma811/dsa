/*
 * Implement a function that rearranges elements in an array so that all negative elements appear to the left and all positive elements (including zero) appear to the right. It’s important to note that maintaining the original sorted order of the input array is not required for this task.
 */
fun rearrangePositiveAndNegative() {
    val array = intArrayOf(10, -1, -6, 20, 4, 5, 15, -9, -6)
    var leftMostPositiveIndex = 0

    for(i in array.indices) {
        if(array[i] < 0) {
            if(i != leftMostPositiveIndex) {
                array[i] = array[leftMostPositiveIndex].also { array[leftMostPositiveIndex] = array[i] }
            }
            leftMostPositiveIndex++
        }
    }
    println(array.joinToString())
}