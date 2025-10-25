# Kotlin values Examples

## Prerequisites
* [Install the compiler locally](https://kotlinlang.org/docs/command-line.html#install-the-compiler)

## How to create & run an application?
* application
  * == 1! `.kt` file
* `kotlinc NameOfTheFile.kt -include-runtime -d outputPathOrName.jar`
  * create the java application
  * | [Interoperable.kt](Interoperable.kt),
    * Problems:
      * Problem1: error: unresolved reference 'SpringBootApplication'
        * Attempt1: `kotlinc Interoperable.kt -cp spring-boot-starter-web-3.5.7.jar -include-runtime -d Interoperable.jar`
        * Solution: TODO:
  * | [SimplifyConcurrency.kt](SimplifyConcurrency.kt)
    * `kotlinc SimplifyConcurrency.kt -cp kotlinx-coroutines-core-jvm-1.10.2.jar -include-runtime -d SimplifyConcurrency.jar`
      * Problems:
        * Problem1: "SimplifyConcurrency.kt:13:43: error: too many arguments for 'suspend fun Flow<*>.collect(): Unit'."
          * Solution: refactor `collect { value ->`
        * Problem2: "SimplifyConcurrency.kt:14:14: error: cannot infer type for this parameter. Specify it explicitly.onEach { value -> log(start, "Countdown: $value") }^^^^^^"
          * Solution: TODO:
* `java -jar outputPathOrName.jar`
  * run the application
