[//]: # (title: Test code using JUnit in JVM – tutorial)

* goal
  * how to write a simple unit test -- via -- [`kotlin.test`](https://kotlinlang.org/api/latest/kotlin.test/index.html) + JUnit
  * how to run it -- via -- Gradle build tool

## Pre requirements
* install the latest version of [IntelliJ IDEA](https://www.jetbrains.com/idea/download/index.html) 

## Add dependencies

1. Open a Kotlin project in IntelliJ IDEA or [create one](https://www.jetbrains.com/help/idea/create-your-first-kotlin-app.html#create-project)

2. Open the `build.gradle(.kts)` and check that the `testImplementation` dependency is present -> allows you to work with `kotlin.test` and `JUnit`

    <tabs group="build-script">
    <tab title="Kotlin" group-key="kotlin">

   ```kotlin
   dependencies {
       // Other dependencies.
       testImplementation(kotlin("test"))
   }
   ```

    </tab>
    <tab title="Groovy" group-key="groovy">

   ```groovy
   dependencies {
       // Other dependencies.
       testImplementation 'org.jetbrains.kotlin:kotlin-test'
   }
   ```

   </tab>
   </tabs>

3. Add the `test` task to the `build.gradle(.kts)` file
   4. If you use `useJUnitPlatform()` | your build script -> automatically included it

       <tabs group="build-script">
       <tab title="Kotlin" group-key="kotlin">

      ```kotlin
      tasks.test {
          useJUnitPlatform()
      }
      ```

       </tab>
       <tab title="Groovy" group-key="groovy">

      ```groovy
      test {
          useJUnitPlatform()
      }
      ```

      </tab>
      </tabs>
   
* complete code for the `build.gradle.kts`:

    ```kotlin
    plugins {
        kotlin("jvm") version "%kotlinVersion%"
    }
    
    group = "org.example"
    version = "1.0-SNAPSHOT"
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        testImplementation(kotlin("test"))
    }
    
    tasks.test {
        useJUnitPlatform()
    }
    ```
    {initial-collapse-state="collapsed"}

  * -> allows | JVM-only projects & JVM tests of Kotlin Multiplatform (KMP) projects 
    * access to ALL
      * JUnit 5 APIs
      * `kotlin-test` API

## Add the code to test it

1. Open the `Main.kt` file in `src/main/kotlin` 
2. Create the `Sample` class with the `sum()` function / adds two integers together:

   ```kotlin
   class Sample() {

       fun sum(a: Int, b: Int): Int {
           return a + b
       }
   }
   ```

## Create a test

1. Ways
   * via IntelliJ IDEA, select **Code** | **Generate** | **Test...** for the `Sample` class / specify the name of the test class 

      ![Create a test](generate-test.png)

      ![Create a test](create-test.png)
   * via manually, create a `*.kt` | `src/test/kotlin`

2. Add the test code for the `sum()` function | `SampleTest.kt`:

   * Define the test `testSum()` function -- via -- [`@Test` annotation](https://kotlinlang.org/api/latest/kotlin.test/kotlin.test/-test/index.html)
   * Check that the `sum()` function returns the expected value

   ```kotlin
   import org.example.Sample
   import org.junit.jupiter.api.Assertions.*
   import kotlin.test.Test

   class SampleTest {

       private val testSample: Sample = Sample()

       @Test
       fun testSum() {
           val expected = 42
           assertEquals(expected, testSample.sum(40, 2))
       }
   }
   ```

## Run a test

1. Ways
   * via IDE
     1. Run the test using the gutter icon:

        ![Run the test](run-test.png)
   * via CLI
     1. `./gradlew test`

2. Check the result in the **Run** tool window:

   ![Check the test result. The test passed successfully](test-successful.png)

3. Make sure that the test works correctly by changing the `expected` variable value

## What's next

* Check 
  * [`kotlin.test`](https://kotlinlang.org/api/latest/kotlin.test/kotlin.test/)
  * [Kotlin Power-assert compiler plugin](power-assert.md)
    * enriches the test output with contextual information
