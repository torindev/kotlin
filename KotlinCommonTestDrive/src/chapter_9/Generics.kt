package chapter_9

fun runGenericsTestDrive() {
    val list = listOf(
        "one",
        "two",
        "three",
        "four"
    )

    println(list.getRandomElement())
}

fun <T> List<T>.getRandomElement(): T {
    val index = (System.currentTimeMillis() % size).toInt()
    return get(index)
}