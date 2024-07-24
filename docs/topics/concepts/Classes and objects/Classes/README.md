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

# Class declaration
* `class NameOfTheClass classHeader { classBody }`
  * Check `GenericClass`, `GenericClassWithoutHeader` and `GenericClassWithoutHeaderNorBody`

# Constructors
* If you create an instance -> it’s invoked in the definition order of the classBody
  * Check `InitOrderDemo`
* If a non-abstract class without constructors declared → it will have by default, a primary constructor
  * Check `NonAbstractWithoutDeclaringConstructors`
## Types
### primary constructor
* `class NameOfTheClass <TypeParameters> AnnotationOrVisibilityModifier constructor(TheirArguments) { classBody }`
  * most generic syntax, specifying `constructor`
* If there are neither annotations nor visibility -> `constructor` keyword can be omitted
### secondary constructor


# init

# Functions

# Properties

# Nested and inner classes

# Object declarations