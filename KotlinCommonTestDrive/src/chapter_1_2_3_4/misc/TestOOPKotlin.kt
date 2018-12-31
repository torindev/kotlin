import java.util.*

class TestOOPKotlin {

    private constructor()

    companion object {
        fun create() = TestOOPKotlin()
        fun somethingStatic() {
            println("something static")
        }
        val abc: Int = 5
    }



    fun doSomething1() {
        println("something 1, abc = $abc");
    }

    fun somethingRand() = Random().nextInt(100)
}