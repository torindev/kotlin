package chapter_3

fun testStrings() {
    regexTestDrive()
    parsePath()
    multiLineTd()
}

fun multiLineTd() {
    val str = """
        это
        многострочный
        текст
        в
        6
        строк
    """.trimIndent()
    println(str)
}

fun regexTestDrive() {
    println("12.345-6.A".split("\\.|-".toRegex())) //[12, 345, 6, A]
    println("12.345-6.A".split(".")) //[12, 345-6, A]
    println("12.345-6.A".split(".", "-")) //[12, 345, 6, A]
}

fun parsePath() {
    val path = "users/yole/somethingSpecial/kotlin/very_secret.txt"
    val dir = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfter(".")

    println("Dir: $dir, fullname: $fullName, file name: $fileName, extension: $extension")
    //Dir: users/yole/somethingSpecial/kotlin, fullname: very_secret.txt, file name: very_secret, extension: txt
}