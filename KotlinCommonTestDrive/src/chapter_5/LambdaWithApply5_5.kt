package chapter_5

import java.lang.StringBuilder

fun run5_5() {
    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
}

// Классический вариант
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know Alphabet!")
    return result.toString()
}

// Вариант с With
fun alphabet2(): String {
    val sb = StringBuilder()
    return with(sb) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know Alphabet!")
        this.toString()
    }
}

// Вариант с With 2
fun alphabet3() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know Alphabet!")
    toString()
}

// Вариант с Apply
fun alphabet4() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know Alphabet!")
}.toString()