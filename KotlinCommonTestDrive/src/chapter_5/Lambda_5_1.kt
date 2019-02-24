package chapter_5

fun runCh5_5() {
    test1()
    testLambda1()
}

fun test1() {
    val persons = listOf(
        Person("Alice", 25),
        Person("Vanya", 48),
        Person("Zosya", 16)
        )

    println(persons.maxBy { it.age })
    println(persons.maxBy { p: Person -> p.age }) // равносильно
    println(persons.maxBy() { p: Person -> p.age }) // равносильно

    // равносильно. Скобки нужны только в том случае, если аргументов больше чем 1
    println(persons.maxBy({ p: Person -> p.age }))

    val names = persons.joinToString(separator = " ", transform = {p: Person -> p.name})
    println(names)

}

fun testLambda1() {

    val lam1 = { x: Int, y: Int -> x * y }

    println(lam1(4, 6)); // точка с запятой!! WTF??!! если убрать - ошибка
    { println(55) }()

    // Если в лямбде польше чем 1 строка, то ее результатом станет последняя строка
    val sum = {x: Int, y: Int ->
        println("Computing the sum $x and $y")
        x + y
    }

    println(sum(3, 7))

}

data class Person(val name: String, val age: Int)