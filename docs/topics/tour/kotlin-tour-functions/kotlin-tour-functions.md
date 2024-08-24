[//]: # (title: Functions)

* 

    ```
    fun functionName(FunctionParameters): ReturnedType {
      …
      return ...
    }
    ```

  * if function does NOT return anything → `ReturnedType` & `return ...` can be omitted
  * `functionName`
    * [coding conventions](coding-conventions.md#function-names)
      * start with a lowercase letter
      * camel case / NO `_`

## Named arguments

* := `FunctionParameters` / have a name
  * optional
  * allows
    * easier to read the code
    * pass the parameters | ANY order

## Default parameter values

* := `FunctionParameters` / have a default value
  * → if you invoke the function -> that parameter can be omitted
  * 👁️if you skip to pass it | invoke the function -> rest of `FunctionParameters` MUST be named 👁️

## Functions without return

* -> returned type is `Unit`
  * 1! value of `Unit` type -- `Unit` --
* Unnecessary to declare it 
  * Reason: 🧠 default one 🧠

## Single-expression functions

* requirements
  * body can be described in 1! line
* `fun functionName(FunctionParameters) = BodyIn1!Line`
  * `{}` is omitted
    * Reason: 🧠 they are inferred  🧠
  * `returnType` can be omitted
    * Reason: 🧠 they are inferred  🧠
    * recommended to add to make it more clear the code
  * `=` is required
    * Reason: 🧠 type is inferred  🧠

## Early returns in functions

* `return` 
  * allows
    * stopping the function's code / being processed -- further than a -- certain point

## Lambda expressions

* allows
  * writing more concise code
* 

    ```
    {FunctionParameterNames: FunctionParameterTypes -> Body} // Declare a Lambda Expression
    // {FunctionParameterNames -> Body} // NOT valid to skip specifying FunctionParameterTypes Expression
    {Body} // Declare a Lambda Expression / NO FunctionParameter
    {FunctionParameterNames: FunctionParameterTypes -> Body}(ArgumentsPassed) // Invoke a Lambda Expression
    ```
* uses
  * [Pass a lambda expression as an another function's parameter](#pass-to-another-function)
  * [Return a lambda expression from a function](#return-from-a-function)
  * [Invoke a lambda expression on its own](#invoke-separately)

### Pass to another function

* if a lambda expression is the ONLY function parameter -> you can drop the function parentheses `()`
* _Example of functions / lambda expressions as function parameters:_
  * [`.filter()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html) 
  * [`.map()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html)

### Function types

* := function / ALL (arguments & returns) are typed
  * required by compiler sometimes
* 

    ```
    (TypeOfTheArguments) → TypeToReturn = {Arguments -> Body}
    //(TypeOfTheArguments) = {Arguments -> Body} // NOT valid to skip specifying TypeToReturn
    () → TypeToReturn = {Body}  // if there are NOT arguments 
    ```

### Return from a function

* TODO:
Lambda expressions can be returned from a function. So that the compiler understands what type the lambda
expression returned is, you must declare a function type.

In the following example, the `toSeconds()` function has function type `(Int) -> Int` because it always returns a lambda
expression that takes a parameter of type `Int` and returns an `Int` value.

This example uses a `when` expression to determine which lambda expression is returned when `toSeconds()` is called:

```kotlin
fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour" -> { value -> value * 60 * 60 }
    "minute" -> { value -> value * 60 }
    "second" -> { value -> value }
    else -> { value -> value }
}

fun main() {
    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")
    // Total time is 1680 secs
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-return-from-function"}

### Invoke separately

Lambda expressions can be invoked on their own by adding parentheses `()` after the curly braces `{}` and including
any parameters within the parentheses:

```kotlin
fun main() {
    //sampleStart
    println({ text: String -> text.uppercase() }("hello"))
    // HELLO
    //sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-standalone"}

### Trailing lambdas

As you have already seen, if a lambda expression is the only function parameter, you can drop the function parentheses `()`.
If a lambda expression is passed as the last parameter of a function, then the expression can be written outside the
function parentheses `()`. In both cases, this syntax is called a **trailing lambda**.

For example, the [`.fold()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/fold.html) function accepts an 
initial value and an operation:

```kotlin
fun main() {
    //sampleStart
    // The initial value is zero. 
    // The operation sums the initial value with every item in the list cumulatively.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6

    // Alternatively, in the form of a trailing lambda
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })  // 6
    //sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-trailing-lambda"}
