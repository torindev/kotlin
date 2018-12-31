package chapter_1_2_3_4.misc

import java.lang.StringBuilder

fun testMisc() {
    val str1 = "Dima"
    val str2 = StringBuilder("Dima").toString()
    val str3: String = String("Dima".toCharArray())
    println(str1 == str2)
    println(str1 === str2)
    println(str2 === str3)
    println(str2 == str3)
    println(str1 == str3)
    println(str1 === str3)

}

fun testSetInMisc() {
    val someSet = hashSetOf(Client("Alice", 123456))
    /* В множесте объекты сначала сравниваются по хэш коду
    * и если он равен, затем сравниваются по equals,
    * и если hashCode и equals совпадает, тогда они равны
    * Если не переопределить hashCode у объекта, то они не будут считаться равными для множества, даже если
    * equals возвращает true*/
    println(someSet.contains(Client("Alice", 123456)))

    val someSet2 = hashSetOf(Cliend("Alice", 123456))
    println(someSet2.contains(Cliend("Alice", 123456)))
}

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) {
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    //override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    override fun toString(): String {
        return "Client(name = $name, postalCode = $postalCode)"
    }
}

/* тут под капотом уже реализованы такие методы как
* toString(), equals, hashCode*/
data class Cliend(val name: String, val postalCode: Int)

