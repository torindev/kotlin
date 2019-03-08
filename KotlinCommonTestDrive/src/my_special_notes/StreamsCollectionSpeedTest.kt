package my_special_notes

import kotlin.random.Random

fun runStreamSpeedTest() {
    val someMap = HashMap<String, Int>()
    var timeStamp = System.currentTimeMillis()
    for (i in 0..100000) {
        someMap.put("Name$i", Random.nextInt(115))
    }

    println("collection filled by ${System.currentTimeMillis() - timeStamp} ms.")

    val listTmp1 = someMap.filter { it.value > 110 }
    val listTmp2 = someMap.filter { it.value > 110 }

    testClassic(someMap)

    testStream(someMap)

    testClassic(someMap)

    testStream(someMap)

    testClassic(someMap)

    testStream(someMap)




}

fun testStream(someMap: HashMap<String, Int>) {
    var timeStamp = System.currentTimeMillis()

    val streamListTest = someMap.filter { it.value > 110 }

    println("filter done by ${System.currentTimeMillis() - timeStamp} ms, result size: ${streamListTest.size}")
}

fun testClassic(someMap: HashMap<String, Int>) {
    var timeStamp = System.currentTimeMillis()

    val classicListTest = HashMap<String, Int>()

    for ((key, value) in someMap) {
        if (value > 110) {
            classicListTest.put(key, value)
        }
    }

    println("classic case speed ${System.currentTimeMillis() - timeStamp} ms, result size: ${classicListTest.size}")
}