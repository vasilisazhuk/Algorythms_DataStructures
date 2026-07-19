package algorithms.GreedyAlgorithms

fun main(){
    val n = readln().split(' ').map { it -> it.toInt() }
    val res = mutableListOf<Int>()
    var cur = n[0]
    var i = 0
    while(true){
        i++
        if (i * 2 < cur){
            res.add(i)
            cur -= i
        } else{
            res.add(cur)
            break
        }
    }
    //res.size

    res.map { it -> print("$it ") }
}