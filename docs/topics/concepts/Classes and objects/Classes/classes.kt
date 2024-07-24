import kotlin.reflect.KClass

// Class declaration
class GenericClass<T> public constructor(value: T) {
    // Property
    private val property: T = value

    // Member function
    fun getValue(): T {
        return property
    }

    // Another member function
    fun printValue() {
        println("GenericClass - The value is: $property")
    }
}
class GenericClassWithoutHeader{
    // Member function
    fun printValue() {
        println("GenericClassWithoutHeader")
    }
}
class GenericClassWithoutHeaderNorBody


// Constructors
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}
class NonAbstractWithoutDeclaringConstructors {
    // NonAbstract is the default, since the annotation is not indicated
    fun printMessage() {
        println("NonAbstractWithoutDeclaringConstructors - Hello from MyClass!")
    }
}
        // Check visibility
fun checkVisibility(clazz: KClass<*>) {
    val packageName = clazz.java.`package`?.name
    println("${clazz.simpleName} is in package: $packageName")

    // Determine visibility based on package
    when {
        packageName == null -> println("Unknown visibility (no package)")
        packageName.isBlank() -> println("Top-level class (public)")
        else -> println("Package-private (internal)")
    }
}

// 1. Primary Constructor
// There is just 1!         You can not pass code
// 1.1 Most generic primary sintax
class ClassMostGenericPrimaryConstructor<T> public constructor(value: T) {
    val property = value
    // Member function
    fun printValue() {
        println("ClassMostGenericPrimaryConstructor $property")
    }
}
// 1.2 Without passing annotations nor visibility -> `constructor` keyword can be omitted
class ClassOmittingConstructorKeywordPrimaryConstructor<T> (value: T) {
    val property = value
    // Member function
    fun printValue() {
        println("ClassOmittingConstructorKeywordPrimaryConstructor $property")
    }
}
// 1.3 Checking their arguments
class ClassCheckingPrimaryConstructorArguments<T> (var argumentFirst: T, val argumentTwo, val defaultValue = 4) {
    val property1 = va
}

fun main() {
    // Class declaration
    val intInstance = GenericClass(42)
    intInstance.printValue()
    val stringInstance = GenericClass("Hello, Kotlin!")
    stringInstance.printValue()

    GenericClassWithoutHeader().printValue()

    val genericClassWithoutHeaderNorBody = GenericClassWithoutHeaderNorBody()::class
    println("genericClassWithoutHeaderNorBody " + genericClassWithoutHeaderNorBody)


    // Constructors
    InitOrderDemo("hello")

    NonAbstractWithoutDeclaringConstructors().printMessage()            // using default primary constructor which hasn't got arguments
    checkVisibility(NonAbstractWithoutDeclaringConstructors::class)     // Non abstract class has got public visibility

    // 1. Primary Constructors
    // 1.1 Most generic primary constructor
    ClassMostGenericPrimaryConstructor("Alfred").printValue()
    // 1.2 Without passing annotations nor visibility -> `constructor` keyword can be omitted
    ClassOmittingConstructorKeywordPrimaryConstructor("Alfred").printValue()
}