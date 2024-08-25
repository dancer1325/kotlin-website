[//]: # (title: Get started with Kotlin)

* := Modern and mature programming language / it’s
  * concise
  * safe
  * interoperable -- with -- Java & other languages
  * several ways to reuse code between multiple platforms

## Install Kotlin

* ways
  * included in each 
    * [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) &
    * [Android Studio](https://developer.android.com/studio) release
  * [install Kotlin CL compiler](https://kotlinlang.org/docs/command-line.html)

## Choose your Kotlin use case

* Backend
  * == Kotlin server-side applications
  * check 
    * [create a basic JVM application with the IntelliJ IDEA project wizard](jvm-get-started.md)
    * via frameworks
      * Spring
        * [Create a RESTful web service with Spring Boot](jvm-get-started-spring-boot.md)
        * [Build web applications with Spring Boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin/)
        * [Use Spring Boot with Kotlin and RSocket](https://spring.io/guides/tutorials/spring-webflux-kotlin-rsocket/)
      * Ktor
        * := lightweight framework / 
          * freedom in making architectural decisions
        * [Create HTTP APIs with Ktor](https://ktor.io/docs/creating-http-apis.html)
        * [Create a WebSocket chat with Ktor](https://ktor.io/docs/creating-web-socket-chat.html)
        * [Create an interactive website with Ktor](https://ktor.io/docs/creating-interactive-website.html)
        * [Publish server-side Kotlin applications: Ktor on Heroku](https://ktor.io/docs/heroku.html)
    * \+ TP libraries 
      * [adding library and tool dependencies to your project](gradle-configure-project.md#configure-dependencies)
      * [Kotlin standard library](https://kotlinlang.org/api/latest/jvm/stdlib/)
      * [third-party frameworks, libs and tools for Kotlin](https://blog.jetbrains.com/kotlin/2020/11/server-side-development-with-kotlin-frameworks-and-libraries/)
    * others
      * [How to write your first unit test](jvm-test-using-junit.md)
      * [How to mix Kotlin and Java code in your application](mixing-java-kotlin-intellij.md)

* Cross-platform
  * -- via -- [Kotlin Multiplatform](https://kotlinlang.org/lp/multiplatform/)
  * requirements
    * [Set up your environment for cross-platform development](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-setup.html)
  * check
    * [Kotlin Multiplatform](multiplatform-get-started.md)
    * [Publish a multiplatform library](multiplatform-publish-lib.md)
    * [create a basic cross-platform application with the project wizard](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-create-first-app.html)
    * [Make your Android application work on iOS](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-integrate-in-existing-app.html)
    * real-life examples
      * [Create a multiplatform app using Ktor and SQLdelight](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html)or
      * [sample project](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-samples.html)
      * used at [Netflix](https://netflixtechblog.com/netflix-android-and-ios-studio-apps-kotlin-multiplatform-d6d4d8d25d23), [VMware](https://kotlinlang.org/lp/multiplatform/case-studies/vmware/), [Yandex](https://kotlinlang.org/lp/multiplatform/case-studies/yandex/), and [many other companies](https://kotlinlang.org/lp/multiplatform/case-studies/)
    * **multiplatform libraries**
      * check [adding dependencies](multiplatform-add-dependencies.md) & [community-driven list](https://libs.kmp.icerock.dev/)

   |Library| Details                                                                                                                                                            |
   |-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
   | Ktor | [Docs](https://ktor.io/docs/client.html)                                                                                                                           | 
   | Serialization | [Docs](serialization.md) and [sample](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html#create-an-application-data-model) |
   | Coroutines | [Docs](coroutines-guide.md) and [sample](coroutines-and-channels.md)                                                                                               |
   | DateTime | [Docs](https://github.com/Kotlin/kotlinx-datetime#readme)                                                                                                          |
   | SQLDelight | Third-party library. [Docs](https://cashapp.github.io/sqldelight/)                                                                                                 |

* Android
  * check
    * [Google's recommendation for getting started with Kotlin on Android](https://developer.android.com/kotlin/get-started)

* Data analysis
  * uses
    * building data pipelines / product machine learning models 
  * check
    * [Get started with Kotlin Notebook](get-started-with-kotlin-notebooks.md)
    * [DataFrame](https://kotlin.github.io/dataframe/overview.html)
      * := library / allows data analysis & manipulation
   * [Kandy](https://kotlin.github.io/kandy/welcome.html)
     * == plotting tool -- for -- data visualization
