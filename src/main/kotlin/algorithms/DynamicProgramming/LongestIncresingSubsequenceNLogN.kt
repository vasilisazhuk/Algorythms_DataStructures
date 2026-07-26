package algorithms.DynamicProgramming


import kotlin.math.pow

fun quickLongestIncreasingSubsequnce(list: List<Int>): List<Int>{
    val inf = 10.0.pow(10.0).toInt()
    val D = MutableList(list.size + 1) { -inf }
    D[0] = inf
    val pos = MutableList(list.size + 1) { 0 }
    val prev = MutableList(list.size) { -1 }

    //println(list.size)

    for (i in list.indices){
        var left = 0
        var right = list.size
        while (right - left > 1){
            val mid = (left + right) / 2
            if (D[mid] >= list[i]) {
                left = mid
            } else {
                right = mid
            }
        }
        D[left + 1] = list[i]
        pos[left + 1] = i
        prev[i] = if (left > 0) pos[left] else -1
    }
    var k = 0
    for (i in 1..list.size){
        if (D[i] != -inf) k = i
    }
    val res = mutableListOf<Int>()
    var curr = pos[k]
    while (curr != -1){
        res.add(curr + 1)
        curr = prev[curr]
    }
    return res
}

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val res = quickLongestIncreasingSubsequnce(list)
    println(res.size)
    res.reversed().map { print("${it} ") }
    //println(quickLongestIncreasingSubsequnce(list))
}