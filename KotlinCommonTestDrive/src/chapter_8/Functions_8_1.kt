package chapter_8

import common.logg

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
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}