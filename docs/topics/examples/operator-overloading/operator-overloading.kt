// 1. overload an operator     -> use `operator`
interface IndexedContainer {
    operator fun get(index: Int)
}

// 2. if you override -> you can omit `operator`
class OrdersList: IndexedContainer {
    override fun get(index: Int) { /*...*/ }
}

// 3. overload `unaryMinus()` operator
data class Point(val x: Int, val y: Int)
operator fun Point.unaryMinus() = Point(-x, -y)
val point = Point(10, 20)

fun main() {
    // 4. built-in operators | basic types
    val byteVal: Byte = 2
    val negativeByteVal: Byte = -2
    // TODO: Why the next ones are not signed changed?
    val negativeByteApplyingUnaryPlusVal: Int = negativeByteVal.unaryPlus()		// Applied to Byte, returns Int
    val negativeByteApplyingPlusSignVal: Int = +negativeByteVal    		// Applied to Byte, returns Int
    val shortVal: Short = 2
    val intVal: Int = 2
    val intNegativeVal: Int = -2
    // TODO: Why the next one are not signed changed?
    val intNegativeApplyingPlusSignVal = +intNegativeVal
    val longVal: Long = 2L
    val floatVal: Float = 2.22f
    val doubleVal: Double = 2.14

    // + or .unaryPlus()
    println("+byteVal ${+byteVal}")
    println("byteVal.unaryPlus() ${byteVal.unaryPlus()}")
    println("+negativeByteVal ${+negativeByteVal}")
    println("negativeByteVal.unaryPlus() ${negativeByteVal.unaryPlus()}")
    println("negativeByteApplyingUnaryPlusVal ${negativeByteApplyingUnaryPlusVal}")
    println("negativeByteApplyingPlusSignVal ${negativeByteApplyingPlusSignVal}")
    println("+shortVal ${+shortVal}")
    println("shortVal.unaryPlus() ${shortVal.unaryPlus()}")
    println("+intVal ${+intVal}")
    println("intVal.unaryPlus() ${intVal.unaryPlus()}")
    println("+intNegativeVal ${+intNegativeVal}")
    println("intNegativeApplyingPlusSignVal ${intNegativeApplyingPlusSignVal}")
    println("+longVal ${+longVal}")
    println("longVal.unaryPlus() ${longVal.unaryPlus()}")
    println("+floatVal ${+floatVal}")
    println("floatVal.unaryPlus() ${floatVal.unaryPlus()}")
    println("+doubleVal ${+doubleVal}")
    println("doubleVal.unaryPlus() ${doubleVal.unaryPlus()}")



    println(-point)  // prints "Point(x=-10, y=-20)"

}