[//]: # (title: Scope functions)

* Kotlin standard library
  * exist functions / 👀1! purpose == execute a block of code | object's context👀

* ⭐️scope functions⭐️
  * := function | object -- with a -- [lambda expression](lambdas.md) 
  * == 👀temporary scope👀
  * allows
    * accessing the object -- WITHOUT -- its name
      * == 
        * 👀avoid declaring variable👀
        * code / MORE concise & readable
          * 
  * ❌NOT add NEW technical capability❌
  * recommendations
    * ❌NOT overuse❌
    * avoid nesting scope functions
      * Reason:🧠get confused about the CURRENT context object & value of `this` or `it`🧠
  * built-in
    * [`let`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/let.html)
    * [`run`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html)
    * [`with`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/with.html)
    * [`apply`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/apply.html)
    * [`also`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/also.html)
  * steps / perform
    * 👀execute a block of code | object👀

## how to choose the scope function?

| Function                                                                      | Object reference | Return value   | Is extension function                                            |
|-------------------------------------------------------------------------------|------------------|----------------|------------------------------------------------------------------|
| [`let`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/let.html)         | `it`             | Lambda result  | Yes                                                              |
| [`run`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html)         | `this`           | Lambda result  | Yes                                                              |
| [`run`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html)         | -                | Lambda result  | ❌NO❌ <br/> Reason:🧠called WITHOUT the context object🧠          |
| [`with`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/with.html)       | `this`           | Lambda result  | ❌NO❌ <br/> Reason:🧠context object is taken -- as an -- argument |
| [`apply`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/apply.html)     | `this`           | Context object | Yes                                                              |
| [`also`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/also.html)       | `it`             | Context object | Yes                                                              |

* depends -- on --
  * your intent
  * your project

* short guide for choosing
  * `let`
    * execute a lambda | non-nullable objects
    * introduce an expression -- as a -- variable | local scope
  * `apply`
    * object configuration 
  * `run`
    * object configuration & computing the result
    * running statements / expression is required == non-extension
  * `also`
    * ADDITIONAL effects 
  * `with`
    * grouping function calls | object

## DIFFERENCES BETWEEN scope functions

* way / they refer -- to the -- context object
* return value

### Context object: `this` or `it`

* | scope function's lambda passed
  * 👀ways to refer the context object👀
    * by a short reference
      * ⚠️EXIST 1! / -- depends on -- [EACH scope function](#how-to-choose-the-scope-function)⚠️
      * ways
        * `this`
          * == lambda [receiver](lambdas.md#function-literals-with-receiver)
        * `it`
          * == lambda argument 
    * by its actual name

#### this

* [lambda receiver](lambdas.md#function-literals-with-receiver)
  * == object is available -- as -- it's | ordinary class functions 
* allow
  * referring -- to the -- context object 
  * | access receiver object's members,
    * 👀it can be omitted👀

* ALLOWED |
  * `run`
  * `with`
  * `apply`

#### it

* [lambda argument](lambdas.md#lambda-expression-syntax)

* ALLOWED |
  * `let`
  * `also`

* use cases
  * object is used as function calls' argument
  * MULTIPLE variables | code block
* NOT recommended use cases
  * | call the object's functions or properties 
    * Reason:🧠NOT have the object available implicitly (_Example:_ like `this`)🧠

### Return value

* `apply` & `also`
  * return the context object
* `let`, `run`, & `with`
  * return the lambda result

* choose -- based on -- what you want to do | your code

#### Context object 

* |
  * `apply`
  * `also`
* allows
  * 👀using | call chains👀
    * == side steps

* uses
  * | call chains
  * functions' return statements

#### Lambda result

* TODO:
`let`, `run`, and `with` return the lambda result. So you can use them when assigning the result to a variable, chaining
operations on the result, and so on.

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run { 
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

Additionally, you can ignore the return value and use a scope function to create a temporary scope for local variables. 

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        val firstItem = first()
        val lastItem = last()        
        println("First item: $firstItem, last item: $lastItem")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

## Functions

To help you choose the right scope function for your use case, we describe them in detail and provide
recommendations for use. Technically, scope functions are interchangeable in many cases, so the examples show 
conventions for using them. 

### let

- **The context object** is available as an argument (`it`).
- **The return value** is the lambda result.

[`let`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/let.html) can be used to invoke one or more functions on 
results of call chains. For example, the following code prints the results of two operations on a collection:

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)    
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

With `let`, you can rewrite the above example so that you're not assigning the result of the list
operations to a variable:

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let { 
        println(it)
        // and more function calls if needed
    } 
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

If the code block passed to `let` contains a single function with `it` as an argument, you can use the method reference 
(`::`) instead of the lambda argument:

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

`let` is often used to execute a code block containing non-null values. To perform actions on a non-null object, use
the [safe call operator `?.`](null-safety.md#safe-calls) on it and call `let` with the actions in its lambda.

```kotlin
fun processNonNullString(str: String) {}

fun main() {
//sampleStart
    val str: String? = "Hello"   
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let { 
        println("let() called on $it")        
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

You can also use `let` to introduce local variables with a limited scope to make your code easier to read.
To define a new variable for the context object, provide its name as the lambda argument so that it can be used instead of
the default `it`.

```kotlin
fun main() {
//sampleStart
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.uppercase()
    println("First item after modifications: '$modifiedFirstItem'")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

### with

- **The context object** is available as a receiver (`this`).
- **The return value** is the lambda result.

As [`with`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/with.html) is not an extension function: the context
object is passed as an argument, but inside the lambda, it's available as a receiver (`this`).

We recommend using `with` for calling functions on the context object when you don't need to use the returned result.
In code, `with` can be read as "_with this object, do the following._"

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

You can also use `with` to introduce a helper object whose properties or functions are used for calculating a value.

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
        " the last element is ${last()}"
    }
    println(firstAndLast)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

### run

- **The context object** is available as a receiver (`this`). 
- **The return value** is the lambda result.

[`run`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html) does the same as `with` but it is implemented as 
an extension function. So like `let`, you can call it on the context object using dot notation.

`run` is useful when your lambda both initializes objects and computes the return value.

```kotlin
class MultiportService(var url: String, var port: Int) {
    fun prepareRequest(): String = "Default request"
    fun query(request: String): String = "Result for query '$request'"
}

fun main() {
//sampleStart
    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }
    
    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }
//sampleEnd
    println(result)
    println(letResult)
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

You can also invoke `run` as a non-extension function. The non-extension variant of `run` has no context object, but it
still returns the lambda result. Non-extension `run` lets you execute a block of several statements where an expression 
is required. In code, non-extension `run` can be read as "_run the code block and compute the result._"

```kotlin
fun main() {
//sampleStart
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"
        
        Regex("[$sign]?[$digits$hexDigits]+")
    }
    
    for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
        println(match.value)
    }
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

### apply

- **The context object** is available as a receiver (`this`). 
- **The return value** is the object itself.

As [`apply`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/apply.html) returns the context object itself, we 
recommend that you use it for code blocks that don't return a value and that mainly operate on the members of the 
receiver object. The most common use case for `apply` is for object configuration. Such calls can be read as "_apply 
the following assignments to the object._"

```kotlin
data class Person(var name: String, var age: Int = 0, var city: String = "")

fun main() {
//sampleStart
    val adam = Person("Adam").apply {
        age = 32
        city = "London"        
    }
    println(adam)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

Another use case for `apply` is to include `apply` in multiple call chains for more complex processing.

### also

- **The context object** is available as an argument (`it`). 
- **The return value** is the object itself.

[`also`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/also.html) is useful for performing some actions that take 
the context object as an argument. Use `also` for actions that need a reference to the object rather than its properties
and functions, or when you don't want to shadow the `this` reference from an outer scope.

When you see `also` in code, you can read it as "_and also do the following with the object._"

```kotlin
fun main() {
//sampleStart
    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

## takeIf and takeUnless

In addition to scope functions, the standard library contains the functions [`takeIf`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/take-if.html) 
and [`takeUnless`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/take-unless.html). These functions let you embed
checks of an object's state in call chains. 

When called on an object along with a predicate, `takeIf` returns this object if it satisfies the given predicate.
Otherwise, it returns `null`. So, `takeIf` is a filtering function for a single object.

`takeUnless` has the opposite logic of `takeIf`. When called on an object along with a predicate, `takeUnless` returns 
`null` if it satisfies the given predicate. Otherwise, it returns the object.

When using `takeIf` or `takeUnless`, the object is available as a lambda argument (`it`).

```kotlin
import kotlin.random.*

fun main() {
//sampleStart
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

> When chaining other functions after `takeIf` and `takeUnless`, don't forget to perform a null check or use a safe call
> (`?.`) because their return value is nullable.
>
{type="tip"}

```kotlin
fun main() {
//sampleStart
    val str = "Hello"
    val caps = str.takeIf { it.isNotEmpty() }?.uppercase()
   //val caps = str.takeIf { it.isNotEmpty() }.uppercase() //compilation error
    println(caps)
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

`takeIf` and `takeUnless` are especially useful in combination with scope functions. For example, you can chain 
`takeIf` and `takeUnless` with `let` to run a code block on objects that match the given predicate. To do this, 
call `takeIf` on the object and then call `let` with a safe call (`?`). For objects that don't match the predicate, 
`takeIf` returns `null` and `let` isn't invoked.

```kotlin
fun main() {
//sampleStart
    fun displaySubstringPosition(input: String, sub: String) {
        input.indexOf(sub).takeIf { it >= 0 }?.let {
            println("The substring $sub is found in $input.")
            println("Its start position is $it.")
        }
    }

    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

For comparison, below is an example of how the same function can be written without using `takeIf` or scope functions:

```kotlin
fun main() {
//sampleStart
    fun displaySubstringPosition(input: String, sub: String) {
        val index = input.indexOf(sub)
        if (index >= 0) {
            println("The substring $sub is found in $input.")
            println("Its start position is $index.")
        }
    }

    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3"}

