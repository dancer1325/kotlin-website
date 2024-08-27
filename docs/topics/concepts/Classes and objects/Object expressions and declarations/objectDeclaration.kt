// 1. != object expression
// if you try to compile -> got as an object expression, NOT an object declaration
/*var notRightHandAssignment = object MySingleton {
    private var counter = 0

    fun incrementCounter() {
        counter++
    }

    fun getCounter(): Int {
        return counter
    }
}*/


// 2. To initialize afterwards
object CounterObject {
    // Initialization of the object
    internal var counter = 0

    fun incrementCounter() {
        counter++
    }

    fun getCounter(): Int {
        return counter
    }
}

// 3. can have supertypes
open class MyMouseAdapter {
    open fun mouseClicked() {
        println("MyMouseAdapter - Mouse clicked")
    }

    open fun mouseEntered() {
        println("MyMouseAdapter - Mouse entered")
    }

}


// it's still an object declaration, since it can NOT be assigned in the right hand side
//var objectDeclarationWithSuperTypes = object ObjectDeclarationWithSuperTypes : MyMouseAdapter() {
object ObjectDeclarationWithSuperTypes : MyMouseAdapter() {
    override fun mouseClicked() {
        println("ObjectDeclarationWithSuperTypes - Mouse clicked")
    }

    override fun mouseEntered() {
        println("ObjectDeclarationWithSuperTypes - Mouse entered")
    }
}

// 3.2 object declaration can NOT be inherits directly from another object declaration
/*object ArithmethicObject : CounterObject {
*//*    override fun getCounter(): Int {
        super()
    }*//*
    fun decreaseCounter() {
        CounterObject.counter--
    }
}*/

// 4. companion objects
class MyClass {
    // NO objectname for the companion
    companion object {
        var number = 3
        private val privateNumber = 4
    }

    // class member can get access to a private member of a companion object
    fun sampleFunction() {
        println(privateNumber)
    }
    // ONLY allowed 1! companion object / class  -> Next companion object declaration throws an erro
    /*companion object another {
        val anotherNumber = 4
    }*/
}
class AnotherClass {
    // name for the companion
    companion object nameToCompanionObject{
        var number = 3
    }
}
    //  4.4 companion objects | runtime == real objects
interface Greeter {
    fun greet(): String
}

class ClassCheckCompanionObjectsAreLikeObjects {
    companion object : Greeter {    // companion object / NO name, implementing an interface
        override fun greet(): String {
            return "Hello from the companion object!"
        }
        fun show() {
            println("This is a companion object method.")
        }
    }
}

fun main() {
    // 2. Initialize an object declaration
    CounterObject.incrementCounter()
    var objectInitialized = CounterObject.getCounter()
    println("objectInitialized::class.simpleName ${objectInitialized::class.simpleName} whose value is $objectInitialized")

    // 4. companion object
    val myClass = MyClass()
    // 4.1 `instanceClassName.CompanionObjectMember`  NOT valid
    /*println("myClass.privateNumber ${myClass.privateNumber}")
    println("myClass.number ${myClass.number}")*/
    // 4.2 `ClassName.CompanionObjectMember` just if member is public
    println("MyClass.number ${MyClass.number}")
    //println("MyClass.privateNumber ${MyClass.privateNumber}") NOT valid because it's private
    // 4.3 companion object / name omitted -> refer to it via `ClassName.Companion`
    val companionReference = MyClass.Companion
    println("companionReference ${companionReference}")     // ClassName is print as reference to the companion object
    println("companionReference.number ${companionReference.number}")
    // companion object / name -> refer to it via it's name
    val anotherCompanionReferenceByName = AnotherClass.nameToCompanionObject
    println("anotherCompanionReferenceByName ${anotherCompanionReferenceByName}") // ClassName is print as reference to the companion object
    // val anotherCompanionReference = AnotherClass.Companion       NOT valid to refer by Companion
    //println("anotherCompanionReference ${anotherCompanionReference}")
    // 4.4 companion objects | runtime == objects
    // reference of type Greeter / -- assigned to -- ClassCheckCompanionObjectsAreLikeObjects == reference to the companion object
    val greeter: Greeter = ClassCheckCompanionObjectsAreLikeObjects
    println(greeter.greet())    // call from this reference to the method -> proving companion object is a real object

    // Checking the runtime type
    println("Is companion object an instance of Greeter? ${ClassCheckCompanionObjectsAreLikeObjects is Greeter}")
}