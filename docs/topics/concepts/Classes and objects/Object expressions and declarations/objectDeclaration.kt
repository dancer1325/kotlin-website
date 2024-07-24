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

fun main() {
    // 2. Initialize an object declaration
    CounterObject.incrementCounter()
    var objectInitialized = CounterObject.getCounter()
    println("objectInitialized::class.simpleName ${objectInitialized::class.simpleName} whose value is $objectInitialized")


}