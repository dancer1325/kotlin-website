# Object expressions
* TODO:

# `object ObjectName {...}` -- Object declarations 
* ⚠️≠ expression ⚠️
  * → can not be used on the right-hand side of an assignment
* how is the initialization?
  * thread-safe -- TODO: How to check ? --
  * done on first access -- Check CounterObject --
* can have supertypes  -- Check ObjectDeclarationWithSuperTypes --
  * Note: 👁️object declaration can NOT be inherits directly from another object declaration 👁️
* TODO:
## Data objects
* TODO:


# Code Examples
* Mirror the examples added, to run it locally

## Prerequisites
* [Install the compiler locally](https://kotlinlang.org/docs/command-line.html#install-the-compiler)

## How to create & run an application?
* The application will be just 1! `.kt` file
* `kotlinc NameOfTheFile.kt -include-runtime -d outputPathOrName.jar`
  * create the application
* `java -jar outputPathOrName.jar`
  * run the application