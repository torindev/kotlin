package my_special_notes

fun loopsTestDrive() {
    val strings = arrayListOf(
        "str01",
        "str02",
        "str03",
        "str04",
        "str05",
        "str06",
        "str07",
        "str08",
        "str09",
        "str10",
        "str11",
        "str12"
    )

    for (line in strings) {
        println(line)
    }

    for ((index, line) in strings.withIndex()) {
        println("$index) $line")
    }
}