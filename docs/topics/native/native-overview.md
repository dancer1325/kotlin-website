[//]: # (title: Kotlin Native)

* Kotlin/Native
  * == technology / 
    * 👀Kotlin code -- is compiled to -- native binaries / can run WITHOUT a VM 👀
    * includes
      * backend [LLVM](https://llvm.org/)-based -- for the -- Kotlin compiler
      * native implementation of the Kotlin standard library

## Why Kotlin/Native?

* goal
  * 💡compilation for platforms / NOT desire or possible VM💡
    * _Example:_ embedded devices or iOS
    * use cases
      * produce a self-contained (== WITHOUT additional runtime or VM) program  

## Target platforms

* supported platforms
  * macOS
  * iOS, tvOS, watchOS
  * Linux
  * Windows (MinGW)
  * Android NDK
  * see the [full list](native-target-support.md)

* requirements
  * | Apple targets (macOS, iOS, tvOS, and watchOS)
    * install [Xcode](https://apps.apple.com/us/app/xcode/id497799835) + its command-line tools

## Interoperability

* Kotlin/Native
  * supports
    * two-way interoperability -- with -- native programming languages | different OS
      * compiler creates
        * executable / MANY [platforms](#target-platforms)
        * static library OR [dynamic](native-dynamic-libraries.md) library / C headers -- for -- C/C++ projects
        * [Apple framework](apple-framework.md) -- for -- Swift & Objective-C projects
      * -> compiled Kotlin code -- can be easily -- included | EXISTING projects / written in
        * C,
        * C++,
        * Swift,
        * Objective-C,
        * other languages 
    * interoperability -- to use directly -- existing libraries | Kotlin/Native
      * static or dynamic [C libraries](native-c-interop.md)
      * C, [Swift, and Objective-C](native-objc-interop.md) frameworks
  * 's [libraries](native-platform-libs.md)
    * help share Kotlin code -- between -- projects, POSIX, gzip, OpenGL, Metal, Foundation, and many other popular libraries and Apple frameworks

## Sharing code between platforms

* see
  * [Kotlin Multiplatform](/docs/topics/multiplatform/multiplatform.md)
  * [Get started with Kotlin Multiplatform](/docs/topics/multiplatform/multiplatform-get-started.md)
  * [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/),

## How to get started

New to Kotlin? Take a look at [Getting started with Kotlin](getting-started.md).

Recommended documentation:

* [Get started with Kotlin Multiplatform](multiplatform-get-started.md)
* [Interoperability with C](native-c-interop.md)
* [Interoperability with Swift/Objective-C](native-objc-interop.md)

Recommended tutorials:

* [Get started with Kotlin/Native](native-get-started.md)
* [Get started with Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-create-first-app.html)
* [Mapping primitive data types from C](mapping-primitive-data-types-from-c.md)
* [Kotlin/Native as a dynamic Library](native-dynamic-libraries.md)
* [Kotlin/Native as an Apple framework](apple-framework.md)
