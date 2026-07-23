package algorithms.DataComprassion

import java.util.PriorityQueue
data class Node(
    val ch: Char? = null,
    val fr: Int,
    var left: Node? = null,
    var right: Node? = null
): Comparable<Node> {
    override fun compareTo(other: Node): Int = this.fr - other.fr
}
class Haffman{
    private fun encode(root: Node?, str: String,  huffmanCode: MutableMap<Char, String>){
        if (root == null) return
        if (root.left == null && root.right == null) {
            root.ch?.let { huffmanCode[it] = str }
            return
        }
        encode(root.left, "${str}0", huffmanCode)
        encode(root.right, "${str}1", huffmanCode)
    }
    private fun decode(root: Node?, index: Int, sb: StringBuilder): Int{
        var currentIndex = index
        var currentNode: Node? = root ?: return currentIndex
        if (currentNode?.left == null && currentNode?.right == null) {
            print(currentNode?.ch)
            return currentIndex
        }
        currentIndex++
        currentNode = if (sb[currentIndex] == '0') {
            currentNode.left
        } else {
            currentNode.right
        }

        return decode(currentNode, currentIndex, sb)
    }
    fun buildHuffmanTree(map: Map<Char, Int>): Map<Char, String>{
        val pq = PriorityQueue<Node>()
        map.forEach { (char, frequency) ->
            pq.add(Node(char, frequency))
        }
        while (pq.size > 1) {
            val left = pq.poll()
            val right = pq.poll()
            val sum = left.fr + right.fr
            pq.add(Node(null, sum, left, right))
        }
        val root = pq.peek()
        val huffmanCode = mutableMapOf<Char, String>()
        encode(root, "", huffmanCode)
        return huffmanCode
    }
}
fun main(){
    val str = readln()
    val frequencies = str.groupingBy { it }.eachCount()//.entries.sortedByDescending { it.value }
    val haffman = Haffman()
    val codes = haffman.buildHuffmanTree(frequencies)
    println(codes)
}
