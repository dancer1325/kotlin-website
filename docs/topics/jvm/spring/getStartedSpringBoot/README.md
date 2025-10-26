## requirements
* download & install [IntelliJ IDEA Ultimate Edition](https://www.jetbrains.com/idea/download/index.html)

## How has it been created?
* dependencies
  * **Web / Spring Web**
  * **SQL / Spring Data JDBC**
  * **SQL / H2 Database**
### ways
#### [Spring Initialzr](https://start.spring.io)
* select dependencies
#### -- via -- IDE
* | IntelliJ IDEA,
  * **File** > **New** > **Project** > **New Project**
  * **Name**: getStartedSpringBoot
  * **Language**: Kotlin
  * **Build system**: Gradle
  * **JDK**: Java 17 JDK -- Amazon Corretto v8
  * **Java**: 17

## How to run it locally?
* via IDE
  * | gutter, click the green **Run** icon
    * Problems:
      * Problem1: it does NOT identify it
        * Solution: | this path, Mark directory as > Sources root
      * Problem2: "Unresolved reference 'springframework'."
        * Solution: | build.gradle.kts, link gradle project
* via CL
  * `./gradlew bootRun`

## Sample requests
* http://localhost:8080?name=John
