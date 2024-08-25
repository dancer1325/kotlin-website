fun main() {
    // 1. Integer types
    // 1.1 infer type
    // 1.1.1 Although ANY interger type could be -> infered by default as `Int`
    val integerInferredDefaultOne = -126
    println(integerInferredDefaultOne::class.simpleName)
    // 1.1.2 if Int's range is exceeded -> type is `Long`
    val integerInferredNotDefault = -2147483649
    println(integerInferredNotDefault::class.simpleName)
    // 1.2 suffix `L`
    val numberWithSuffixLong = 2L
    println(numberWithSuffixLong::class.simpleName)

    // 2. Floating-point types
    // 2.1 inferred by default as double
    val floatingInferredDefaultOne = 3.14
    println(floatingInferredDefaultOne::class.simpleName)
    // 2.2 suffix `F` or `f`
    val numberWithSuffixFloat = 3.14F
    println(numberWithSuffixFloat::class.simpleName)
    val numberWithSuffixFloatLower = 3.14f
    println(numberWithSuffixFloatLower::class.simpleName)
    // 2.3 if you specify > 6-7 decimal digits -> it's rounded
    val floatSpecifyingMoreThanValidDecimalDigits = 2.7182818284f
    println("floatSpecifyingMoreThanValidDecimalDigits ${floatSpecifyingMoreThanValidDecimalDigits}")
    println(floatSpecifyingMoreThanValidDecimalDigits::class.simpleName)
    // 2.4 NO implicit widening conversions
    fun printDouble(d: Double) { print(d) } // ONLY accept double
    val i = 1
    val d = 1.0
    val f = 1.0f
    printDouble(d)
    //printDouble(i) // Error: Type mismatch
    //printDouble(f) // Error: Type mismatch

    // 3. Literal constants for numbers
    // 3.1 for integral values
    // 3.1.1 decimal
    val decimalInt = 123   // Int
    val decimalLong = 123L // Long
    // 3.1.2 hexadecimal
    val hexInt = 0x7B      // Int, equivalent to 123 in decimal
    val hexLong = 0x7BL    // Long, equivalent to 123 in decimal
    // 3.1.3 binaries
    val binaryInt = 0b1111011   // Int, equivalent to 123 in decimal
    val binaryLong = 0b1111011L // Long, equivalent to 123 in decimal
    // 3.2 _
    val oneMillion = 1_000_000
    println("oneMillion ${oneMillion}")
    val hexBytes = 0xFF_EC_DE_5E
    println("hexBytes ${hexBytes}")
    val binary = 0b11010010_01101001_10010100_10010010
    println("binary ${binary}")

    // 4. numbers | JVM platform
    // 4.1 different representation / boxed
    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b
    println(boxedB === anotherBoxedB) // false  == different boxed objects
    // EXCEPT to `Integer` in [-128, 127]
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // true

    // 5. Explicit number conversions
    // 5.1 smaller types != subtypes of bigger types -> NO implicit conversion
    val intNumber: Int? = 1     // boxed Int (java.lang.Integer) | JVM
    //val longNumber: Long? = intNumber    // NOT implicit conversion -> boxed Long (java.lang.Long) | JVM
    val anotherLongNumber = intNumber?.toLong()     // IMPLICIT conversion
    println("intNumber::class.simpleName ${intNumber!!::class.simpleName}")
    println("anotherLongNumber::class.simpleName ${anotherLongNumber!!::class.simpleName}")
    // 5.2 smaller -- can NOT be compared with -- bigger type
    val longNumber: Long = 1
    // println(longNumber == intNumber)
    // println(longNumber === intNumber)
    // 5.3 arithmetical operations
    val addition = 1L + 3       // Long + Int => Long
    println("addition::class.simpleName ${addition::class.simpleName}")
}