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

* TODO:
```kotlin
//sampleStart
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
//sampleEnd

fun main() {
    println("max of 0 and 42 is ${maxOf(0, 42)}")
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-conditional-expressions"}

In Kotlin, `if` can also be used as an expression:

```kotlin
//sampleStart
fun maxOf(a: Int, b: Int) = if (a > b) a else b
//sampleEnd

fun main() {
    println("max of 0 and 42 is ${maxOf(0, 42)}")
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-if-expression"}

See [`if`-expressions](docs/topics/control-flow.md#if-expression).

## for loop

```kotlin
fun main() {
//sampleStart
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-for-loop"}

or:

```kotlin
fun main() {
//sampleStart
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-for-loop-indices"}

See [for loop](docs/topics/control-flow.md#for-loops).

## while loop

```kotlin
fun main() {
//sampleStart
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-while-loop"}

See [while loop](docs/topics/control-flow.md#while-loops).

## when expression

```kotlin
//sampleStart
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
//sampleEnd

fun main() {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-when-expression"}

See [when expression](docs/topics/control-flow.md#when-expression).

## Ranges

Check if a number is within a range using `in` operator:

```kotlin
fun main() {
//sampleStart
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-range-in"}

Check if a number is out of range:

```kotlin
fun main() {
//sampleStart
    val list = listOf("a", "b", "c")
    
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-out-of-range"}

Iterate over a range:

```kotlin
fun main() {
//sampleStart
    for (x in 1..5) {
        print(x)
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-iterate-range"}

Or over a progression:

```kotlin
fun main() {
//sampleStart
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-iterate-progression"}

See [Ranges and progressions](docs/topics/ranges.md).

## Collections

Iterate over a collection:

```kotlin
fun main() {
    val items = listOf("apple", "banana", "kiwifruit")
//sampleStart
    for (item in items) {
        println(item)
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-iterate-collection"}

Check if a collection contains an object using `in` operator:

```kotlin
fun main() {
    val items = setOf("apple", "banana", "kiwifruit")
//sampleStart
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-collection-in"}

Use [lambda expressions](lambdas.md) to filter and map collections:

```kotlin
fun main() {
//sampleStart
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
      .filter { it.startsWith("a") }
      .sortedBy { it }
      .map { it.uppercase() }
      .forEach { println(it) }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-collection-filter-map"}

See [Collections overview](docs/topics/collections-overview.md).

## Nullable values and null checks

A reference must be explicitly marked as nullable when `null` value is possible. Nullable type names have `?` at the end.

Return `null` if `str` does not hold an integer:

```kotlin
fun parseInt(str: String): Int? {
    // ...
}
```

Use a function returning nullable value:

```kotlin
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

//sampleStart
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }    
}
//sampleEnd

fun main() {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-function-nullable-value"}

or:

```kotlin
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    
//sampleStart
    // ...
    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // x and y are automatically cast to non-nullable after null check
    println(x * y)
//sampleEnd
}

fun main() {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("99", "b")
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-basic-syntax-function-null-check"}

See [Null-safety](docs/topics/null-safety.md).

## Type checks and automatic casts

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

