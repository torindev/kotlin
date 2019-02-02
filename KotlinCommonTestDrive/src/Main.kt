import chapter_1_2_3_4.misc.*
import chapter_1_2_3_4.runDelegationTest
import java.util.*

fun main(args: Array<String>){
    val rect = MyRectangle(3, 4)
    rect.isSquare

    val w1 = Woman(2)
    println("tits size: ${w1.getTits()}")
}