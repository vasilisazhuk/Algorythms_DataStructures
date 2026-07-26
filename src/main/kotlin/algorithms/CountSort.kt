package algorithms

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val a = Array<Int>(11){0}
    for (i in 0 until n){
        a[list[i]] ++
    }
    for (i in 1 until 11){
        a[i] = a[i] + a[i-1]
    }
    val res = Array<Int>(n){0}
    for (i in n-1 downTo 0){
        res[a[list[i]] -1] = list[i]
        a[list[i]] -= 1
    }
    res.map { print("$it ") }
}