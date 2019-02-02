import chapter_1_2_3_4.misc.ColorsAdvanced.*
import chapter_1_2_3_4.misc.ColorsAdvanced
import java.lang.Exception
import kotlin.random.Random
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


fun runMyTest1() {
    val w = WhenTD();
    w.testMyWhenGuessTheNum(5)
    w.testMyWhenGuessTheNum(10)
    w.testMyWhenGuessTheNum(3)
    w.testMyWhenGuessTheNum(7)
    w.testMyWhenGuessTheNum(18)
}

fun runAutoTypeTest() {
    val w1 = WhenTD()
    w1.testAutoTypeConversion("what?")
    w1.testAutoTypeConversion(0.5)
}

class WhenTD {


    // Автоматическиое приведение типа, очень сильная штука
    fun testAutoTypeConversion(obj: Any) {
        when (obj) {
            is Int -> {
                println("this is Int")
            }
            is String -> {
                println("this is String")
            }
            else -> {
                println("Who is fucking know, what is this...")

            }
        }
    }





    private var num = Random.nextInt(20)
    private var attempts = 0

    fun testMyWhenGuessTheNum(guessWhatIsNum: Int) {

        when {
            guessWhatIsNum < num -> {
                println("Твое число $guessWhatIsNum, но загаданное число больше...")
                attempts++
            }
            guessWhatIsNum > num -> {
                println("Твое число $guessWhatIsNum, но загаданное число меньше...")
                attempts++
            }
            else -> {
                println("Твое число $guessWhatIsNum, и ты наконец угадал! попыток: $attempts")
                attempts = 0
                num = Random.nextInt(20)
            }
        }
    }
    fun getMnemonic(colorsAdvanced: ColorsAdvanced) =
            when (colorsAdvanced) {
                RED -> "Каждый"
                ORANGE -> "Охотник"
                YELLOW -> "Желает"
                GREEN -> "Знать"
                BLUE -> "Где"
                INDIGO -> "Сидит"
                VIOLET -> "Фазан"
            }

    fun getWarmth(colorsAdvanced: ColorsAdvanced) = when(colorsAdvanced) {
        RED, ORANGE, YELLOW -> "Теплый"
        GREEN -> "Нейтральный"
        BLUE, INDIGO, VIOLET -> "Холодный"
        else -> "dummy"
    }

    fun mix(c1: ColorsAdvanced, c2: ColorsAdvanced) =
        when(setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("dirty color")
        }

    fun mixOptim(c1: ColorsAdvanced, c2: ColorsAdvanced) =
            when {
                (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
                (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
                (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
                else -> throw Exception("dirty color")
            }

    fun myWhenTd(i1: Int, i2: Int) =
            when {
                i1 > i2 -> i1
                i2 > i1 -> i2
                else -> i1
            }
}