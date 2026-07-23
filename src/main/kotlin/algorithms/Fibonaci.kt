package algorithms

/*
Ряд Фибоначи - эфективное представление приоритетной очереди. Примем приоритетную очередь как структуру данных, которая хранит множество S и у каждого элемента S есть ключ k(S)
* */

/*
Single source shortest path problem
* */

fun pizzanoPeriod(n: Int): List<Int> {
    if (n == 1) return listOf(0)

    val sequence = mutableListOf<Int>()
    sequence.add(0)
    sequence.add(1)
    var current = 0
    var next = 1
    //sequence.add(current)
    while (true) {
        val oldNext = next
        next = (current + next) % n
        current = oldNext
        sequence.add(next)
        if (current == 0 && next == 1) {
            sequence.removeLast()
            sequence.removeLast()
            return sequence
        }
    }
}

fun main() {
    // put your code here
    //val scanner = Scanner(System.`in`)
    //val string = readln().split(' ')
    //val n = string[0]
    //val m = string[1]
    /*
    * val n = input[0].toLong()
    val m = input[1].toInt()
    val sequence = fib(m)
    val index = (n % sequence.size).toInt()

    println(sequence[index])
    * */
    val sequence = pizzanoPeriod(25897)
    //print(sequence)
    print(sequence[1598753%sequence.size])
    //print(fibLast(n[0]))
}
