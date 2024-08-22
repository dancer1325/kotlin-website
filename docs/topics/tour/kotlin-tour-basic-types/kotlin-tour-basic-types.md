[//]: # (title: Basic types)

* ⚠️Every variable & data structure | Kotlin → has a data type ⚠️
* allows
  * indicating to the compiler what you are allowed doing with it
    * === functions & properties
* Type inference
  * := availability of Kotlin to infer the data type
* augmented assignments operators -- Check [Augmented assignments](operator-overloading.md#augmented-assignments) --
  * `+=`
  * `-=`
  * `*=`
  * `/=`
  * `%=`

* basic types
  * categories 
    * 👁️ NOT keywords 👁️
  * `:`
    * uses
      * declare a variable / NOT initialized

| **Category**           | **Basic types**                    | **Example code**                                              |
|------------------------|------------------------------------|---------------------------------------------------------------|
| Integers               | `Byte`, `Short`, `Int`, `Long`     | `val year: Int = 2020`                                        |
| Unsigned integers      | `UByte`, `UShort`, `UInt`, `ULong` | `val score: UInt = 100u`                                      |
| Floating-point numbers | `Float`, `Double`                  | `val currentTemp: Float = 24.5f`, `val price: Double = 19.99` |
| Booleans               | `Boolean`                          | `val isEnabled: Boolean = true`                               |
| Characters             | `Char`                             | `val separator: Char = ','`                                   |
| Strings                | `String`                           | `val message: String = "Hello, world!"`                       |
