[//]: # (title: Collections)

* allows
  * data -- is grouped into -- structures
* types
  * 👁️mutable & read-only / collection type 👁️

| **Collection type** | **Description**                                                         |
|---------------------|-------------------------------------------------------------------------|
| Lists               | Ordered collections of items                                            |
| Sets                | Unique unordered collections of items                                   |
| Maps                | Sets of key-value pairs where keys are unique and map to only one value |


## List

* := ordered collection of items
  * allowed
    * duplicated items
* [`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/)
  * 👁️ read only 👁️
    * ⚠️-> writing operations NOT allowed ⚠️ -- _Example:_ `.remove()` --
  * [`listOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html)
    * function / create it
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/#functions)
    * `.first()`, `.last()` & `count()`
      * extension functions
* [`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list.html)
  * 👁️mutable 👁️
    *  ⚠️ Although you declare a variable as `val` -> you can add (`.add()`) or remove (`.remove()`) entries ⚠️
  * [`mutableListOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html) 
    * function / create it
  * ⚠️— can be cast to a → `List` ⚠️
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/#functions)
* type inference
  * == infer the type of the items stored
  * if you want to specify -> `List<TypeOfList>` 
* operators can be applied | them
  * `in`
  * `[]`
    * access to an item
      * Reason: 🧠 it's possible because items are ordered 🧠

## Set

* := 👁️ unique unordered 👁️ collection of items
  * if you try to pass several times the same argument → it’s dropped
  * 
* [`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/)
  * read-only
    *  ⚠️-> writing operations NOT allowed ⚠️ -- _Example:_ `.remove()` --
  * [`setOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/set-of.html)
    * function / create it
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/#functions)
    * `.count()`
* [`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/)
  * mutable
  * [`mutableSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-set-of.html) 
  * ⚠️— can be cast to a → `Set` ⚠️
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/#functions)
* type inference
  * == infer the type of the items stored
  * if you want to specify -> `Set<TypeOfSet>` 
* operators can be applied | them
  * `in`
  * `[]`
    * ❌NOT allowed ❌
      * Reason: 🧠 it's unordered 🧠

## Map

* TODO:
Maps store items as key-value pairs. You access the value by referencing the key. You can imagine a map like a food menu.
You can find the price (value), by finding the food (key) you want to eat. Maps are useful if you want to look up a value
without using a numbered index, like in a list.

> * Every key in a map must be unique so that Kotlin can understand which value you want to get. 
> * You can have duplicate values in a map.
>
{type="note"}

To create a read-only map ([`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/)), use the 
[`mapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-of.html) function.

To create a mutable map ([`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/)),
use the [`mutableMapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-map-of.html) function.

When creating maps, Kotlin can infer the type of items stored. To declare the type explicitly, add the types
of the keys and values within angled brackets `<>` after the map declaration. For example: `MutableMap<String, Int>`.
The keys have type `String` and the values have type `Int`.

The easiest way to create maps is to use [`to`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html) between each 
key and its related value:

```kotlin
fun main() {
//sampleStart
    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)
    // {apple=100, kiwi=190, orange=100}

    // Mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(juiceMenu)
    // {apple=100, kiwi=190, orange=100}
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-maps-declaration"}

> To prevent unwanted modifications, you can create a read-only view of a mutable map by assigning it to a `Map`:
> 
> ```kotlin
>     val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
>     val juiceMenuLocked: Map<String, Int> = juiceMenu
> ```
>
{type="tip"}

To access a value in a map, use the [indexed access operator](operator-overloading.md#indexed-access-operator) `[]` with
its key:

```kotlin
fun main() {
//sampleStart
    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("The value of apple juice is: ${readOnlyJuiceMenu["apple"]}")
    // The value of apple juice is: 100
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-access"}

> If you try to access a key-value pair with a key that doesn't exist in a map, you see a `null` value:
>
> ```kotlin
> fun main() {
> //sampleStart
>     // Read-only map
>     val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
>     println("The value of pineapple juice is: ${readOnlyJuiceMenu["pineapple"]}")
>     // The value of pineapple juice is: null
> //sampleEnd
> }
> ```
> {kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-no-key" validate="false"}
> 
> This tour explains null values later in the [Null safety](kotlin-tour-null-safety.md) chapter.
> 
{type="note"}

You can also use the [indexed access operator](operator-overloading.md#indexed-access-operator) `[]` to add items to a mutable map:

```kotlin
fun main() {
//sampleStart
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    juiceMenu["coconut"] = 150 // Add key "coconut" with value 150 to the map
    println(juiceMenu)
    // {apple=100, kiwi=190, orange=100, coconut=150}
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-add-item"}

To remove items from a mutable map, use the [`.remove()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/remove.html) 
function:

```kotlin
fun main() {
//sampleStart
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    juiceMenu.remove("orange")    // Remove key "orange" from the map
    println(juiceMenu)
    // {apple=100, kiwi=190}
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-put-remove"}

To get the number of items in a map, use the [`.count()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/count.html)
function:

```kotlin
fun main() {
//sampleStart
    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("This map has ${readOnlyJuiceMenu.count()} key-value pairs")
    // This map has 3 key-value pairs
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-count"}

To check if a specific key is already included in a map, use the [`.containsKey()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains-key.html)
function:

```kotlin
fun main() {
//sampleStart
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu.containsKey("kiwi"))
    // true
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-contains-keys"}

To obtain a collection of the keys or values of a map, use the [`keys`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/keys.html)
and [`values`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/values.html) properties respectively:

```kotlin
fun main() {
//sampleStart
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu.keys)
    // [apple, kiwi, orange]
    println(readOnlyJuiceMenu.values)
    // [100, 190, 100]
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-keys-values"}

> [`keys`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/keys.html) and [`values`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/values.html)
> are examples of **properties** of an object. To access the property of an object, write the property name
> after the object appended with a period `.`
>
> Properties are discussed in more detail in the [Classes](docs/topics/tour/kotlin-tour-classes/kotlin-tour-classes.md) chapter.
> At this point in the tour, you only need to know how to access them.
>
{type="note"}

To check that a key or value is in a map, use the [`in` operator](operator-overloading.md#in-operator):

```kotlin
fun main() {
//sampleStart
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("orange" in readOnlyJuiceMenu.keys)
    // true
    
    // Alternatively, you don't need to use the keys property
    println("orange" in readOnlyJuiceMenu)
    // true
    
    println(200 in readOnlyJuiceMenu.values)
    // false
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-map-in"}

For more information on what you can do with collections, see [Collections](collections-overview.md).

Now that you know about basic types and how to manage collections, it's time to explore the [control flow](docs/topics/tour/kotlin-tour-control-flow/kotlin-tour-control-flow.md)
that you can use in your programs.

## Practice

### Exercise 1 {initial-collapse-state="collapsed"}

You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there
are in total.

|---|---|
```kotlin
fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    // Write your code here
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-collections-exercise-1"}

|---|---|
```kotlin
fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.count() + redNumbers.count()
    println(totalCount)
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-collections-solution-1"}

### Exercise 2 {initial-collapse-state="collapsed"}

You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program
to check whether the requested protocol is supported or not (`isSupported` must be a Boolean value).

|---|---|
```kotlin
fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = // Write your code here 
    println("Support for $requested: $isSupported")
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-collections-exercise-2"}

<deflist collapsible="true" id="kotlin-tour-collections-exercise-2-hint">
    <def title="Hint">
        Make sure that you check the requested protocol in upper case. You can use the <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/uppercase.html"><code>.uppercase()</code></a>
function to help you with this.
    </def>
</deflist>

|---|---|
```kotlin
fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-collections-solution-2"}

### Exercise 3 {initial-collapse-state="collapsed"}

Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given 
number.

|---|---|
```kotlin
fun main() {
    val number2word = // Write your code here
    val n = 2
    println("$n is spelt as '${<Write your code here >}'")
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-collections-exercise-3"}

|---|---|
```kotlin
fun main() {
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-collections-solution-3"}

## Next step

[Control flow](kotlin-tour-control-flow.md)