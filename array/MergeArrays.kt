// Merge 2 Sorted Arrays
fun mergeArrays() {
    val array1 = intArrayOf(1,4,5,7,9)
    val array2 = intArrayOf(2,3,6,8,10)
    val result = Array<Int>(array1.size + array2.size) { 0 }

    var i = 0
    var j = 0
    var k = 0

    while(i < array1.size && j < array2.size) {
        if(array1[i] <= array2[j]) {
            result[k++] = array1[i++]
        } else {
            result[k++] = array2[j++]
        }
    }

    while(i < array1.size) {
        result[k++] = array1[i++]
    }
    while(j < array2.size) {
        result[k++] = array2[j++]
    }
    result.forEach {
        println(it)
    }
}
