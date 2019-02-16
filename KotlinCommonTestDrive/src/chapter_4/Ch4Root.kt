package chapter_4

/*
    Про классы, интерфейсы,
    конструкторы, свойства, ключевое слово object,
    делегирование, классы данных
*/

fun ch4td() {

}

interface OnEvent {
    fun onOk()
    fun onFail()
}

abstract class SomeAbstract {
    abstract fun todo()
}

class MainClass : SomeAbstract(), OnEvent {
    override fun todo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOk() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}