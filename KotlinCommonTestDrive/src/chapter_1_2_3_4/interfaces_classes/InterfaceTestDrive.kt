package chapter_1_2_3_4.interfaces_classes

import java.util.*

interface MainInterface {
    interface OnSomeActionListener {
        fun onSuccess(line: String)
        fun onFail(e: Throwable)
    }
    fun someAction(listener: OnSomeActionListener)

    // В котлин можно использовать методы по умолчанию в интерфейсах
    // Если же в другом интерфейсе будет такой же метод, и я реализую оба этих интерфейса
    // то компилятор выдаст ошибку, и заставит переопределить этот метод и реализовать его самому
    // на самом деле методы по умолчанию равносильны статическим методам класса
    fun printRandomNumber() {
        println(Random().nextInt(1000))
    }
}

interface AdditionalInterface {
    fun printRandomNumber() {
        println(Random().nextInt(2000) + 1000)
    }
}

class SomeClass : MainInterface {
    override fun someAction(listener: MainInterface.OnSomeActionListener) {
        listener.onSuccess("All Right")
    }
}

class SomeClass2 : MainInterface, AdditionalInterface {
    override fun someAction(listener: MainInterface.OnSomeActionListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun printRandomNumber() {
        super<MainInterface>.printRandomNumber()
        super<AdditionalInterface>.printRandomNumber()
    }
}

// Классы должны предоставить етод получения значения someValue
interface InterfaceWithParams {
    val someValue: String
}

class ObjIWP1 : InterfaceWithParams {
    override val someValue: String
        get() {
            return "bla"
        }
}

class ObjIQP2 : InterfaceWithParams {
    override val someValue: String
        get() = "bla2"
}

fun runInterfaceTest() {
    val obj = SomeClass()
    obj.printRandomNumber()
    //obj.someAction() TODO:
}