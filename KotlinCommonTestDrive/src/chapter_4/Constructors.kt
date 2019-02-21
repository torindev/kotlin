package chapter_4

/*
    Класс с двумя вторичными конструкторами (первичного нет)
*/
open class View {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: AttributeSet) {

    }
}

/*
    варианты наследование от View
*/
class MyButton1(ctx: Context, attr: AttributeSet) : View(ctx, attr) {

}

class MyButton2 : View {
    constructor(ctx: Context) : super(ctx) {

    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {

    }
}

// класс с первичным конструктором
open class View2(ctx: Context) {

}

class Context {}
class AttributeSet {}