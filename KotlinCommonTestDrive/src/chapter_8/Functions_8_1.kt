package chapter_8

import common.logg

fun run8_1() {
    logg("Ф-ции высшего порядка")
    val sum = {x: Int, y: Int -> x + y}
    println(sum(2, 3))
}