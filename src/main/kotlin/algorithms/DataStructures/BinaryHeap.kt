package algorithms.DataStructures

class BinaryHeap{
    private val heap = mutableListOf<Int>()
    val size: Int get() = heap.size
    fun peak(): Int? = heap.firstOrNull()

    private fun siftUp(index: Int) {
        var current = index
        while (current > 0) {
            var parent = (current - 1) / 2
            if (heap[current] > heap[parent]) {
                val tmp = heap[current]
                heap[current] =heap[parent]
                heap[parent] = tmp
                current = parent
                //swap(current, parent)
            } else {
                break
            }
        }
    }
    private fun siftDown(index: Int) {
        var current = index
        val size = heap.size
        while (true) {
            val left = 2 * current + 1
            val right = 2 * current + 2
            var smallest = current
            if (left < size && heap[left] > heap[smallest]) {
                smallest = left
            }
            if (right < size && heap[right] > heap[smallest]) {
                smallest = right
            }
            if (smallest != current) {
                val tmp = heap[current]
                heap[current] =heap[smallest]
                heap[smallest] = tmp
                current = smallest
                //swap(current, smallest)
                //current = smallest
            } else {
                break
            }
        }
    }
    fun insert(value: Int){
        heap.add(value)
        siftUp(heap.size-1)
    }
    fun extractMax(): Int? {
        if (heap.isEmpty()) return null
        val max = heap[0]
        val last = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) {
            heap[0] = last
            siftDown(0)
        }
        return max
    }
}

fun main(){
    val n = readln().toInt()
    val heap = BinaryHeap()
    for (i in 0 until n){
        val command = readln()
        if (command == "ExtractMax") {
            //println(heap.extractMax())
            val max = heap.extractMax()
            println(max ?: "")
        } else if (command.startsWith("Insert")){
            heap.insert(command.split(" ")[1].toInt())
        }
    }
}