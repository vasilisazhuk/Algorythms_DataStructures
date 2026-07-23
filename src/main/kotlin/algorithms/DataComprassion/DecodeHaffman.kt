package algorithms.DataComprassion

fun decodeString(string: String, code: Map<String, Char>): String{
    val result = StringBuilder()
    var currentCode = ""
    for (bit in string){
        currentCode += bit
        code[currentCode]?.let {char ->
            result.append(char)
            currentCode = ""
        }
    }
    return result.toString()
}

fun main(){
    val (k, l) = readln().split(" ").map { it.toInt() }
    val codeMap = mutableMapOf<String, Char>()
    for (i in 0 until k){
        val list = readln().split(": ")
        codeMap[list[1]] = list[0][0]
    }
    val str = readln()
    println(decodeString(str, codeMap))
}