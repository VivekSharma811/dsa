// Given an array of integers, nums, find the second maximum value from the array.
fun findSecondMaxElement() {
    val array = intArrayOf(9, 19, 16, 8, 23, 15, 3)

    var firstMax = Integer.MIN_VALUE
    var secondMax = Integer.MIN_VALUE

    for(element in array) {
        if(element > firstMax) {
            secondMax = firstMax
            firstMax = element
        } else if(element != firstMax && element > secondMax) {
            secondMax = element
        }
    }
    println("${secondMax}")
}