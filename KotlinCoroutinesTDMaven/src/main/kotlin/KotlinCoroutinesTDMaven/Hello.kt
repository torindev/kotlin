package KotlinCoroutinesTDMaven

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.system.measureTimeMillis

fun main() {


    val array = getFilledArray(400_000_000, 100)

    println("Without coroutines")
    for (i in 0 until 10) {
        findMaxTest(array)
    }

    println("With coroutines")
    findMaxCoro(array)

}

fun findMaxCoro(array: IntArray) = runBlocking {
    val middle = array.size / 2

    val time = measureTimeMillis {
        val one = async {
            var maxValue: Int = array[0]
            var index: Int = 0

            for ((ind, value) in array.withIndex()) {
                if (value > maxValue) {
                    maxValue = value
                    index = ind
                }
            }

            maxValue
        }

        val two = async {
            var maxValue: Int = array[middle]
            var index: Int = 0

            for (i in middle until array.size) {
                val value = array[i]
                if (value > maxValue) {
                    maxValue = value
                    index = i
                }
            }

            maxValue
        }

        if (one.await() > two.await()) {
            println("max = ${one.await()}")
        } else {
            println("max = ${two.await()}")
        }

    }
    println("time = ${time} ms")

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

