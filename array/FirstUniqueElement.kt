//Given an array nums, find the first nonrepeating integer in it.
fun firstUniqueElement(): Int {
    val array = intArrayOf(11, 11, 22, 33, 33, 44)

    for(i in array.indices) {
        var j = 0

        while(j < array.size) {
            if(i != j && array[i] == array[j]) break
            j++
        }

        if(j == array.size) return array[i]
    }

    return -1
}