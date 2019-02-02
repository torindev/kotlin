package chapter_1_2_3_4.misc

fun foo() {
    val a = 1
    val b = "please"
    //a++ НЕТ.

    var c = 2
    c++ //ДА

    //val d НЕТ.
    val d: Int // ДА (если не присваивать значение, то нужно указывать тип)

    // give me a word please
    println("give me a word $b")

    // i can calculate how much will 2*2 = 4
    println("i can calculate how much will 2*2 = ${2 * 2}")

}