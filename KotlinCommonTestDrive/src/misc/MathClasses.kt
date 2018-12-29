package misc

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Num, val right: Num) : Expr

class MathTree {
    companion object {
        fun eval(e: Expr): Int =
                when (e) {
                    is Num -> {
                        println("num: ${e.value}")
                        e.value
                    }
                    is Sum -> {
                        val left = eval(e.left)
                        val right = eval(e.right)
                        println("sum: $left + $right")
                        left + right
                    }
                    else -> throw IllegalArgumentException("hz")
                }

        fun testEval() {
            // (1 + 2) + 4
            println(
                eval(Sum(Num(eval(Sum(Num(1), Num(2)))), Num(4)))
            )
        }
    }
}