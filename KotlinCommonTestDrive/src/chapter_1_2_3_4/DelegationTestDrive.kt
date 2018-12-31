package chapter_1_2_3_4

class CountingSet<T> (
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun runDelegationTest() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 3, 4))
    println("${cset.objectAdded} objects were added, ${cset.size} remain")
}