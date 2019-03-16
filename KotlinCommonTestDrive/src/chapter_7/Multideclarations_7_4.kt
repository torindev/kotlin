package chapter_7

import common.logg

fun run7_4() {
    logg("Пример распаковки класса Point74(10, 20)")
    val p = Point74(10, 20)
    val (x, y) = p
    println(x)
    println(y)
    println(p.component1())
    println(p.component2())
}

class Point74(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}