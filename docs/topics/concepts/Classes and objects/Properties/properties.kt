fun declaringProperties() {
    // 1. NOT possible to reinitialize the SAME variable
    var varFirst = 2
    varFirst = 3
    //var varFirst = 2
    println("varFirst " + varFirst)
    varFirst = 3
    println("varFirst adjusted " + varFirst)

    // 2. specify `[: <PropertyType>]` OR `[= <property_initializer>]`
    // var allByDefault     // ERROR:
    // 2.1
    var specifyPropertyByInitializing = 2
    // 2.2
    var specifyPropertyByGetter get() = 'Hello'


    // 3. val is read-only
    val valFirst = 2
    //valFirst = 3                  # Error | compiling time
    println("val valFirst" + valFirst)
}

fun defineGetterAndSetter() {
    // 4. `[<getter>]` & `[<setter>]`
    // 4.1. | local variables (| functions), NOT ALLOWED
    var propertyWithGetterAndSetter = 2
      /*get() = field
      set(value) {
        if (value > 0) field = value
      }*/

    println("propertyWithGetterAndSetter " + propertyWithGetterAndSetter)

    // 4.2 | class properties
    val myClass = MyClass()
    println("myClass.property - BEFORE set - " + myClass.property)
    myClass.property = 3
    println("myClass.property - AFTER set - " + myClass.property)
    val rectangle = Rectangle(3, 4)
    println("Width=${rectangle.width}, height=${rectangle.height}, area=${rectangle.area}")

    // 4.3 `val` does NOT allow setter
    //myClass.readOnlyProperty = 5
}

class MyClass {
    var property = 2
        // ALLOWED to customize getter & setters
        get() = field
        set(value) { field = value }

    val readOnlyProperty = 2
        // setter NOT ALLOWED | val
        //set(value) { field = value }
}

class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = this.width * this.height        // custom getter
}

fun main() {
    declaringProperties()
    defineGetterAndSetter()
}
