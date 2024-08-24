[//]: # (title: Basic syntax)

* Check [Kotlin Core track](https://hyperskill.org/tracks?category=4&utm_source=jbkotlin_hs&utm_medium=referral&utm_campaign=kotlinlang-docs&utm_content=button_1&utm_term=22.03.23)

## Package definition and imports

* 

    ```
    package nameOfThePackage
    
    import packageNameToImport1
    import packageNameToImport2
    ...
    ```
  * 👀 it must be | top of the source file 👀

* Check [Packages](docs/topics/packages.md)

## Program entry point

* `main` function

    ```
    fun main() {
      …
    }
    
    // OR
  
    fun main(args: Array<String>) {
      println(args.contentToString())
    }
    ```

## Print to the standard output

* `print` & `println`

## Read from the standard input

* `readln()`
* Check [Read standard input](read-standard-input.md)

## Functions

* `fun`
  * `Unit` as return type -- can be -- omitted
* Check [Kotlin Tour Functions](docs/tour/kotlin-tour-functions/kotlin-tour-functions.md) & [Functions](docs/topics/functions.md)

## Variables

* `val` or `var`
  * can be declared | top level
* type inference
* Check [Kotlin Tour Basic Types](docs/tour/kotlin-tour-basic-types/kotlin-tour-basic-types.md)
* Check [Kotlin Tour Basic Types](docs/tour/kotlin-tour-classes/kotlin-tour-classes.md) & [Properties](properties.md).

## Creating classes and instances

* `class`
  * properties
    * can be declared |
      * class header OR
      * class' body
  * primary constructor 
  * ⚠️by default, they are final ⚠️
  * `class className ... : classParentName`
    * ⭐`:` marks inheritance ⭐
    * requirements
      * ⚠️`classParentName` must be `open` ⚠️
* Check [Kotlin Tour Basic Types](docs/tour/kotlin-tour-classes/kotlin-tour-classes.md), [Classes](classes.md) & [Objects and instances](object-declarations.md)

## Comments

* single-line (or _end-of-line_) & multi-line (_block_) comments
  * can be nested
  * == most modern languages
* Check [Documenting Kotlin Code](docs/topics/kotlin-doc.md) 

## String templates

* `"${somethingToEvaluate}"`
* Check [Kotlin Tour Hello World](docs/tour/kotlin-tour-classes/kotlin-tour-hello-world.md) & [String templates](docs/topics/strings.md#string-templates)

## Conditional expressions

* Check [Kotlin Tour Control Flow](docs/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md)

## for loop

* Check [Kotlin Tour Control Flow](docs/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md) & [for loop](docs/topics/control-flow.md#for-loops)

## while loop

* Check [Kotlin Tour Control Flow](docs/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md) & [while loop](docs/topics/control-flow.md#while-loops)

## when expression

* Check [Kotlin Tour Control Flow](docs/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md) & [when expression](docs/topics/control-flow.md#when-expression)

## Ranges

* Check [Kotlin Tour Control Flow](docs/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md) & [Ranges and progressions](docs/topics/ranges.md)

## Collections

* Check [Kotlin Tour Collections](docs/tour/kotlin-tour-collections/kotlin-tour-collections.md) & [Collections overview](docs/topics/collections-overview.md)

## Nullable values and null checks

* Check [Kotlin Tour Collections](docs/tour/kotlin-tour-null-safety/kotlin-tour-null-safety.md) & [Null-safety](docs/topics/null-safety.md)

## Type checks and automatic casts

* TODO:
The `is` operator checks if an expression is an instance of a type.
If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly:

```kotlin
//sampleStart
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}
//sampleEnd

fun main() {
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-is-operator"}

or:

```kotlin
//sampleStart
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}
//sampleEnd

fun main() {
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-is-operator-expression"}

or even:

```kotlin
//sampleStart
fun getStringLength(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}
//sampleEnd

fun main() {
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength("")
    printLength(1000)
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-is-operator-logic"}

See [Classes](docs/topics/concepts/Classes and objects/Classes/classes.md) and [Type casts](docs/topics/typecasts.md).

