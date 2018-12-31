package chapter_1_2_3_4.interfaces_classes

class User(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""Address was changed for $name:
            "$field" -> "$value".""".trimIndent())
        field = value
    }
}

fun runTest11() {
    val user = User("Boy")
    user.address = "at home"
}