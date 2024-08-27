# Goal
* instances of a Kotlin class -- can be seamlessly -- created and operated | ".java"
* TODO:
* static fields

## Prerequisites
* [Install the compiler locally](https://kotlinlang.org/docs/command-line.html#install-the-compiler)
* Define an environment variable to the kotlin root path installation(`HOMEBREW_KOTLIN_ROOT`)

## How to create & run an application?
* The application will be just 1! `.kt` file
* `kotlinc Person.kt StaticFields.kt -d .`
  * create the `Person.class` & `Key...class`
* `javac -cp .:$HOMEBREW_KOTLIN_ROOT/lib/kotlin-stdlib.jar JavaToKotlinInterOp.java`
  * create the `JavaToKotlinInterOp.class`
* `java -cp .:$HOMEBREW_KOTLIN_ROOT/lib/kotlin-stdlib.jar JavaToKotlinInterOp`
  * run the application