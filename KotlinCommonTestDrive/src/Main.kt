import chapter_1_2_3_4.misc.*
import chapter_1_2_3_4.runDelegationTest
import java.util.*

fun main(args: Array<String>){
    val cs = ColorsSimple.BLUE
    println(cs)

    val csa = ColorsAdvanced.INDIGO
    val csa1 = ColorsAdvanced.ORANGE
    val csa2 = ColorsAdvanced.VIOLET
    val csa3 = ColorsAdvanced.RED
    val csa4 = ColorsAdvanced.BLUE
    println(csa.rgbHex())
    println(csa1.rgb())
    println(csa2.rgb())
    println(csa3.rgb())
    println(csa4.rgbHex())
}