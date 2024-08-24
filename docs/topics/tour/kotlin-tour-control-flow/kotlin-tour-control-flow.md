[//]: # (title: Control flow)

## Conditional expressions

* := boolean piece of code / make decisions

### If

* 

    ```
    if (conditionalExpresion) {
    …
    }
    // OR
    if(conditionalExpression) BodyOf1UniqueLine
    // OR
    if (conditionaExpression) this else that
    ```
    * if body1UniqueLine -> `{}` are optional
    * `condition ? then : else`
      * ❌ternary operator does NOT exist ❌
      * ⭐valid alternative ⭐
        * `if (conditionaExpression) this else that`

### When

* vs `if`
  * 👁️recommended to use `when` 👁️
    * Reasons: 🧠🧠
        * code is easier to read
        * add another branch is easier
        * less prune to errors
* uses
  * conditional expression / multiple branches
  * as
    * statement or  
      * NOTHING is returned 
    * expression
      * _Example:_ assign to a variable
* 

    ```
    when (conditionalExpressionNamedSubject) {
        branch1 -> logic1
        branch2 -> logic2
        ...
        else -> logicEnd
    } 
    // OR
    when {
        conditionalExpression1 -> logic1
        conditionalExpression1 -> logic2
        ...
        else -> logicEnd
    } 
    ```
  * branches are checked sequentially / if once is satisfied -> rest are skipped
  * 👁️recommended to use with `conditionalExpressionNamedSubject` 👁️
    * Reasons: 🧠 🧠
      * code easier to read & maintain
      * helps Kotlin / ALL possible cases are covered 
  * ⚠️if you do NOT use `conditionalExpressionNamedSubject` -> you should provide `else` branch ⚠️

## Ranges

* allowed types
  * `Int`
  * `Char`
* ways to create them
  * `initialValue..finalValue`
    * `initialValue` & `finalValue` are included
    * step = +1
  * `initialValue..<finalValue` & `initialValue until valueWithoutBeingIncluded`
    * `finalValue` is NOT included
  * `initialValue downTo finalValue`
    * range declared in reverse order == `finalValue` -> `initialValue`   
    * step = -1
  * `initialValue..finalValue step StepsToGive`

## Loops

* TODO:
The two most common loop structures in programming are `for` and `while`. Use `for` to iterate over a range of 
values and perform an action. Use `while` to continue an action until a particular condition is satisfied.

### For

Using your new knowledge of ranges, you can create a `for` loop that iterates over numbers 1 to 5 and prints the number 
each time.

Place the iterator and range within parentheses `()` with keyword `in`. Add the action you want to complete within curly
braces `{}`:

```kotlin
fun main() {
//sampleStart
    for (number in 1..5) { 
        // number is the iterator and 1..5 is the range
        print(number)
    }
    // 12345
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-for-loop"}

Collections can also be iterated over by loops:

```kotlin
fun main() { 
//sampleStart
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    // Yummy, it's a carrot cake!
    // Yummy, it's a cheese cake!
    // Yummy, it's a chocolate cake!
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-for-collection-loop"}

### While

`while` can be used in two ways:

  * To execute a code block while a conditional expression is true. (`while`)
  * To execute the code block first and then check the conditional expression. (`do-while`)

In the first use case (`while`):

* Declare the conditional expression for your while loop to continue within parentheses `()`. 
* Add the action you want to complete within curly braces `{}`.

> The following examples use the [increment operator](operator-overloading.md#increments-and-decrements) `++` to
> increment the value of the `cakesEaten` variable.
>
{type="tip"}

```kotlin
fun main() {
//sampleStart
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
    // Eat a cake
    // Eat a cake
    // Eat a cake
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-while-loop"}

In the second use case (`do-while`):

* Declare the conditional expression for your while loop to continue within parentheses `()`.
* Define the action you want to complete within curly braces `{}` with the keyword `do`.

```kotlin
fun main() {
//sampleStart
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    // Eat a cake
    // Eat a cake
    // Eat a cake
    // Bake a cake
    // Bake a cake
    // Bake a cake
//sampleEnd
}
```
{kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-while-do-loop"}

For more information and examples of conditional expressions and loops, see [Conditions and loops](control-flow.md).

Now that you know the fundamentals of Kotlin control flow, it's time to learn how to write your own [functions](docs/topics/tour/kotlin-tour-functions/kotlin-tour-functions.md).

## Loops practice

### Exercise 1 {initial-collapse-state="collapsed" id="loops-exercise-1"}

You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:

* Use a `while` loop.
* Use a `do-while` loop.

|---|---|
```kotlin
fun main() {
    var pizzaSlices = 0
    // Start refactoring here
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
    // End refactoring here
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-control-flow-loops-exercise-1"}

|---|---|
```kotlin
fun main() {
    var pizzaSlices = 0
    while ( pizzaSlices < 7 ) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution 1" id="kotlin-tour-control-flow-loops-exercise-1-solution-1"}

|---|---|
```kotlin
fun main() {
    var pizzaSlices = 0
    pizzaSlices++
    do {
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    } while ( pizzaSlices < 8 )
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

```
{initial-collapse-state="collapsed" collapsed-title="Example solution 2" id="kotlin-tour-control-flow-loops-exercise-1-solution-2"}

### Exercise 2 {initial-collapse-state="collapsed" id="loops-exercise-2"}

Write a program that simulates the [Fizz buzz](https://en.wikipedia.org/wiki/Fizz_buzz) game. Your task is to print 
numbers from 1 to 100 incrementally, replacing any number divisible by three with the word "fizz", and any number 
divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".

<deflist collapsible="true">
    <def title="Hint 1">
        Use a <code>for</code> loop to count numbers and a <code>when</code> expression to decide what to print at each
        step. 
    </def>
</deflist>

<deflist collapsible="true">
    <def title="Hint 2">
        Use the modulo operator (<code>%</code>) to return the remainder of a number being divided. Use the <a href="operator-overloading.md#equality-and-inequality-operators">equality operator</a> 
        (<code>==</code>) to check if the remainder equals zero.
    </def>
</deflist>

|---|---|
```kotlin
fun main() {
    // Write your code here
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-control-flow-loops-exercise-2"}

|---|---|
```kotlin
fun main() {
    for (number in 1..100) {
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> "$number"
            }
        )
    }
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-control-flow-loops-solution-2"}

### Exercise 3 {initial-collapse-state="collapsed" id="loops-exercise-3"}

You have a list of words. Use `for` and `if` to print only the words that start with the letter `l`.

<deflist collapsible="true">
    <def title="Hint">
        Use the <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/starts-with.html"> <code>.startsWith()</code>
        </a> function for <code>String</code> type. 
    </def>
</deflist>

|---|---|
```kotlin
fun main() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    // Write your code here
}
```
{validate="false" kotlin-runnable="true" kotlin-min-compiler-version="1.3" id="kotlin-tour-control-flow-loops-exercise-3"}

|---|---|
```kotlin
fun main() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (w in words) {
        if (w.startsWith("l"))
            println(w)
    }
}
```
{initial-collapse-state="collapsed" collapsed-title="Example solution" id="kotlin-tour-control-flow-loops-solution-3"}
