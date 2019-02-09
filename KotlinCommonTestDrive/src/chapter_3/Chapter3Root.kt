package chapter_3


/*
    - Ф-ции
    - Ф-ции расширения
    - Свойства расширения
    - именованные аргументы,
    - значения параметров по умолчанию

*/

fun runChapter3() {
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