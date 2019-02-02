package chapter_1_2_3_4.misc

import java.util.*

fun testCycles2() {
    for (i in 1..10) {
        print("$i ,")
    }

    println()

    for (i in 1..10 step 2) {
        print("$i ,")
    }

    println()

    val size = 10
    for (i in 0 until size) {
        print("${if (i != 5) i else "FIVE!!"}, ")
    }

    println()

    // Обход Map
    val map = HashMap<String, String>()
    map.put("one", "some word")
    map.put("two", "some word")
    map.put("three", "some word")
    map.put("four", "some word")

    for ((key, value) in map) {
        println("key: $key, value: $value")
    }

    println()

    // обойти лист и получить индекс элемента в листе
    val keys = arrayListOf("one", "two", "three")

    for ((index, element) in keys.withIndex()) {
        println("index: $index, element: $element")
    }

    // с помощью in можно проверить вхождение в диапазон
    val isLetter = 'c' in 'a'..'z' || 'c' in 'A'..'Z'
    val isNum = 'c' in '0'..'9'
    println("isLetter: $isLetter, isNum: $isNum ")
}

fun testCycles() {
    val max = 10
    var i = 0
    println("WHILE")
    while (i < max) {
        print("${i++}, ")
    }
    println()

}

// Если кратно 3 - fizz
// если кратно 5 - buzz
// если кртано 3 и 5 - fizz buzz
fun fizzBuzzMy(size: Int) {

    // от 1 до size ВКЛЮЧАЯ size
    for (i in 1..size) {
        println(when {
            i % 3 == 0 && i % 5 != 0 -> "fizz"
            i % 5 == 0 && i % 3 != 0 -> "buzz"
            i % 5 == 0 && i % 3 == 0 -> "fizz buzz"
            else -> i.toString()
        })
    }
}

fun fizzBuzzFromBook(size: Int) {
    for (i in 1..size) {
        println(fbfb(i))
    }
}

fun fizzBuzzFromBookVer2(size: Int) {
    for (i in size downTo 1 step 2) {
        println(fbfb(i))
    }
}

fun fbfb(num: Int) = when {
    num % 15 == 0 -> "Fizz Buzz"
    num % 5 == 0 -> "Buzz"
    num % 3 == 0 -> "Fizz"
    else -> num.toString()
}

// обход MAP
fun mapDetourByFor() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        // эквивалентен binaryReps.put(c, binary)
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("letter: $letter, binary: $binary")
    }

}

fun forTestWithIndex() {
    val list = arrayListOf("one", "two", "three", "four", "five")
    for ((i, s) in list.withIndex()) {
        println("index = $i, value = $s")
    }
}

// Проверка вхождения (или не вхождения) в диапазон
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isDigit(c: Char) = c in '0'..'9'

fun recognize(c: Char) = when(c) {
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    in '0'..'9' -> "It's a DIGIT"
    else -> "I don't know..."
}