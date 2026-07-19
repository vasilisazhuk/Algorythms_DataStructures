package algorithms.GreedyAlgorithms

fun main(){
    val list = readln().split(' ').map { it -> it.toInt() }
    val n = list[0]
    val w = list[1].toDouble()
    val treasure : MutableList<List<Double>> = mutableListOf<List<Double>>()

    for (i in 0 until n){
        treasure.add(readln().split(' ').map { it -> it.toDouble() })
    }
    treasure.sortByDescending { it[0]/it[1] }
    var totalCost = 0.0
    var currentMass = w
    for (it in treasure){
        if (currentMass > 0) {
            if (currentMass >= it[1]) {
                totalCost += it[1] * (it[0]/it[1])//it[0] * it[1]
                currentMass -= it[1]
            } else{
                totalCost += currentMass * (it[0]/it[1])
                currentMass = 0.0
                break
            }
        }
    }
    println(String.format("%.3f", totalCost))
}