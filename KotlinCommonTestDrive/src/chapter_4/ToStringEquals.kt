package chapter_4

fun testToString() {
    val c = Client("Dima", 234234)
    println(c)
}

fun testEquals() {
    val c1 = Client("Dima", 423423)
    val c2 = Client("Dima", 423423)
    println(c1 == c2) // equals
    println(c1 === c2) // сравнивает ссылки

    val cc1 = Client2("Dima", 2423423)
    val cc2 = Client2("Dima", 2423423)

    println(cc1 == cc2)
    println(cc1 === cc2)
}

fun testHashCode() {
    val processed = hashSetOf(Client3("Alice", 32423))
    processed.add(Client3("Alice", 32423))
    processed.add(Client3("Alice", 32423))
    processed.add(Client3("Alice", 32423))
    processed.add(Client3("Alice", 32423))
    processed.add(Client3("Alice", 32423))

    println(Client3("Alice", 32423).hashCode())
    println(Client3("Alice", 32423).hashCode())

    println(Client3("Alice", 32423) == Client3("Alice", 32423))

    println("${processed.contains(Client3("Alice", 32423))}, processed size = ${processed.size}")
}

fun testDataClass() {
    val dc1 = Client4("Dima", 234)
    val dc2 = Client4("Dima", 234)

    println(dc1 == dc2)
    println(dc1 === dc2)

    val processed = hashSetOf(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))
    processed.add(Client4("Dima", 2342423))

    println("processed contains Client4(\"Dima\", 2342423) ? " +
            "${processed.contains(Client4("Dima", 2342423))}, size = ${processed.size}")
}

/*
    Когда класс объявлен как data, он из коробки имеет переопределенные методы
    equals, toString, hashCode.
    Работают они на основе полей дата-класса
*/
data class Client4(val name: String, val postalCode: Int)

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }
}

class Client2(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client2) {
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

}

class Client3(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client3(name=$name, postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client3) {
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }
}