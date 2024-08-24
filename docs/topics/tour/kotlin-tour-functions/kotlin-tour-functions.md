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

* == lambda expression / function type -- is returned from a -- function
  * Reason to be a function type: 🧠 compiler understands type of lambda expression is returned 🧠

### Invoke separately

* == declare + invoke it -- adding parentheses `()` after the curly braces `{}` -- | ALL at the same time

### Trailing lambdas

* := function / 
  * 1! function parameter is the lambda expression OR
    * -> you can drop the function parentheses `()`
  * lambda expression is the last parameter of a function 
    * -> lambda expression can be written outside the function parenthesis `()`
