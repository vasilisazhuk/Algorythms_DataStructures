package algorithms

fun gdc(a: Int, b: Int): Int {
    var a_tmp = a
    var b_tmp = b
    while (a_tmp != 0 || b_tmp != 0) {
        if (a_tmp == 0) return b_tmp
        if (b_tmp == 0) return a_tmp
        if (a_tmp == b_tmp) {
            return a_tmp
        }
        else if (a_tmp > b_tmp) {
            a_tmp %= b_tmp
        } else {
            b_tmp %= a_tmp
        }
    }
    return maxOf(a_tmp, b_tmp)
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
    print(gdc(1, 1))
    print("\n")
    print(gdc(10, 5))
    //print(fibLast(n[0]))
}