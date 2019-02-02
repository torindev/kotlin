import chapter_1_2_3_4.misc.ColorsAdvanced.*
import chapter_1_2_3_4.misc.ColorsAdvanced
import java.lang.Exception

class WhenTD {
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