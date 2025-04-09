// Given Int array and Int K, Right rotate the array upto K
// 1. Reverse the whole Array 50, 40, 30, 20, 10
// 2. Reverse the K indices from starting 30,40, 50, 20, 10
// 3. Reverse the remaining indices 30, 40, 50, 10, 20
fun rotateArray() {
    val array = intArrayOf(10, 20, 30, 40, 50)
    val i = 8
    val k = i % array.size
    array.reverseArray(0, array.size - 1)
    array.reverseArray(0, k-1)
    array.reverseArray(k, array.size - 1)
    println(array.joinToString())
}

fun IntArray.reverseArray(start: Int, end: Int) {
    var left = start
    var right = end

    while(left < right) {
        this[left] = this[right].also { this[right] = this[left] }
        left++
        right--
    }
}