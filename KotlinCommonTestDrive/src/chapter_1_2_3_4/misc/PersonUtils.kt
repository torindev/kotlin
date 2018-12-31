import java.util.*

/*
* Поля у дата класса типа final
* получить доступ к полям:
* val pers = Person("Ivan", 32)
* pers.age
* pers.name
* */
data class Person(
    val index: Int,
    val name: String,
    val surname: String,
    val age: Int? = null
)

fun getListOfRandomPerson(size: Int): List<Person> {
    // ArrayList из Java
    val list = ArrayList<Person>()
    val rnd = Random()
    // создание обычного массива, аналог String[]
    val names = arrayOf(
        "Ivan",
        "Dima",
        "Max",
        "Gena",
        "Petr",
        "Gosha",
        "Zoya",
        "Lena",
        "Katya",
        "Masha",
        "Kira",
        "Natasha"
    )

    val surnames = arrayOf(
        "Popko",
        "Slepko",
        "Juyko",
        "Belko",
        "Strelko",
        "Celko",
        "Shmanko",
        "Kotko"
    )


    for (i in 0 until size) {
        list.add(Person(i, names[rnd.nextInt(names.size)], surnames[rnd.nextInt(surnames.size)], rnd.nextInt(40) + 10))
    }

    return list;

}