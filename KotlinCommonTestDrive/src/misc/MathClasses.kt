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
                    is Num -> e.value
                    is Sum -> eval(e.right) + eval(e.left)
                    else -> throw IllegalArgumentException("hz")
                }
    }
}