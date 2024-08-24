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

* TODO:
To stop the code in your function from being processed further than a certain point, use the `return` keyword. This example
uses `if` to return from a function early if the conditional expression is found to be true:

```kotlin
// A list of registered usernames
val registeredUsernames = mutableListOf("john_doe", "jane_smith")

// A list of registered emails
val registeredEmails = mutableListOf("john@example.com", "jane@example.com")

fun registerUser(username: String, email: String): String {
    // Early return if the username is already taken
    if (username in registeredUsernames) {
        return "Username already taken. Please choose a different username."
    }

    // Early return if the email is already registered
    if (email in registeredEmails) {
        return "Email already registered. Please use a different email."
    }

    // Proceed with the registration if the username and email are not taken
    registeredUsernames.add(username)
    registeredEmails.add(email)

    return "User registered successfully: $username"
}

fun main() {
    println(registerUser("john_doe", "newjohn@example.com"))
    // Username already taken. Please choose a different username.
    println(registerUser("new_user", "newuser@example.com"))
    // User registered successfully: new_user
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-function-early-return"}

## Functions practice

### Exercise 1 {initial-collapse-state="collapsed" id="functions-exercise-1"}

Write a function called `circleArea` that takes the radius of a circle in integer format as a parameter and outputs the
area of that circle.

> In this exercise, you import a package so that you can access the value of pi via `PI`. For more information about
> importing packages, see [Packages and imports](packages.md).
>
{type = "tip"}

|---|---|
```kotlin
import kotlin.math.PI

fun circleArea() {
    // Write your code here
}
fun main() {
    println(circleArea(2))
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-functions-exercise-1"}

|---|---|
```kotlin
import kotlin.math.PI

fun circleArea(radius: Int): Double {
    return PI * radius * radius
}

fun main() {
    println(circleArea(2)) // 12.566370614359172
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-functions-solution-1"}

### Exercise 2 {initial-collapse-state="collapsed" id="functions-exercise-2"}

Rewrite the `circleArea` function from the previous exercise as a single-expression function.

|---|---|
```kotlin
import kotlin.math.PI

// Write your code here

fun main() {
    println(circleArea(2))
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-functions-exercise-2"}

|---|---|
```kotlin
import kotlin.math.PI

fun circleArea(radius: Int): Double = PI * radius * radius

fun main() {
    println(circleArea(2)) // 12.566370614359172
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-functions-solution-2"}

### Exercise 3 {initial-collapse-state="collapsed" id="functions-exercise-3"}

You have a function that translates a time interval given in hours, minutes, and seconds into seconds. In most cases,
you need to pass only one or two function parameters while the rest are equal to 0. Improve the function and the code that
calls it by using default parameter values and named arguments so that the code is easier to read.

|---|---|
```kotlin
fun intervalInSeconds(hours: Int, minutes: Int, seconds: Int) =
    ((hours * 60) + minutes) * 60 + seconds

fun main() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(0, 1, 25))
    println(intervalInSeconds(2, 0, 0))
    println(intervalInSeconds(0, 10, 0))
    println(intervalInSeconds(1, 0, 1))
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-functions-exercise-3"}

|---|---|
```kotlin
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds

fun main() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(hours = 1, seconds = 1))
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-functions-solution-3"}

## Lambda expressions

Kotlin allows you to write even more concise code for functions by using lambda expressions.

For example, the following `uppercaseString()` function:

```kotlin
fun uppercaseString(text: String): String {
    return text.uppercase()
}
fun main() {
    println(uppercaseString("hello"))
    // HELLO
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-function-before"}

Can also be written as a lambda expression:

```kotlin
fun main() {
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))
    // HELLO
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-variable"}

Lambda expressions can be hard to understand at first glance so let's break it down. Lambda expressions are written 
within curly braces `{}`.

Within the lambda expression, you write:

* The parameters followed by an `->`.
* The function body after the `->`.

In the previous example:

* `text` is a function parameter.
* `text` has type `String`.
* The function returns the result of the [`.uppercase()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/uppercase.html)
function called on `text`.
* The entire lambda expression is assigned to the `upperCaseString` variable with the assignment operator `=`.
* The lambda expression is called by using the variable `upperCaseString` like a function and the string `"hello"` as a parameter.
* The `println()` function prints the result.

> If you declare a lambda without parameters, then there is no need to use `->`. For example:
> ```kotlin
> { println("Log message") }
> ```
>
{type="note"}

Lambda expressions can be used in a number of ways. You can:

* [Pass a lambda expression as a parameter to another function](#pass-to-another-function)
* [Return a lambda expression from a function](#return-from-a-function)
* [Invoke a lambda expression on its own](#invoke-separately)

### Pass to another function

A great example of when it is useful to pass a lambda expression to a function, is using the [`.filter()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html)
function on collections:

```kotlin
fun main() {
    //sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    
    
    val positives = numbers.filter ({ x -> x > 0 })
    
    val isNegative = { x: Int -> x < 0 }
    val negatives = numbers.filter(isNegative)
    
    println(positives)
    // [1, 3, 5]
    println(negatives)
    // [-2, -4, -6]
    //sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-filter"}

The `.filter()` function accepts a lambda expression as a predicate:

* `{ x -> x > 0 }` takes each element of the list and returns only those that are positive.
* `{ x -> x < 0 }` takes each element of the list and returns only those that are negative.

This example demonstrates two ways of passing a lambda expression to a function:

* For positive numbers, the example adds the lambda expression directly in the `.filter()` function.
* For negative numbers, the example assigns the lambda expression to the `isNegative` variable. Then
the `isNegative` variable is used as a function parameter in the `.filter()` function. In this case, you have to specify
the type of function parameters (`x`) in the lambda expression.

> If a lambda expression is the only function parameter, you can drop the function parentheses `()`:
> 
> ```kotlin
> val positives = numbers.filter { x -> x > 0 }
> ```
> 
> This is an example of a [trailing lambda](#trailing-lambdas), which is discussed in more detail at the end of this
> chapter.
>
{type = "note"}

Another good example, is using the [`.map()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html) 
function to transform items in a collection:

```kotlin
fun main() {
    //sampleStart
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val doubled = numbers.map { x -> x * 2 }
    
    val isTripled = { x: Int -> x * 3 }
    val tripled = numbers.map(isTripled)
    
    println(doubled)
    // [2, -4, 6, -8, 10, -12]
    println(tripled)
    // [3, -6, 9, -12, 15, -18]
    //sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-map"}

The `.map()` function accepts a lambda expression as a transform function:

* `{ x -> x * 2 }` takes each element of the list and returns that element multiplied by 2.
* `{ x -> x * 3 }` takes each element of the list and returns that element multiplied by 3.

### Function types

Before you can return a lambda expression from a function, you first need to understand **function
types**.

You have already learned about basic types but functions themselves also have a type. Kotlin's type inference 
can infer a function's type from the parameter type. But there may be times when you need to explicitly
specify the function type. The compiler needs the function type so that it knows what is and isn't 
allowed for that function.

The syntax for a function type has:

* Each parameter's type written within parentheses `()` and separated by commas `,`.
* The return type written after `->`.

For example: `(String) -> String` or `(Int, Int) -> Int`.

This is what a lambda expression looks like if a function type for `upperCaseString()` is defined:

```kotlin
val upperCaseString: (String) -> String = { text -> text.uppercase() }

fun main() {
    println(upperCaseString("hello"))
    // HELLO
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambda-function-type"}

If your lambda expression has no parameters then the parentheses `()` are left empty. For example: `() -> Unit`

> You must declare parameter and return types either in the lambda expression or as a function type. Otherwise, the
> compiler won't be able to know what type your lambda expression is.
> 
> For example, the following won't work:
> 
> `val upperCaseString = { str -> str.uppercase() }`
>
{type="note"}

### Return from a function

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

For more information on lambda expressions, see [Lambda expressions and anonymous functions](lambdas.md#lambda-expressions-and-anonymous-functions).

The next step in our tour is to learn about [classes](docs/topics/tour/kotlin-tour-classes/kotlin-tour-classes.md) in Kotlin.

## Lambda expressions practice

### Exercise 1 {initial-collapse-state="collapsed" id="lambdas-exercise-1"}

You have a list of actions supported by a web service, a common prefix for all requests, and an ID of a particular resource.
To request an action `title` over the resource with ID: 5, you need to create the following URL: `https://example.com/book-info/5/title`.
Use a lambda expression to create a list of URLs from the list of actions.

|---|---|
```kotlin
fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = // Write your code here
    println(urls)
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambdas-exercise-1"}

|---|---|
```kotlin
fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = actions.map { action -> "$prefix/$id/$action" }
    println(urls)
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-lambdas-solution-1"}

### Exercise 2 {initial-collapse-state="collapsed" id="lambdas-exercise-2"}

Write a function that takes an `Int` value and an action (a function with type `() -> Unit`) which then repeats the 
action the given number of times. Then use this function to print “Hello” 5 times.

|---|---|
```kotlin
fun repeatN(n: Int, action: () -> Unit) {
    // Write your code here
}

fun main() {
    // Write your code here
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-lambdas-exercise-2"}

|---|---|
```kotlin
fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) {
        action()
    }
}

fun main() {
    repeatN(5) {
        println("Hello")
    }
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-lambdas-solution-2"}

## Next step

[Classes](kotlin-tour-classes.md)
