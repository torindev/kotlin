package chapter_1_2_3_4.misc

data class Person2(val name: String)

fun testPerson2() {
    val p1 = Person2("Man")
    println(p1.name)
}

data class Person3(
    val name: String,
    var isMarried: Boolean
)

fun testPerson3() {
    val p1 = Person3("Boy", false)
    val name = p1.name
    //p1.name = "Man" - нет, потому что поле финальное
    val isMarried = p1.isMarried
    p1.isMarried = true // это аналог сеттера из Java
}