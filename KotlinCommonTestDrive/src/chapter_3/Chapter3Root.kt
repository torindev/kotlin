package chapter_3


/*
    - Ф-ции
    - Ф-ции расширения
    - Свойства расширения
    - именованные аргументы,
    - значения параметров по умолчанию

*/

fun runChapter3() {
    testDriveString()
}

fun testDriveString() {
    val str = "one.two.three.four"
    val mass = str.split(".".toRegex())
    val mass2 = str.split(".")
    println(mass)
    println(mass2)
}


fun extract() {
    val list = listOf(1, 2, 3, 4, 5)

    val array = arrayOf(1,  2, 3, 4, 5)

    val list2 = listOf(array)
    val list3 = listOf(*array)

    println(list2)
    println(list3)

    val map = mapOf(
        1 to "one",
        7 to "sevent",
        8 to "eight",
        10 to "ten"
    )

    val pair = 1 to "one"

}

fun testDriveJoin() {
    val list = listOf(1, 3, 6, 14, 15)
    println(list.joinToString(
        separator = " * ",
        prefix = "_-=[",
        postfix = "]=-_")
    )

    println(list.joinToString())
    println(list.joinToString(postfix = "?"))
    println("Dima".lastChar())
}

infix fun Any.to(other: Any) = Pair(this, other)


fun String.lastChar(): Char = this.get(this.length - 1)


fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}