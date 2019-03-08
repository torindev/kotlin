package chapter_5

fun run5_2() {
    val list = listOf(1,2,3,4,5,6,7)
    // it это каждое число из коллекции list
    // операторы filter и map создают промежуточные коллекции

    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val people = arrayListOf(
        Person("Dima", 31),
        Person("Yulya", 27),
        Person("Inna", 27),
        Person("Bibi", 37),
        Person("Vasyan", 11),
        Person("Bob", 25),
        Person("Alice", 28),
        Person("Carol", 31)
    )

    val listOfage27 = people.filter { it.age > 27 }

    println(people.filter { it.age > 27 }.map { it.name })
    val maxByAge = people.maxBy({ it.age })!!.age
    println(people.filter { it.age == maxByAge })
    val mapTd = mapOf(0 to "zero", 1 to "one", 2 to "two")
    println(mapTd.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = {p: Person -> p.age <= 27}
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.first(canBeInClub27))
    println(people.find(canBeInClub27))

    val groups = people.groupBy { it.age }
    for ((key: Int, values: List<Person>) in groups) {
        println("key: $key, values: ${values}" )
    }

    val books = arrayListOf(
        Book("Some title1", listOf("Author1", "Author2", "Author3")),
        Book("Some title2", listOf("Author4", "Author5")),
        Book("Some title3", listOf("Author4")),
        Book("Some title4", listOf("Author2"))
    )

    println(books.flatMap { it.authors }.toList())
    println(books.flatMap { it.authors }.toSet())

    books.asSequence()
        .map { it.title }
        .filter { it.endsWith("1") }
        .toList()
}

class Book(val title: String, val authors: List<String>)

