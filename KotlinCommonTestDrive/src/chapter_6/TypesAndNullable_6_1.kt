package chapter_6

/* ВОДДЕРЖКА ЗНАЧЕНИЯ NULL и обработка различных ситуаций */

fun run6_1() {
    val lines = arrayOf(
        "str1",
        "str11",
        "str111",
        "str1111",
        null,
        "str11111",
        "str111111",
        "str1111111",
        "str11111111"
    )

    for (line in lines) {
        // s = строке, если строка не Null, иначе = "..."
        val s: String = line ?: "..."

        // пытаемся поулчить длину строки, если она не null, иначе вернет просто Null
        line?.length

        //тут пытаемся получить длину строки если она не null, иначе если null - возвращаем "empty string"
        // (из-за оператора "elvis" (?:)
        println(line?.length?:"empty string")
    }

    //===============================================================================================================

    testStringAs("somebody")
    testStringAs(42)
    testStringAs(null)

    //===============================================================================================================

    /* так же есть способ заставить компилятор котлина работать в стиле джавы
     * для этого нужно после присвоения значения указать !!, что будет означать что тут допускается null
     * строки ниже вызовут NPE */
    //val someStringMayNull: String = null!!
    //someStringMayNull.length

    //===============================================================================================================

    val dangerString: String? = null
    // не получится, потому что ожидает именно String а не String?
    //needStringExplicit(dangerString)

    // а вот так можно. let проверяет на null и передает в лямбду сам объект (в данном случае String)
    // т.е просто превращает String? в String
    dangerString?.let { str -> needStringExplicit(str) }

    // или если еще больше сократить
    dangerString?.let { needStringExplicit(it) }

    //===============================================================================================================

    val test11 = MyServiceTest()
    /* Так получим эксепшнн
     * kotlin.UninitializedPropertyAccessException: lateinit property someBody has not been initialized
     * Это благодоря использованию модификатора lateinit, теперь вместо NPE сразу понятно в чем оишбка
     * к тому же, если не использовать lateinit, Kotlin будет ругаться что поле не проинициализировано */
    //test11.runService()

    test11.lateInit()
    test11.runService()

    //===============================================================================================================

    val str1: String? = "sdas"
    val str2: String? = "fsdfds"
    val str3: String? = ""
    val str4: String? = null

    println(str1.isNullOrEmpty())
    println(str2.isNullOrEmpty())
    println(str3.isNullOrEmpty())
    println(str4.isNullOrEmpty())

    println()
    println(1_000_000)

}

class MyServiceTest {

    private lateinit var someBody: MyService

    fun lateInit() {
        someBody = MyService("some service")
    }

    fun runService() {
        someBody.run()
    }


}

class MyService {
    constructor(name: String) {

    }

    fun run() {}
}

fun needStringExplicit(value: String) {
    println("ta-ta-ta and $value")
}

//знак ? псоле типа означает что значение может содержать null
fun testStringAs(s: Any?) {

    /* тут получается логика такая: если s не String, то as? вернет null.
    Т.е. если s == 42 или s == null, результат будет null */
    val thisIsString = s as? String
    println("actually, contains $thisIsString")

    /* последний оператор ?: проверяет, если thisIsString == null, то он подставляет 0 */
    println("this is string, and length = ${thisIsString?.length ?: 0}")
}