package chapter_1_2_3_4.interfaces_classes

open class Button {
    private var param1: String = "param1"
    private var param2: String = "param2"
    private var param3: String = "param3"
    var openParam: String = "open param!"

    fun testButton() {
        println("obj Button: param1 = $param1, param2 = $param2, param3 = $param3 and open param = $openParam")
    }

    // это аналог статического вложенного класса из Java
    // внутри него нет ссылки this внешнего класса, поэтому он не может обращаться к членам внещнего класса
    // в данном случае он просто наследуется от внешнего класса
    class HiddenButtonStatic : Button() {
        private var param1: String = "hidden param1"
        private var param2: String = "hidden param2"
        private var param3: String = "hidden param3"

        fun testHiddenButton() {
            openParam = "33"
            println("obj HiddenButtonStatic: param1 = $param1, param2 = $param2, param3 = $param3")
        }
    }

    inner class HiddenButtonInner {
        private var param: String = "this is the inner hidden button"

        fun test() {
            doSomething()
        }

        private fun doSomething() {
            param2 = "sfsf"
            param1 = "sdasda"
            param3 = "4e2342"

            // получение ссылки на внешний класс
            this@Button.testButton()
        }
    }

}

// Запечатанный класс
// все прямые подклассы должны быть вложены в него
// запечатанный класс не может иметь наследников, объявленных вне класса
// это помогает избавиться от ветки else в операторе when
// и теперь , если добавить еще один класс в Expr, компилятор заставит реализовать новую ветку в when
// что избавит от трудноуловимых ошибок
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Num, val right: Num) : Expr()
    //class TestNewBranchInWhen : Expr()
}

fun eval2(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval2(e.left) + eval2(e.right)
        }

// Этот класс нельзя создать снаружи, потому что он имеет приватный конструктор
class Secretive private constructor()

// Круглые скобки в конце это основной конструктор, если он без параметров, его можно опустить
// при наслденовании от какого-либо класса. всегда используется такой синтаксис:
// class ChildClass : BaseClass()

class Context()

// Класс с несколькими конструкторами
open class View {
    constructor(ctx: Context) {
        //some code
    }

    constructor(ctx: Context, param: String) {
        // some code
    }
}

// теперь, если нужно наследоваться от View...

class Button1(ctx: Context) : View(ctx)

// или

class Button2(ctx: Context, param: String) : View(ctx, param)

fun testInners() {
    println("Static inner test")
    val btn = Button()
    btn.testButton()
    println(btn.openParam)
    btn.openParam = "really open"
    btn.testButton()

    val hidden = Button.HiddenButtonStatic()
    hidden.testHiddenButton()
    hidden.testButton()

    println("Inner test")
    var btn2 = Button()
    btn2.testButton()
    var inner = btn2.HiddenButtonInner()
    inner.test()
    btn2.testButton()

}