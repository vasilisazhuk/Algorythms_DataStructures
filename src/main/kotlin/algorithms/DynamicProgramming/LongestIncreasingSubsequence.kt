package algorithms.DynamicProgramming

fun longestIncreasingSubsequnce(list: List<Int>): List<Int>{
    val D = MutableList(list.size){0}
    //println(list.size)

    for (i in list.indices){
        D[i] = 1
        for (j in 0 until i){
            if (list[i] % list[j] == 0 && D[j] + 1 > D[i]) {
                D[i] = maxOf( D[j] + 1, D[i])
            }
        }
    }
    return D
}

fun main(){
val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    val indexes = longestIncreasingSubsequnce(list)
    val answer = indexes.maxOrNull() ?: 0
    println(answer)
}