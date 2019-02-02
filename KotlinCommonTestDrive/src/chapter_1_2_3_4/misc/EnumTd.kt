package chapter_1_2_3_4.misc

enum class ColorsSimple {
    RED, ORGNGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class ColorsAdvanced(val r:Int, val g:Int, val b:Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0),
    BLUE(0, 0, 255), INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // в данном примере точка с запятой тут должна быть

    fun rgb() = (r * 256 + g) * 256 + b // из книги, не понял что делает

    fun rgbHex(): String {
        return Integer.toHexString(rgb())
    }

}