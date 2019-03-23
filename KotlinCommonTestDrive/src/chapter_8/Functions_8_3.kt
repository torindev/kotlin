package chapter_8

import chapter_5.Person

fun run8_3() {
    lookForAlice1(people)
    lookForAlice2(people)
    lookForAlice3(people)
    lookForAlice4(people)
}

val people = listOf(Person("Alice", 29), Person("Bob", 31))

/*
    Хорошая иллюстрация работы с return в вложенных ф-циях находится на странице
    274 (это если смотреть на страницу книги)

    fun (1) lookForAlice(people: List<Person>) {
        people.forEach(fun (2) (pers) {
            if (pers.name == "Alice") return // ВЫХОД ИЗ Ф-ЦИИ (2)
        })
    }

    ============================================

    fun (1) lookForAlice(people: List<Person>) {
        people.forEach {
            if (it.name == "Alice") return // ВЫХОД ИЗ Ф-ЦИИ (1)
        }
    }

*/

fun lookForAlice1(list: List<Person>) {
    for (pers in list) {
        if (pers.name == "Alice") {
            println("Alice found!")
            return
        }
    }
    println("Alice not found... :(")
}

fun lookForAlice2(list: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Alice found!")
            return
        }
    }
    println("Alice not found... :(")
}

fun lookForAlice3(list: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Alice got caught")
            return@label // или можно написать return@forEach - результат будет такой же
        }
    }
    println("Alice might be somewhere")
}

fun lookForAlice4(list: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}