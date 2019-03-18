package chapter_8

import common.logg
import java.lang.StringBuilder

fun run8_1() {
    logg("Ф-ции высшего порядка")
    val sum = {x: Int, y: Int -> x + y}
    // или явное определение
    val sum2: (Int, Int) -> Int = {x, y -> x + y}
    println(sum(2, 3))
    println(sum2(2, 3))

    logg("Передача колбека в параметр ф-ции")
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
    callbackTest { someValueFromCallbackTest ->
        run {
            println(someValueFromCallbackTest)
        }
    }
    println("ab1c".filter { it in 'a'..'z' })

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString {it.toLowerCase()})
    println(letters.joinToString(
        separator = "! ",
        postfix = "! ",
        transform = { it.toUpperCase() }
    ))
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun callbackTest(callback: (Int) -> Unit) {
    callback(5)
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder()

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}