* `fun`
  * == declare a function
* `main()`
  * function where program starts from
* `{Body of the function}`
* [`println()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html) and [`print()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/print.html)
  * := functions / print their arguments

## Variables

* allows
  * storing data
* types 
  * `val ReadOnlyVariableName`
    * read-only
      * == once you have given a value -> you can NOT change it
    * 👀recommendation 👀
  * `var MutableVariableName`
    * mutable
* `=` or assignment operator
* top level variables
  * := variables declared
    * outside `main()`
    * at the beginning of the program

## String templates or Template expressions

* allow
  * accessing data stored in variables or other objects — converting them to → `String`
* `"$VaribleOrOtherObject"` / `"${VaribleOrOtherObject.Property}"`
  * `{...}` 
    * evaluate a piece of code
  * must be wrapped by `""`
    * NOT valid `''`
* uses
  * print contents of variables
* String value
  * := "sequence of characters"
    * 👁️ in double quotes 👁️
* Check [String templates](strings.md)
