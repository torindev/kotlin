package chapter_4

import java.util.*
import kotlin.Comparator
import kotlin.random.Random

fun runPart4_4() {
    println(Payroll.uuid)
    println(Payroll.uuid)
    Payroll.foo()
    comparatorTd()

    testStaticInner()
}

//если требуется использование фабричных методов, томожно использовать
//механизм companion
// объект companion Имеет доступ ко всем приватным полям и конструкторам своего класса овнера

fun testA() {
    A.foo1()
    A.foo2()

    B.Loader.foo3()
}

// так
class B {
    companion object Loader {
        fun foo3() {

        }
    }
}

// или так
class A {
    companion object {
        fun foo1() {

        }

        fun foo2() {

        }
    }
}

fun testStaticInner() {
    Pers22.StaticState.justPrintId()
    Pers22.StaticState.justPrintId()
    Pers22.StaticState.justPrintId()
}

class Pers22 {
    object StaticState {
        val uuid: String = UUID.randomUUID().toString()

        fun justPrintId() {
            println("StaticState id = $uuid")
        }
    }
}


// пример реализации анонимного класса с помощью object
fun comparatorTd() {
    val rnd = Random
    val mass = arrayListOf(
        Pers11("sad1", rnd.nextInt(30) + 20),
        Pers11("sad2", rnd.nextInt(30) + 20),
        Pers11("sad3", rnd.nextInt(30) + 20),
        Pers11("sad4", rnd.nextInt(30) + 20),
        Pers11("sad5", rnd.nextInt(30) + 20)
    )

    Collections.sort(mass, object  : Comparator<Pers11> {
        override fun compare(o1: Pers11?, o2: Pers11?): Int {
            if (o1 != null && o2 != null) {
                return Integer.compare(o1.age, o2.age)
            } else if (o1 != null) {
                return 1
            } else if (o2 != null) {
                return -1
            } else {
                return 0
            }
        }
    })

    println(mass)
}

data class Pers11(val name: String, val age: Int)


//singleton
/*
    Кможет содержать все тоже что и обычный класс, кроме
    конструкторов.
    object тут работает как паттерн синглтон
    после объявления таким способом, обращаться к такому
    так, как будто все поля и методы его статические
    Payroll.foo()
    Payroll.uuid

    т.е. это просто объект сингл тон
*/
object Payroll {
    val money: Int = 0
    val honey: Int = 5
    val uuid: String = UUID.randomUUID().toString()

    fun foo() {

    }
}