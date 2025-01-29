[//]: # (title: Stability of Kotlin components)

* 👀Kotlin language & toolset -- are divided into -- MANY components 👀
  * == 
    * compilers for the 
      * JVM,
      * JS
      * Native targets,
    * Standard Library,
    * accompanying tools
  * SOME components 
    * 💡-- were officially released as -- Stable 💡
      * == backward-compatible / -- follow -- [Kotlin evolution principles](kotlin-evolution.md)
      * _Examples:_ 
        * Kotlin compiler for the JVM,
        * Standard Library,
        * Coroutines
    * ⚠️-- are NOT YET -- Stable ⚠️
      * / -- follow the -- [Feedback Loop principle](kotlin-evolution.md)
      * Reason: 🧠 release earlier -- for the -- community 🧠
      * evolution stages NOT stable
        * Experimental
        * Alpha
        * Beta 

## Stability levels explained

* **Experimental**
  * == "try it ONLY | toy projects"
    * Reason: 🧠if it doesn't work out -> we MAY drop it any minute 🧠

* **Alpha**
  * TODO: means "use at your own risk, expect migration issues": 
    * We intend to productize this idea, but it hasn't reached its final shape yet.

**Beta** means "you can use it, we'll do our best to minimize migration issues for you": 
  * It's almost done, user feedback is especially important now.
  * Still, it's not 100% finished, so changes are possible (including ones based on your own feedback).
  * Watch for deprecation warnings in advance for the best update experience.

We collectively refer to _Experimental_, _Alpha_ and _Beta_ as **pre-stable** levels.

<a name="stable"></a>
**Stable** means "use it even in most conservative scenarios":
  * It's done. We will be evolving it according to our strict [backward compatibility rules](https://kotlinfoundation.org/language-committee-guidelines/).

Please note that stability levels do not say anything about how soon a component will be released as Stable. Similarly, they do not indicate how much a component will be changed before release. They only say how fast a component is changing and how much risk of update issues users are running.

## GitHub badges for Kotlin components

The [Kotlin GitHub organization](https://github.com/Kotlin) hosts different Kotlin-related projects.
Some of them we develop full-time, while others are side projects.

Each Kotlin project has two GitHub badges describing its stability and support status:

* **Stability** status. This shows how quickly each project is evolving and how much risk the users are taking when adopting it.
  The stability status completely coincides with the [stability level of the Kotlin language features and its components](#stability-levels-explained):
    * ![Experimental stability level](https://kotl.in/badges/experimental.svg){type="joined"} stands for **Experimental**
    * ![Alpha stability level](https://kotl.in/badges/alpha.svg){type="joined"} stands for **Alpha**
    * ![Beta stability level](https://kotl.in/badges/beta.svg){type="joined"} stands for **Beta**
    * ![Stable stability level](https://kotl.in/badges/stable.svg){type="joined"} stands for **Stable**

* **Support** status. This shows our commitment to maintaining a project and helping users to solve their problems.
  The level of support is unified for all JetBrains products.  
  [See the JetBrains Confluence document for details](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub).

## Stability of subcomponents

A stable component may have an experimental subcomponent, for example:
* a stable compiler may have an experimental feature;
* a stable API may include experimental classes or functions;
* a stable command-line tool may have experimental options.

We make sure to document precisely which subcomponents are not stable. We also do our best to warn users where possible and ask to opt in explicitly to avoid accidental usages of features that have not been released as stable.

## Current stability of Kotlin components

| **Component**                                     | **Status**   | **Status since version** | **Comment**                                                                |
|---------------------------------------------------|--------------|--------------------------|----------------------------------------------------------------------------|
| Kotlin/JVM                                        | Stable       | 1.0                      |                                                                            |
| Kotlin K2 (JVM, Native, JS)                       | Stable       | 2.0.0                    |                                                                            |
| kotlin-stdlib (JVM)                               | Stable       | 1.0                      |                                                                            |
| Coroutines                                        | Stable       | 1.3                      |                                                                            |
| kotlin-reflect (JVM)                              | Beta         | 1.0                      |                                                                            |
| Kotlin/JS (Classic backend)                       | Stable       | 1.3                      | Deprecated from 1.8.0, read the [IR migration guide](js-ir-migration.md)   |
| Kotlin/JVM (IR-based)                             | Stable       | 1.5                      |                                                                            |
| Kotlin/JS (IR-based)                              | Stable       | 1.8                      |                                                                            |
| Kotlin/Native Runtime                             | Stable       | 1.9.20                   |                                                                            |
| Kotlin/Native memory manager                      | Stable       | 1.9.20                   |                                                                            |
| klib binaries                                     | Stable       | 1.9.20                   | Not including cinterop klibs, see below                                    |
| Kotlin Multiplatform                              | Stable       | 1.9.20                   |                                                                            |
| Kotlin/Native interop with C and Objective C      | Beta         | 1.3                      |                                                                            |
| cinterop klib binaries                            | Beta         | 1.3                      |                                                                            |
| CocoaPods integration                             | Stable       | 1.9.20                   |                                                                            |
| Kotlin Multiplatform plugin for Android Studio    | Beta         | 0.8.0                    | [Versioned separately from the language](multiplatform-plugin-releases.md) |
| expected and actual functions and properties      | Stable       | 1.9.20                   |                                                                            |
| expected and actual classes                       | Beta         | 1.7.20                   |                                                                            |
| KDoc syntax                                       | Stable       | 1.0                      |                                                                            |
| Dokka                                             | Beta         | 1.6                      |                                                                            |
| Scripting syntax and semantics                    | Alpha        | 1.2                      |                                                                            |
| Scripting embedding and extension API             | Beta         | 1.5                      |                                                                            |
| Scripting IDE support                             | Beta         |                          | Available since IntelliJ IDEA 2023.1 and later                             |
| CLI scripting                                     | Alpha        | 1.2                      |                                                                            |
| Compiler Plugin API                               | Experimental | 1.0                      |                                                                            |
| Serialization Compiler Plugin                     | Stable       | 1.4                      |                                                                            |
| Serialization Core Library                        | Stable       | 1.0.0                    | Versioned separately from the language                                     |
| Unsigned arithmetic                               | Stable       | 1.5                      |                                                                            |
| Contracts in stdlib                               | Stable       | 1.3                      |                                                                            |
| User-defined contracts                            | Experimental | 1.3                      |                                                                            |
| **All other experimental components, by default** | Experimental | N/A                      |                                                                            |

*[The pre-1.4 version of this page is available here](components-stability-pre-1.4.md).*
