fun main() {
    val combinations = getAllCombinations("abc")
    println("Combinations :")
    combinations.forEach { println(it) }
}

fun getAllCombinations(input: String): List<String> {
    val result = mutableListOf<String>()
    val n = input.length

    fun backTrack(start: Int, current: StringBuilder) {
        if(current.isNotEmpty()) result.add(current.toString())

        for(i in start until n) {
            current.append(input[i])
            backTrack(i+1, current)
            current.deleteCharAt(current.length - 1)
        }
    }

    backTrack(0, StringBuilder())
    return result
}