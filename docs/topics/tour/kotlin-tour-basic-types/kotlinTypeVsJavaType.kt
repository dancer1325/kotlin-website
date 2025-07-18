// // Explicitly declare the correct type for each variable
fun main() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d:Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'

    val typeA = a::class.simpleName
    val typeJavaA = a::class.java.typeName
    println("typeA $typeA")
    println("typeJavaA $typeJavaA")

    val typeB = b::class.simpleName
    val typeJavaB = b::class.java.typeName
    println("typeB $typeB")
    println("typeJavaB $typeJavaB")

    val typeC = c::class.simpleName
    val typeJavaC = c::class.java.typeName
    println("typeC $typeC")
    println("typeJavaC $typeJavaC")

    val typeD = d::class.simpleName
    val typeJavaD = d::class.java.typeName
    println("typeD $typeD")
    println("typeJavaD $typeJavaD")

    val typeE = e::class.simpleName
    val typeJavaE = e::class.java.typeName
    println("typeE $typeE")
    println("typeJavaE $typeJavaE")

    val typeF = f::class.simpleName
    val typeJavaF = f::class.java.typeName
    println("typeF $typeF")
    println("typeJavaF $typeJavaF")
}