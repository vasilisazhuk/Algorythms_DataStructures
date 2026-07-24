package algorithms.DivideAndConquer

fun countLessOrEqual(list: List<Int>, value: Int): Int {
    var l = 0
    var r = list.size //- 1
    while (l < r){
        val m = (l + r)/2
        if(list[m] <= value){
            l = m + 1
        } else{
            r = m
        }
    }
    return l
}
fun countStrictlyLess(list: List<Int>, value: Int): Int {
    var l = 0
    var r = list.size //- 1
    while (l < r){
        val m = (l + r)/2
        if(list[m] < value){
            l = m + 1
        } else{
            r = m
        }
    }
    return l
}

fun quickSort(list: MutableList<Int>, left: Int = 0, right: Int = list.size-1): MutableList<Int> {
    var start = left
    var end = right
    val pivot = list[(start + end)/2]
    while (start <= end){
        while (list[start] < pivot) {
            start++
        }
        while (list[end] > pivot) {
            end --
        }
        if (start <= end){
            val tmp = list[start]
            list[start] = list[end]
            list[end] = tmp
            start++
            end--
        }
    }
    if (left < end) {
        quickSort(list, left, end)
    }
    if (start < right) {
        quickSort(list, start, right)
    }
    return list
}

fun main(){
    val line = readln().split(" ")
    val n = line[0].toInt()
    val m = line[1].toInt()
    val segmentsStart = mutableListOf<Int>()
    val segmentsEnd = mutableListOf<Int>()
    for (i in 0 until n){
        //readln().split(" ").map { it.toInt() }
        val (start, end) = readln().split(" ").map { it.toInt() }
        segmentsStart.add(start)
        segmentsEnd.add(end)
    }
    val dots = readln().split(" ").map { it.toInt() }
    val a = quickSort(segmentsStart)
    val b = quickSort(segmentsEnd)
    dots.map { print("${(countLessOrEqual(a, it) - countStrictlyLess(b ,it))} ") }
}