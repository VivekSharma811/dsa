/*
 * We're given a sorted array, nums, containing positive integers only. We have to rearrange the array so that when returned, the
0th index of the array will have the largest number, the 1st index will have the smallest number, the 2nd index will have the second largest number, the
3rd index will have the second smallest number, and so on.

In the end, we’ll have the largest remaining numbers in descending order and the smallest in ascending order at even and odd positions, respectively.
 */
fun rearrangeMaxMinArray() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6)
    val result = IntArray(array.size)
    var i = 0
    var left = 0
    var right = array.size - 1
    while(left <= right) {
        if(i % 2 == 0) {
            result[i++] = array[right--]
        } else {
            result[i++] = array[left++]
        }
    }
    println(result.joinToString())
}