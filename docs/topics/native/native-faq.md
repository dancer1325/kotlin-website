[//]: # (title: Kotlin/Native FAQ)

## How do I run my program?

* 👀define a top-level function `fun main(args: Array<String>)` or just  `fun main()`👀 /
  * NOT | a package

## What is Kotlin/Native memory management model?

* see [Kotlin/Native memory manager](native-memory-manager.md)

## How do I create a shared library?

* ways
  * use the `-produce dynamic` compiler switch, or
  * | Gradle, `binaries.sharedLib()`

    ```kotlin
    kotlin {
        iosArm64("mylib") {
            binaries.sharedLib()
        }
    }
    ```

* produce a
  * platform-specific shared object (`.so` on Linux, `.dylib` on macOS, and `.dll` on Windows targets)
  * C language header,
    * -> ALL public APIs | your Kotlin/Native program -- can be used -- | C/C++ code

## How do I create a static library or an object file?

* ways
  * use the `-produce static` compiler switch, or
  * | Gradle, `binaries.staticLib()`

    ```kotlin
    kotlin {
        iosArm64("mylib") {
            binaries.staticLib()
        }
    }
    ```

* produce a
  * platform-specific shared object (`.a` library format)
  * C language header,
    * -> ALL public APIs | your Kotlin/Native program -- can be used -- | C/C++ code

## How do I run Kotlin/Native behind a corporate proxy?

* specify 
  * `-Dhttp.proxyHost=xxx -Dhttp.proxyPort=xxx` -- as the -- 
    * compiler's or
    * `gradlew` arguments,
    * set it | `JAVA_OPTS` environment variable
    * Reason: 🧠 Kotlin/Native -- needs to download a -- platform specific toolchain 🧠

## How do I specify a custom Objective-C prefix/name for my Kotlin framework?

* TODO:
Use the `-module-name` compiler option or matching Gradle DSL statement.

<tabs group="build-script">
<tab title="Kotlin" group-key="kotlin">

```kotlin
kotlin {
    iosArm64("myapp") {
        binaries.framework {
            freeCompilerArgs += listOf("-module-name", "TheName")
        }
    }
}
```

</tab>
<tab title="Groovy" group-key="groovy">

```groovy
kotlin {
    iosArm64("myapp") {
        binaries.framework {
            freeCompilerArgs += ["-module-name", "TheName"]
        }
    }
}
```

</tab>
</tabs>

## How do I rename the iOS framework?

The default name is for an iOS framework  is `<project name>.framework`.
To set a custom name, use the `baseName` option. This will also set the module name.

```kotlin
kotlin {
    iosArm64("myapp") {
       binaries {
          framework {
              baseName = "TheName"
          }
       }
    }
}
```

## How do I enable bitcode for my Kotlin framework?

By default gradle plugin adds it on iOS target.
 * For debug build it embeds placeholder LLVM IR data as a marker.
 * For release build it embeds bitcode as data.

Or commandline arguments: `-Xembed-bitcode` (for release) and `-Xembed-bitcode-marker` (debug)

Setting this in a Gradle DSL: 

```kotlin
kotlin {
    iosArm64("myapp") {
        binaries {
            framework {
                // Use "marker" to embed the bitcode marker (for debug builds).
                // Use "disable" to disable embedding.
                embedBitcode("bitcode") // for release binaries.
            }
        }
    }
}
```

These options have nearly the same effect as clang's `-fembed-bitcode`/`-fembed-bitcode-marker`
and swiftc's `-embed-bitcode`/`-embed-bitcode-marker`.

## Why do I see `InvalidMutabilityException`?

> This issue is relevant for the legacy memory manager only. Check out [Kotlin/Native memory management](native-memory-manager.md)
> to learn about the new memory manager, which has been enabled by default since Kotlin 1.7.20.
>
{type="note"}

It likely happens, because you are trying to mutate a frozen object. An object can transfer to the
frozen state either explicitly, as objects reachable from objects on which the `kotlin.native.concurrent.freeze` is called,
or implicitly (i.e. reachable from `enum` or global singleton object - see the next question).

## How do I make a singleton object mutable?

> This issue is relevant for the legacy memory manager only. Check out [Kotlin/Native memory management](native-memory-manager.md)
> to learn about the new memory manager, which has been enabled by default since Kotlin 1.7.20.
>
{type="note"}

Currently, singleton objects are immutable (i.e. frozen after creation), and it's generally considered
good practise to have the global state immutable. If for some reason you need a mutable state inside such an
object, use the `@konan.ThreadLocal` annotation on the object. Also, the `kotlin.native.concurrent.AtomicReference` class could be
used to store different pointers to frozen objects in a frozen object and automatically update them.

## How can I compile my project -- via -- unreleased versions of Kotlin/Native?

* see [preview versions](/docs/topics/eap.md)
* build Kotlin/Native -- from -- source code
  * clone [Kotlin repository](https://github.com/JetBrains/kotlin)
  * follow [these steps](https://github.com/JetBrains/kotlin/blob/master/kotlin-native/README.md#building-from-source)
