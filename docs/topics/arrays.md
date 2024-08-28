[//]: # (title: Arrays)

* := data structure / holds a fixed number of values / SAME type or its subtypes 
  * fixed size -> ⚠️  ONLY way to add or remove elements -- is via -- create a NEW array ⚠️ 
  * 👁️object-type array 👁️
    * most common type of array | Kotlin
    * -- represented by the -- [`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/) class
    * if primitives | object-type array -> bad performance impact
      * Reason: 🧠 because your primitives are [boxed | objects](https://docs.oracle.com/javase/specs/jls/se22/html/jls-5.html#jls-5.1.7) 🧠
      * alternative : [primitive-type arrays](#primitive-type-arrays)
        * Reason: 🧠 avoid boxing overhead  🧠

## When to use arrays

* specialized low-level requirements / you need to meet
  * _Example1:_ performance requirements / -- beyond -- regular applications
  * _Example2:_ build custom data structures
* recommendations
  * ⚠️if you do NOT have previous requirements -> use [collections](collections-overview.md) ⚠️ 
* vs Collections
  * Collections can be read-only -> 
    * MORE control
    * allows writing robust code / clear intent
  * Collections are easier to add or remove elements
    * arrays are fixed | size
  * `==`
    * 👁️compare references 👁️
    * | collections -- allows checking if -- are structurally equal
    * NOT valid | arrays
      * -> special function needed -- Check [Compare arrays](#compare-arrays) --

## Create arrays

* ways
  * functions
    * [`arrayOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/array-of.html)
    * [`arrayOfNulls()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/array-of-nulls.html#kotlin$arrayOfNulls(kotlin.Int))
    * [`emptyArray()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/empty-array.html)
  * `Array` constructor
    * `Array<T>(size: kotlin.Int, lambdaExpressionWithTReturned)` == `Array<T>(size: kotlin.Int) { lambdaExpressionWithTReturned }`
      * `lambdaExpressionWithTReturned` runs / array's item & value is the index | array (from 0)
      * Reason: 🧠 trailing lambda expression 🧠 
* ways to specify the type of array
  * | left-hand of the assigment
  * | right-hand of the assigment

### Nested arrays

* == multidimensional arrays / 
  * 👁️parent array type OR size can be != children array type OR size 👁️

## Access and modify elements

* ALWAYS mutable (it's elements) 
  * access & modify elements | array -- via -- [indexed access operator](operator-overloading.md#indexed-access-operator)`[]`
* _invariant_
  * == Array<Subtype> != subtype of Array<Supertype>
    * alternatives
      * `Array<out Any>` -- Check [Type Projections](generics.md#type-projections) --  
  * allows
    * preventing possible runtime failure

## Work with arrays

* TODO:
In Kotlin, you can work with arrays by using them to pass a variable number of arguments to a function or perform operations
on the arrays themselves. For example, comparing arrays, transforming their contents or converting them to collections.

### Pass variable number of arguments to a function

In Kotlin, you can pass a variable number of arguments to a function via the [`vararg`](functions.md#variable-number-of-arguments-varargs)
parameter. This is useful when you don't know the number of arguments in advance, like when formatting a message or
creating an SQL query.

To pass an array containing a variable number of arguments to a function, use the _spread_ operator
(`*`). The spread operator passes each element of the array as individual arguments to your chosen function:

```kotlin
fun main() {
    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray)
    // abcd
}

fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-vararg-array-kotlin"}

For more information, see [Variable number of arguments (varargs)](functions.md#variable-number-of-arguments-varargs).

### Compare arrays

To compare whether two arrays have the same elements in the same order, use the [`.contentEquals()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/content-equals.html)
and [`.contentDeepEquals()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/content-deep-equals.html) 
functions:

```kotlin
fun main() {
//sampleStart
    val simpleArray = arrayOf(1, 2, 3)
    val anotherArray = arrayOf(1, 2, 3)

    // Compares contents of arrays
    println(simpleArray.contentEquals(anotherArray))
    // true

    // Using infix notation, compares contents of arrays after an element 
    // is changed
    simpleArray[0] = 10
    println(simpleArray contentEquals anotherArray)
    // false
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-compare-array-kotlin"}

> Don't use equality (`==`) and inequality (`!=`) [operators](equality.md#structural-equality) to compare the contents 
> of arrays. These operators check whether the assigned variables point to the same object.
> 
> To learn more about why arrays in Kotlin behave this way, see our [blog post](https://blog.jetbrains.com/kotlin/2015/09/feedback-request-limitations-on-data-classes/#Appendix.Comparingarrays).
> 
{type="warning"}

### Transform arrays

Kotlin has many useful functions to transform arrays. This document highlights a few but this isn't an 
exhaustive list. For the full list of functions, see our [API reference](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/).

#### Sum

To return the sum of all elements in an array, use the [`.sum()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sum.html)
function:

```Kotlin
fun main() {
//sampleStart
    val sumArray = arrayOf(1, 2, 3)

    // Sums array elements
    println(sumArray.sum())
    // 6
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-sum-array-kotlin"}

> The `.sum()` function can only be used with arrays of [numeric data types](numbers.md), such as `Int`.
>
{type="note"}

#### Shuffle

To randomly shuffle the elements in an array, use the [`.shuffle()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffle.html)
function:

```Kotlin
fun main() {
//sampleStart
    val simpleArray = arrayOf(1, 2, 3)

    // Shuffles elements [3, 2, 1]
    simpleArray.shuffle()
    println(simpleArray.joinToString())

    // Shuffles elements again [2, 3, 1]
    simpleArray.shuffle()
    println(simpleArray.joinToString())
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-shuffle-array-kotlin"}

### Convert arrays to collections

If you work with different APIs where some use arrays and some use collections, then you can convert your arrays to [collections](collections-overview.md)
and vice versa.

#### Convert to List or Set

To convert an array to a `List` or `Set`, use the [`.toList()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
and [`.toSet()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-set.html) functions.

```kotlin
fun main() {
//sampleStart
    val simpleArray = arrayOf("a", "b", "c", "c")

    // Converts to a Set
    println(simpleArray.toSet())
    // [a, b, c]

    // Converts to a List
    println(simpleArray.toList())
    // [a, b, c, c]
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-convert-list-set-kotlin"}

#### Convert to Map

To convert an array to a `Map`, use the [`.toMap()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-map.html)
function.

Only an array of [`Pair<K,V>`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/) can be converted to a `Map`.
The first value of a `Pair` instance becomes a key, and the second becomes a value. This example uses the [infix notation](functions.md#infix-notation)
to call the [`to`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html) function to create tuples of `Pair`:

```kotlin
fun main() {
//sampleStart
    val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)

    // Converts to a Map
    // The keys are fruits and the values are their number of calories
    // Note how keys must be unique, so the latest value of "apple"
    // overwrites the first
    println(pairArray.toMap())
    // {apple=140, banana=150, cherry=90}

//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-convert-map-kotlin"}

## Primitive-type arrays

If you use the `Array` class with primitive values, these values are boxed into objects. 
As an alternative, you can use primitive-type arrays, which allow you to store primitives in an array without the
side effect of boxing overhead:

| Primitive-type array | Equivalent in Java |
|---|----------------|
| [`BooleanArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean-array/) | `boolean[]`|
| [`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/) | `byte[]`|
| [`CharArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-array/) | `char[]`|
| [`DoubleArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double-array/) | `double[]`|
| [`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/) | `float[]`|
| [`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/) | `int[]`|
| [`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/) | `long[]`|
| [`ShortArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short-array/) | `short[]`|

These classes have no inheritance relation to the `Array` class, but they have the same set of functions and properties.

This example creates an instance of  the `IntArray` class:

```kotlin
fun main() {
//sampleStart
    // Creates an array of Int of size 5 with the values initialized to zero
    val exampleArray = IntArray(5)
    println(exampleArray.joinToString())
    // 0, 0, 0, 0, 0
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="arrays-primitive-type-array-kotlin"}

> To convert primitive-type arrays to object-type arrays, use the [`.toTypedArray()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-typed-array.html)
> function.
> 
> To convert object-type arrays to primitive-type arrays, use [`.toBooleanArray()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-boolean-array.html),
> [`.toByteArray()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-byte-array.html), [`.toCharArray()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-char-array.html),
> and so on.
> 
{type="note"}

## What's next?

* Check
  * [Collections overview](collections-overview.md)
  * other [basic types](basic-types.md)
  * If you are a Java developer -> read our Java -- to -- Kotlin migration guide for [Collections](java-to-kotlin-collections-guide.md)
