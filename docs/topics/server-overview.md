[//]: # (title: Kotlin for server side)

* characteristics
  * **Expressiveness**
    * == abstractions
    * -- thanks to --
      * [type-safe builders](type-safe-builders.md)
      * [delegated properties](delegated-properties.md)
  * **Scalability**
    * -- thanks to --
      * [coroutines](coroutines-overview.md)
  * **Interoperability**
    * == FULLy compatible with ALL Java-based frameworks
  * **Migration**
    * allowed making by steps
      * == Java + Kotlin | same repo
  * **Tooling**
    * IDE support
    * framework-specific tooling -- _Example:_ for Spring
  * **Learning Curve**
    * automated Java-to-Kotlin converter / included | Kotlin plugin
    * [Kotlin Koans](koans.md)

## Frameworks for server-side development with Kotlin

* [Spring](https://spring.io)
  * [Kotlin's language features](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0) | v5.0+
  * [online project generator](https://start.spring.io/#!language=kotlin)
    * allows generating a new project | Kotlin
* [Ktor](https://github.com/kotlin/ktor)
  * := framework /
    * built by JetBrains
    * goal
      * create Web applications | Kotlin
    * characteristics
      * making use of coroutines
      * easy-to-use and idiomatic API
* [Quarkus](https://quarkus.io/guides/kotlin)
  * := open source framework /
    * first class support for Kotlin
    * maintained by Red Hat
    * goal
      * ground up for Kubernetes
* [Vert.x](https://vertx.io)
  * := framework /
    * goal
      * building reactive Web applications | JVM
    * characteristics
      * [dedicated support for Kotlin](https://github.com/vert-x3/vertx-lang-kotlin)
    * [full documentation](https://vertx.io/docs/vertx-core/kotlin/)
* TODO:
* [kotlinx.html](https://github.com/kotlin/kotlinx.html) is a DSL that can be used to build HTML in Web applications.
  It serves as an alternative to traditional templating systems such as JSP and FreeMarker.

* [Micronaut](https://micronaut.io/) is a modern JVM-based full-stack framework for building modular, easily testable microservices and serverless applications. It comes with a lot of useful built-in features.

* [http4k](https://http4k.org/) is the functional toolkit with a tiny footprint for Kotlin HTTP applications, written in pure Kotlin. The library is based on the "Your Server as a Function" paper from Twitter and represents modeling both HTTP servers and clients as simple Kotlin functions that can be composed together.

* [Javalin](https://javalin.io) is a very lightweight web framework for Kotlin and Java which supports WebSockets, HTTP2, and async requests.

* The available options for persistence include direct JDBC access, JPA, and using NoSQL databases through their Java drivers.
  For JPA, the [kotlin-jpa compiler plugin](no-arg-plugin.md#jpa-support) adapts
  Kotlin-compiled classes to the requirements of the framework.
* [other frameworks](https://kotlin.link/resources).

## Deploying Kotlin server-side applications

Kotlin applications can be deployed into any host that supports Java Web applications, including Amazon Web Services,
Google Cloud Platform, and more.

To deploy Kotlin applications on [Heroku](https://www.heroku.com), you can follow the [official Heroku tutorial](https://devcenter.heroku.com/articles/getting-started-with-kotlin).

AWS Labs provides a [sample project](https://github.com/awslabs/serverless-photo-recognition) showing the use of Kotlin
for writing [AWS Lambda](https://aws.amazon.com/lambda/) functions.

Google Cloud Platform offers a series of tutorials for deploying Kotlin applications to GCP, both for [Ktor and App Engine](https://cloud.google.com/community/tutorials/kotlin-ktor-app-engine-java8) and [Spring and App engine](https://cloud.google.com/community/tutorials/kotlin-springboot-app-engine-java8). In addition,
there is an [interactive code lab](https://codelabs.developers.google.com/codelabs/cloud-spring-cloud-gcp-kotlin) for deploying a Kotlin Spring application.

## Products that use Kotlin on the server side

[Corda](https://www.corda.net/) is an open-source distributed ledger platform that is supported by major
banks and built entirely in Kotlin.

[JetBrains Account](https://account.jetbrains.com/), the system responsible for the entire license sales and validation
process at JetBrains, is written in 100% Kotlin and has been running in production since 2015 with no major issues.

## Next steps

* For a more in-depth introduction to the language, check out the Kotlin documentation on this site and [Kotlin Koans](koans.md).
* Watch a webinar ["Micronaut for microservices with Kotlin"](https://micronaut.io/2020/12/03/webinar-micronaut-for-microservices-with-kotlin/) and 
  explore a detailed [guide](https://guides.micronaut.io/latest/micronaut-kotlin-extension-fns.html) 
  showing how you can use [Kotlin extension functions](extensions.md#extension-functions) in the Micronaut framework.
* http4k provides the [CLI](https://toolbox.http4k.org) to generate fully formed projects, and a [starter](https://start.http4k.org) repo to generate an entire CD pipeline using GitHub, Travis, and Heroku with a single bash command.
* Want to migrate from Java to Kotlin? Learn how to perform [typical tasks with strings in Java and Kotlin](java-to-kotlin-idioms-strings.md).
