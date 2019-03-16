package chapter_7

import common.logg
import java.lang.IndexOutOfBoundsException
import java.time.LocalDate


/* Перегрузка операторов
 * a * b - times
   a / b - div
   a % b - mod
   a + b - plus
   a - b - minus

   Операторы сравнения - <,>, <=, >= - автоматически транслируются в compareTo
   p1 < p2 тоже самое что и p1.compareTo(p2) < 0
   */


fun run7_1() {
    logg("Првоеряется перегрузка оператора +")
    val p1 = Point(10, 20)
    val p2 = Point(20, 30)
    val p3 = p1 + p2
    println(p3)

    logg("Созадется класс объект класса Point с координатами 10 и 20, " +
            "и проверяется работы перегруженного оператора *")
    val p4 = Point(10, 20)
    println(p4 * 1.5)

    logg("Перегрузка оператра get для класса Point")
    println(p4[1])

    logg("Сравниаются Alice Smith и Bob Johnson")
    val pers1 = Person1603("Alice", "Smith")
    val pers2 = Person1603("Bob", "Johnson")
    println(pers1 < pers2)
    println(pers1 > pers2)
    /*
        В котлине все сравнения джава классов которые реализуют Comparable
        можно проводить испольщуя синтаксис <><=>=
    */

    logg("abc < bac")
    println("abc" < "bac")

    logg("Изменяю значение Y у точки с координатами 10 и 20")
    val pMut = MutablePoint(10, 20)
    pMut[1] = 42
    println(pMut)

    logg("Проверка работы перегрузки оператора in")
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)

    logg("Демонстрация работы диапазонов в классе LocalDate")
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)

}

/*
  val p1 = Point(10, 20)
    val p2 = Point(20, 30)
    val p3 = p1 + p2
    println(p3)

    Вывод:
      Point(x=30, y=50)
*/
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

/* тоже что пример выше, только объявлено как ф-ция расширение, и times это умножение */
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

/*
    until создает диапазон, в данном примере от upperLeft.x до lowerRight.x
    и не включает последнее значение
    например закрытый диапазон 10..20 включает цифры от 10 до 20 включительно
    а 10 until 20 - от 10 до 19 включительно
*/
operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}



data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}



class Person1603(
    val firstName: String, val lastName: String
) : Comparable<Person1603> {
    override fun compareTo(other: Person1603): Int {
        // compareValuesBy - принимает список ф-ций,
        // можно передавать лямбда выражения или ссылки на св-ва
        return compareValuesBy(this, other, Person1603::lastName, Person1603::firstName)
    }
}