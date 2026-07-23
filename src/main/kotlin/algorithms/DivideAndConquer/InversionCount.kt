package algorithms.DivideAndConquer

fun merge(left: List<Int>, right: List<Int>): Pair<MutableList<Int>, Long>{
    val list: Array<Int> = Array(left.size + right.size){0}
    var l = 0
    var r = 0
    var inversions = 0L
    for (i in list.indices){
        if(l < left.size && r < right.size){
            if (left[l] <= right[r]){
                list[i] = left[l]
                l++
            } else {
                list[i] = right[r]
                r++
                inversions += left.size - l
            }
        } else if (l >= left.size) {

            val remaining = right.subList(r, right.size)
            System.arraycopy(remaining.toTypedArray(), 0, list, i, remaining.size)
            break
        } else {

            val remaining = left.subList(l, left.size)
            System.arraycopy(remaining.toTypedArray(), 0, list, i, remaining.size)
            break
        }
        //list[i] = minOf(left[i], right[i])
    }
    return Pair(list.toMutableList(), inversions)
}

fun inversionCount(a: MutableList<Int>): Long{
    if (a.size <= 1) return 0
    var copy = a
    var inversions = 0L
    val left = a.take(a.size/2).toMutableList()
    //println(left)
    val right = a.drop(a.size/2).toMutableList()
    //println(right)
    inversions += inversionCount(left)
    inversions += inversionCount(right)
    var inv = merge(left, right)
    copy = inv.first
    for (i in 0..copy.size-1){
        a[i] = copy[i]
    }
    inversions += inv.second
    return inversions
}

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it -> it.toInt() }.toMutableList()
    println(inversionCount(list))
}