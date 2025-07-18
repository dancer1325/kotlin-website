[//]: # (title: Numbers)

* Check 'tour/kotlin-tour-basic-types/kotlin-tour-basic-types.md'

## Integer types
  
* types

    | Type	 |Size (bits)| Min value| Max value|
    |--------|-----------|----------|--------- |
    | `Byte`	 | 8         |-128      |127       |
    | `Short`	 | 16        |-32768    |32767     |
    | `Int`	 | 32        |-2,147,483,648 (-2<sup>31</sup>)| 2,147,483,647 (2<sup>31</sup> - 1)|
    | `Long`	 | 64        |-9,223,372,036,854,775,808 (-2<sup>63</sup>)|9,223,372,036,854,775,807 (2<sup>63</sup> - 1)|

  * size -- limits -- range value
  * 👁️if you do NOT specify the type -> type inference / smallest range -- to represent the -- value 👁️
    * start from `Int`
    * if it does NOT exceed the range of `Int` -> type is `Int`
    * if it exceeds range of `Int` -> type is `Long`
  * 👁️if you specify the type -> compiler checks that value does NOT exceed the range 👁️
  * append the suffix `L` -- to specify the -- `Long`

* Check [unsigned integer types](unsigned-integer-types.md)

## Floating-point types

* `integer.decimal`
* types

    | Type	 |Size (bits)|Significant bits|Exponent bits|Decimal digits|
    |--------|-----------|--------------- |-------------|--------------|
    | `Float`	 | 32        |24              |8            |6-7            |
    | `Double` | 64        |53              |11           |15-16          |

  * adhere to the [IEEE 754 standard](https://en.wikipedia.org/wiki/IEEE_754)
  * uses
    * real numbers
  * characteristics
    * size
    * allowed a fractional part
  * suffix `f` or `F` -> `Float` type
    * if you specify > 6-7 decimal digits -> it's rounded
  * type inferred by default, it's `Double`
  * ⚠️NO implicit widening conversions for numbers ⚠️

## Literal constants for numbers

* literal constants for integral values == direct representations | code
  * Decimals
    * standard base-10 numbers
  * Hexadecimals -- `prefixDigitsLetters` -- 
    * prefix -- `0x` or `0X` --
    * Digits -- `[0,9]` --
    * Letters -- `[a,f]` or `[A,F]` --
  * Binaries

    > Octal literals are NOT supported
* 👁️ `_` / split literal constants parts 👁️
  * -> more readable

## Numbers representation | JVM

* numbers | JVM platform
  * Java primitive types
    * _Example:_ `int`, `double`
  * if you use nullable number reference or use generics -> [boxed](https://docs.oracle.com/javase/specs/jls/se22/html/jls-5.html#jls-5.1.7) | Java classes
    * _Example:_ `Int?` -> `Integer`
    * different representation / boxed, EXCEPT to `Integer` in [-128, 127]

## Explicit number conversions

* 👁️smaller (about size) types != subtypes of bigger types 👁️
  * Reason: 🧠have different representations 🧠
  * -> ⚠️ -- NOT implicitly converted to -- bigger types ⚠️
* exist ANY number conversions between each other
  * `toByte(): Byte`
  * `toShort(): Short`
  * `toInt(): Int`
  * `toLong(): Long`
  * `toFloat(): Float`
  * `toDouble(): Double`
* use cases / implicit conversion is needed
  * smaller types -> bigger types
* use cases / type -- is inferred from the -- context (==implicit conversion)
  * arithmetical operations

## Operations on numbers
* TODO:
Kotlin supports the standard set of arithmetical operations over numbers: `+`, `-`, `*`, `/`, `%`. They are declared
as members of appropriate classes:

```kotlin
fun main() {
//sampleStart
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

You can also override these operators for custom classes. See [Operator overloading](operator-overloading.md) for details.

### Division of integers

Division between integers numbers always returns an integer number. Any fractional part is discarded.

```kotlin
fun main() {
//sampleStart
    val x = 5 / 2
    //println(x == 2.5) // ERROR: Operator '==' cannot be applied to 'Int' and 'Double'
    println(x == 2)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

This is true for a division between any two integer types:

```kotlin
fun main() {
//sampleStart
    val x = 5L / 2
    println(x == 2L)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

To return a floating-point type, explicitly convert one of the arguments to a floating-point type:

```kotlin
fun main() {
//sampleStart
    val x = 5 / 2.toDouble()
    println(x == 2.5)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

### Bitwise operations

Kotlin provides a set of _bitwise operations_ on integer numbers. They operate on the binary level directly with
bits of the numbers' representation.
Bitwise operations are represented by functions that can be called in infix form. They can be applied only to `Int` and `Long`:

```kotlin
val x = (1 shl 2) and 0x000FF000
```

Here is the complete list of bitwise operations:

* `shl(bits)` – signed shift left
* `shr(bits)` – signed shift right
* `ushr(bits)` – unsigned shift right
* `and(bits)` – bitwise **AND**
* `or(bits)` – bitwise **OR**
* `xor(bits)` – bitwise **XOR**
* `inv()` – bitwise inversion

### Floating-point numbers comparison

The operations on floating-point numbers discussed in this section are:

* Equality checks: `a == b` and `a != b`
* Comparison operators: `a < b`, `a > b`, `a <= b`, `a >= b`
* Range instantiation and range checks: `a..b`, `x in a..b`, `x !in a..b`

When the operands `a` and `b` are statically known to be `Float` or `Double` or their nullable counterparts (the type is
declared or inferred or is a result of a [smart cast](typecasts.md#smart-casts)), the operations on the
numbers and the range that they form follow the [IEEE 754 Standard for Floating-Point Arithmetic](https://en.wikipedia.org/wiki/IEEE_754).

However, to support generic use cases and provide total ordering, the behavior is different for operands that are **not**
statically typed as floating-point numbers. For example, `Any`, `Comparable<...>`, or `Collection<T>` types. In this case, the 
operations use the `equals` and `compareTo` implementations for `Float` and `Double`. As a result:

* `NaN` is considered equal to itself
* `NaN` is considered greater than any other element including `POSITIVE_INFINITY`
* `-0.0` is considered less than `0.0`

Here is an example that shows the difference in behavior between operands statically typed as floating-point numbers 
(`Double.NaN`) and operands **not** statically typed as floating-point numbers (`listOf(T)`).

```kotlin
fun main() {
    //sampleStart
    // Operand statically typed as floating-point number
    println(Double.NaN == Double.NaN)                 // false
    // Operand NOT statically typed as floating-point number
    // So NaN is equal to itself
    println(listOf(Double.NaN) == listOf(Double.NaN)) // true

    // Operand statically typed as floating-point number
    println(0.0 == -0.0)                              // true
    // Operand NOT statically typed as floating-point number
    // So -0.0 is less than 0.0
    println(listOf(0.0) == listOf(-0.0))              // false

    println(listOf(Double.NaN, Double.POSITIVE_INFINITY, 0.0, -0.0).sorted())
    // [-0.0, 0.0, Infinity, NaN]
    //sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-numbers-floating-comp"}