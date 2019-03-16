// это скажет компилятору что нуно создать класс (и файл) с таким именем,
// Если убрать аннотацию, то имя класса было бы как имя файла + KT, т.е. = CollectionsAndFunctionsTestDriveKT
@file: JvmName("KollectionsTD")
package chapter_1_2_3_4.misc

//Это аналог public static final String MY_NAME_IS из Java
const val MY_NAME_IS = "DMITRIY"

// Если нужно изменяемое статическое значение:
var somethingLikeThis = 44

/*
*   функции, объявленные вне тела класса называются функциями верхнего уровня
*   это аналог того, как если бы у меня был класс Utils и в нем было бу куча статических методов
*   т.е. это просто обычная статическая функция
*   тут тоже самое, только без класса. Эти функции будут доступны из любого места проекта (с помощью импорта)
*   например чтобы функция initCollections() была досутпна в Main,
*   ее нужно импортировать вот так:
*   import chapter_1_2_3_4.misc.initCollections
* */

fun runCollectionsAndFunsTestDrive() {

    val mass = arrayOf("one", "two", "three")
    for (i in mass.indices) {
        println("$i) value = ${mass[i]}")
    }

    val letters = Array(26) {i -> ('a' + i).toString()}
    for (s in letters) {
        print("$s:")
    }
    println()
    println(letters.joinToString(""))



    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 5, 3)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")

    val isReal = list.any { it == 5 }

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(list.last())
    println(list.first())
    println(set.max())

    val list1 = listOf(1, 3, 5, 7, 6, 4, 2)
    println(list1.javaClass.toString() + " -> " + list1)
    println(joinToStringTd(
        collection = list1,
        separator = ";",
        prefix = "(",
        postfix = ")"
    ))

    println(joinToStringTd(list1, prefix = "(", separator = "(*_*)"))

    // или так
    println(list.joinToString(separator = ";", prefix = "(", postfix = ")"))

}

fun testStringSplit() {
    val line = "something.like.this-and-this_and_another=one"
    // да, я полуу массив из трех элементов с помощью этого сплита
    val mass = line.split(".")
    println(mass)

    // чтобы получить поведение как в Джава, нужно
    val mass2 = line.split(".".toRegex())
    println(mass2) //выведет массив из 19 "ничего"

    val mass3 = line.split(".", "-", "_", "=")
    println(mass3)
}

data class ParsedPath(val dir: String, val fullName: String, val fileName:String, val ext: String);

fun parsePath(path: String): ParsedPath {
    val dir = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val ext = fullName.substringAfterLast(".")

    return ParsedPath(dir, fullName, fileName, ext)
}


// Оператор распаковки и переменно число аргументов
fun tsts(vararg ints: Int) {
    // тут ints ведет себя как массив
    val list1 = listOf("args: ", ints)

    //или если есть массив
    val array = arrayOf("some", "another", "one")
    // оператор * перед переменной означает "распаковать"
    val list2 = listOf("sdasd", *array)
}


// функция с значениями по умолчанию
// если не указать их (параметры) при вызове, то будут использованы значения по умолчанию
// чтобы воспользоваться этой возможностью, нужно вызывать только с именами параметров
fun <T> joinToStringTd(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((i, v) in collection.withIndex()) {
        if (i > 0) result.append(separator).append(" ")
        result.append(v)
    }

    result.append(postfix)
    return result.toString()
}

// Функция-расширение - это функция, которая может вызываться как член класса,
// но поределена за его пределами.
// Например данный пример можно вызвать так: "Kotlin".lastChar() -  выведет 'n'
// тут String - Тип получатель, а this - объект-получатель (у которого тип String, Карл)
// Вызвать из Java это расширение можно так CollectionsAndFunctionsTestDriveKT.lastChar("Kotlin"); - вернет букву 'n'
fun String.lastChar(): Char = this.get(this.length - 1)

// Точно так же можно добавить и свойства:
val String.lastC: Char
    get() = get(length- 1)


// из книги
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((i, v) in this.withIndex()) {
        if (i > 0) result.append(separator).append(" ")
        result.append(v)
    }

    result.append(postfix)
    return result.toString()
}