package algorithms

fun binarySearch(list: List<Int>, value: Int): Int {
    var l = 0
    var r = list.size - 1
    while (l <= r){
        val m = (l + r)/2
        when {
            list[m] == value -> return m + 1
            list[m] > value -> r = m -1
            else -> l = m + 1
        }
    }
    return -1
}

fun main(){
    val list1 = readln().split(" ").map { it.toInt() }.drop(1)
    //val n = list1[1]
    //val search = list1.drop(1)
    val list2 = readln().split(" ").map { it.toInt() }.drop(1)
    //val m = list2[1]
    list2.drop(1)
    list2.map { it -> println(binarySearch(list1, it)) }
}