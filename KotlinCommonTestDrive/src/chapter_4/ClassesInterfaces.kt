package chapter_4


fun testExpr() {
    eval(Expr.Num())
    eval(Expr.Sum())
    eval(Expr.Zero())
}

fun eval(e: Expr): Int {
    return when (e) {
        is Expr.Num -> 1
        is Expr.Sum -> 2
        is Expr.Zero -> 0
    }
}

/*
    sealed - Значит запечаттанный. Запечатанный класс не может иметь наследников ВНЕ этого класса
    удобно использовать с When как в привере выше. Потому что отпадает надобность в ветке else

    Кроме того, если when должен что-то вернуть, как в примере выше, то он не даст скомпилироваться коду
    в том случае, если when не обработает вероятность всех типов классов в условии.
*/
sealed class Expr {
    class Num : Expr() {}
    class Sum : Expr() {}
    class Zero : Expr() {}
}





class TestClass1 {

    fun foo11() {
        println("foo")
    }

    //статический вложенный класс, не имеет ссылки на родителя
    class InnerClass1 {
        fun bar() {
            //foo11() NOPE!
        }
    }

    // вложенный класс,к оторый имеет ссылку на родителя
    inner class InnerInnerClass1 {
        fun bar() {
            foo11()
            this@TestClass1.foo11() // так можно обратиться к внешнему классу
        }
    }
}

open class RichButton : OnEvent {
    override fun onOk() {
    }

    override fun onFail() {

    }

    open fun someFun() {

    }
}

interface OnEvent {
    fun onOk()
    fun onFail()
    fun todo() = println("default todo in OnEvent")
}

interface OnAnotherEvent {
    fun someAction()
    fun onOk()
    fun todo() = println("default todo in OnAnotherEvent")
}

abstract class SomeAbstract {
    abstract fun todoAbstr()
    abstract fun onOk()
}

class SomeClass : SomeAbstract(), OnEvent, OnAnotherEvent {

    override fun todoAbstr() {
        println("todo")
    }

    override fun todo() {
        super<OnAnotherEvent>.todo()
        super<OnEvent>.todo()
    }

    override fun onOk() {
        println("onOk")
    }

    override fun onFail() {
        println("onFail")
    }

    override fun someAction() {
        println("someAction")
    }

}