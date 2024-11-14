# Goal
* instances of a Kotlin class -- can be seamlessly -- created and operated | ".java"
* TODO:
* package-level functions
* TODO:
* static fields
* static methods
* TODO:
* overloads generation
* TODO:

## Prerequisites
* [Install the compiler locally](https://kotlinlang.org/docs/command-line.html#install-the-compiler)
* Define an environment variable to the kotlin root path installation(`HOMEBREW_KOTLIN_ROOT`)
* [Download CFR Java decompiler](https://github.com/leibnitz27/cfr)
  * allows
    * ".class" -- is decompiled to -- ".java"
  * place | this path, to use it

## How to create & run an application?
* The application will be just 1! `.kt` file
* `kotlinc Person.kt StaticFields.kt packageLevelFunctions.kt StaticMethods.kt -d .`
  * create the `Person.class` & `Key...class`
  * check 'org/example' folder has been created / contains ".class"
* `javac -cp .:$HOMEBREW_KOTLIN_ROOT/lib/kotlin-stdlib.jar JavaToKotlinInterOp.java`
  * create the `JavaToKotlinInterOp.class`
* `java -cp .:$HOMEBREW_KOTLIN_ROOT/lib/kotlin-stdlib.jar JavaToKotlinInterOp`
  * run the application

## How to generate from ".kt" -> ".java"?
* `kotlinc Circle.kt -d .`
  * generate "Circle.class"
* `java -jar cfr-0.152.jar Circle.class`
  * decompile as output, the "Circle.java"