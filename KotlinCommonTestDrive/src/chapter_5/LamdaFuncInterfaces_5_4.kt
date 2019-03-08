package chapter_5

fun run5_4() {
    val foo = Foo()

    val lis = object : OnClickListener {
        override fun onClick() {

        }
    }

    foo.setOnClickListener {
        println("five, ${it.cause}")
    }

    foo.bar {
        it == 5
    }

    val sum = {x: Int, y: Int -> x + y}
    println(sum(2, 3))

}

interface OnClickListener {
    fun onClick()
}

class Error(var cause: String)

class Foo {
    fun setOnClickListener(listener: (e: Error) -> Unit) {
        listener.invoke(Error("mn"))
    }

    fun bar(some: (Int) -> Boolean) {

    }
}