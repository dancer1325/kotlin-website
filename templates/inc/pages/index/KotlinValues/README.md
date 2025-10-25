# Kotlin values Examples

## Prerequisites
* [Install the compiler locally](https://kotlinlang.org/docs/command-line.html#install-the-compiler)

## How to create & run an application?
* application
  * == 1! `.kt` file
* `kotlinc NameOfTheFile.kt -include-runtime -d outputPathOrName.jar`
  * create the java application
  * Problems:
    * Problem1: | [Interoperable.kt](Interoperable.kt),  error: unresolved reference 'SpringBootApplication'
      * Attempt1: `kotlinc Interoperable.kt -cp spring-boot-starter-web-3.5.7.jar -include-runtime -d Interoperable.jar`
      * Solution: TODO:
* `java -jar outputPathOrName.jar`
  * run the application
