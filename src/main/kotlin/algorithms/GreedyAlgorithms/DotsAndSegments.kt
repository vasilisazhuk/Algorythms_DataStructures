package algorithms.GreedyAlgorithms

fun main(){
    val n = readln().split(' ').map { it -> it.toInt() }
    val list: MutableList<List<Int>> = mutableListOf<List<Int>>() //= mutableListOf<>()
    for (i in 0 until n[0]){
        list.add(readln().split(' ').map { it -> it.toInt() })
    }
    //print(list)
    list.sortBy { it[1] }
    var currentDot = -1
    val res = mutableListOf<Int>()
    for (i in 0 until list.size){
        if (currentDot < list[i][0]){
            currentDot = list[i][1]
            res.add(currentDot)
        }
    }
    println(res.size)
    //println(res)
    res.map { it -> print("$it ") }
    //print(list)
    //print(list)
}