package chapter_6

fun run6_1() {
    val lines = arrayOf(
        "str1",
        "str11",
        "str111",
        "str1111",
        null,
        "str11111",
        "str111111",
        "str1111111",
        "str11111111"
    )

    for (line in lines) {
        // s = строке, если строка не Null, иначе = "..."
        val s: String = line ?: "..."

        // пытаемся поулчить длину строки, если она не null, иначе вернет просто Null
        line?.length

        //тут пытаемся получить длину строки если она не null, иначе если null - возвращаем "empty string"
        // (из-за оператора "elvis" (?:)
        println(line?.length?:"empty string")
    }

    testStringAs("somebody")
    testStringAs(42)
    testStringAs(null)


}

//знак ? псоле типа означает что значение может содержать null
fun testStringAs(s: Any?) {

    /* тут получается логика такая: если s не String, то as? вернет null.
    Т.е. если s == 42 или s == null, результат будет null */
    val thisIsString = s as? String
    println("actually, contains $thisIsString")

    /* последний оператор ?: проверяет, если thisIsString == null, то он подставляет 0 */
    println("this is string, and length = ${thisIsString?.length ?: 0}")
}