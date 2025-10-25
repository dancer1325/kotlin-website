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
* `java -jar outputPathOrName.jar`
  * run the application
  * | [SimplifyConcurrency.kt](SimplifyConcurrency.kt)
    * Problems:
      * Problem1: "Error: Unable to initialize main class SimplifyConcurrencyKt. java.lang.NoClassDefFoundError: kotlinx/coroutines/flow/Flow"
        * Solution: `java -cp SimplifyConcurrency.jar:kotlinx-coroutines-core-jvm-1.10.2.jar SimplifyConcurrencyKt`
