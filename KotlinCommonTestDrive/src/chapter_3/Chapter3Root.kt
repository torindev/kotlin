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
    println(joinToString(
        collection = list,
        separator = " * ",
        prefix = "_-=[",
        postfix = "]=-_")
    )

    println(joinToString(collection = list))
    println(joinToString(collection = list, postfix = "?"))
}

var someValue = 3
const val HEAD = 1


fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}