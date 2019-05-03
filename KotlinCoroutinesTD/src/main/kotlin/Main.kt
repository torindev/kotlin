import java.util.*
import javax.xml.bind.JAXBElement
import kotlin.system.measureTimeMillis

fun main() {


    val array = getFilledArray(100_000_000, 100)

    println("Without coroutines")
    for (i in 0 until 10) {
        findMaxTest(array)
    }

}

fun findMaxCoro(array: IntArray) {
    val middle = array.size / 2
    
    val time = measureTimeMillis {
        val one = async {}
    }
}

fun findMaxTest(array: IntArray) {


    var maxValue: Int = array[0]
    var index: Int = 0

    val startTime = time()

    for ((ind, value) in array.withIndex()) {
        if (value > maxValue) {
            maxValue = value
            index = ind
        }
    }

    val resultTime = time() - startTime

    println("Max value = $maxValue, index = $index, time spent = $resultTime ms")
}

fun time() = System.currentTimeMillis()

fun getFilledArray(size: Int, maxNum: Int): IntArray {
    val rnd = Random()

    val array = mutableListOf<Int>()

    for (i in 0 until size) {
        array.add(rnd.nextInt(maxNum))
    }

    return array.toIntArray()
}