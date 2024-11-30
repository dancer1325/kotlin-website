[//]: # (title: Kotlin Multiplatform)
[//]: # (description: Kotlin Multiplatform allows creating cross-platform apps for desktop, web, and mobile devices.
Share application logic while keeping native user experience.)

* allows
  * simplifying the development of cross-platform projects
  * reduces time spent
    * Reason: 🧠same code for [different platforms](#kotlin-multiplatform-use-cases) 🧠
  * retain the flexibility and benefits of native programming

![Kotlin Multiplatform](/docs/images/multiplatform/kotlin-multiplatform.svg)

## Kotlin Multiplatform use cases

### Android and iOS applications

* allows
  * building cross-platform mobile applications / sharing code to
    * implement networking,
    * data storage
    * data validation,
    * analytics,
    * computations,
    * other application logic
* Check
  * [Get started with Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-create-first-app.html)
  * [Create a multiplatform app using Ktor and SQLDelight](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html)
  * Compose Multiplatform
    * [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
    * [Create a Compose Multiplatform app](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html)

### Multiplatform libraries

* == multiplatform library / common code + platform-specific implementations for JVM, web, and native platforms
* [Publish a multiplatform library](multiplatform-publish-lib.md)
  * once it's published -> can be used as a dependency | other cross-platform projects

### Desktop applications

* -- thanks to -- Compose Multiplatform
* Check 
  * [Compose Multiplatform desktop application](https://github.com/JetBrains/compose-multiplatform-desktop-template#readme)
  * [JetBrains Toolbox app](https://blog.jetbrains.com/kotlin/2021/12/compose-multiplatform-toolbox-case-study/)

## Code sharing between platforms

* ways
  * among [all platforms / used | your project](multiplatform-share-on-platforms.md#share-code-on-all-platforms)
  * among [some platforms / included | your project](multiplatform-share-on-platforms.md#share-code-on-similar-platforms)

    ![Code shared across different platforms](kotlin-multiplatform-hierarchical-structure.svg){width=700}

* if, from the shared code, you -- need to access -- platform-specific APIs , -> use [expected and actual declarations](multiplatform-expect-actual.md)
* Check 
  * [different platforms](multiplatform-dsl-reference.md#targets)

## Get started

* Check
  * [Get started with Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-create-first-app.html)
  * [sharing code principles and examples](multiplatform-share-on-platforms.md)
  * [cross-platform application samples](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-samples.html)
