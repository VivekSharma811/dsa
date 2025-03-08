/*
 *Given an array of integers, nums, and an integer target, k, find two numbers in the array that sum up to the target k.

There is exactly one solution for each input, and each element of the array can only be used once in the solution. The order of the returned elements does not matter.
 *
 */
fun checkSum() {
    val array = intArrayOf(1, 10, 8, 4, 9)
    val k = 17

	val sortedArray = array.sortedArray()

    var left = 0
    var right = sortedArray.size - 1

    while(left < right) {
        val sum = sortedArray[left] + sortedArray[right]

        if(sum < k) {
            left++
        } else if(sum > k) {
            right--
        } else {
            println("${array[left]} and ${array[right]}")
            break
        }
    }
}