[//]: # (title: Adding dependencies on multiplatform libraries)

* libraries
  * uses
    * program can operate successfully

* Kotlin Multiplatform project -- can depend on --
  * multiplatform libraries / work | ALL target platforms
  * platform-specific libraries
  * other multiplatform projects

* way to add a dependency of a library
  * | your project's shared code `build.gradle(.kts)`, set a dependency of the required [type](/docs/topics/gradle/gradle-configure-project.md#dependency-types) (_Example:_ `implementation`)
    * | [`dependencies {}`](multiplatform-dsl-reference.md#dependencies)
      * _Example:_ 
          ```kotlin
          kotlin {
              sourceSets {
                  commonMain.dependencies {
                      implementation("com.example:my-library:1.0") // library shared for all source sets
                  }
              }
          }
          ```

          ```groovy
          kotlin {
              sourceSets {
                  commonMain {
                      dependencies {
                          implementation 'com.example:my-library:1.0'
                      }
                  }
              }
          }
          ```
    * | [top level](/docs/topics/gradle/gradle-configure-project.md#set-dependencies-at-top-level)

## Dependency on a Kotlin library

### Standard library

* `stdlib`'s dependency -- is automatically -- added | EACH source set
  * `stdlib`'s version == `kotlin-multiplatform` plugin's version

* Kotlin Gradle plugin -- will select -- 
  * | platform-specific source sets, the appropriate JVM standard library / 
    * depend on the `compilerOptions.jvmTarget`
      * == [compiler option](/docs/topics/gradle/gradle-compiler-options.md) of your Gradle build script
  * | rest, a common standard library
    * see [how to change the default behavior](/docs/topics/gradle/gradle-configure-project.md#dependency-on-the-standard-library)

### Test libraries

* | multiplatform tests, the [`kotlin.test`](https://kotlinlang.org/api/latest/kotlin.test/) API is available

* | multiplatform project, you can add test dependencies | ALL the source sets, -- via -- 1! dependency in `commonTest`
  * _Example:_

      ```kotlin
      kotlin {
          sourceSets {
              commonTest.dependencies {
                  implementation(kotlin("test")) // Brings all the platform dependencies automatically
              }
          }
      }
      ```

      ```groovy
      kotlin {
          sourceSets {
              commonTest {
                  dependencies {
                      implementation kotlin("test") // Brings all the platform dependencies automatically
                  }
              }
          }
      }
      ```

### kotlinx libraries

* if you use a multiplatform library & need to [depend on the shared code](#library-shared-for-all-source-sets) -> set the dependency ONLY 1! | shared source set & use the library base artifact name
  * _Example:_ `kotlinx-coroutines-core`

      ```kotlin
      kotlin {
          sourceSets {
              commonMain.dependencies {
                  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:%coroutinesVersion%")
              }
          }
      }
      ```

      ```groovy
      kotlin {
          sourceSets {
              commonMain {
                  dependencies {
                      implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:%coroutinesVersion%'
                  }
              }
          }
      }
      ```

* if you use a kotlinx library & need a [platform-specific dependency](#library-used-in-specific-source-sets) -> use platform-specific variants of libraries with suffixes (_Example:_ `-jvm` or `-js`)
  * _Example:_ `kotlinx-coroutines-core-jvm`

    ```kotlin
    kotlin {
        sourceSets {
            jvmMain.dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:%coroutinesVersion%")
            }
        }
    }
    ```

    ```groovy
    kotlin {
        sourceSets {
            jvmMain {
                dependencies {
                    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:%coroutinesVersion%'
                }
            }
        }
    }
    ```

## Dependency on Kotlin Multiplatform libraries

* Kotlin Multiplatform libraries
  * == libraries / -- have adopted -- Kotlin Multiplatform technology
    * _Example:_ [SQLDelight](https://github.com/cashapp/sqldelight)
  * see [community-maintained list of Kotlin Multiplatform libraries](https://libs.kmp.icerock.dev/)

### Library shared for all source sets

* if you add it | common source set -> it can be used | ALL source sets
  * Reason: 🧠 Kotlin Multiplatform Mobile plugin -- will automatically add the -- corresponding parts | ANY other source sets 🧠

* ❌NOT set dependencies on platform-specific libraries | common source set ❌

* _Example:_

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("io.ktor:ktor-client-core:%ktorVersion%")
            }
            androidMain.dependencies {
                // dependency to a platform part of ktor-client will be added automatically
            }
        }
    }
    ```

    ```groovy
    kotlin {
        sourceSets {
            commonMain {
                dependencies {
                    implementation 'io.ktor:ktor-client-core:%ktorVersion%'
                }
            }
            androidMain {
                dependencies {
                    // dependency to platform part of ktor-client will be added automatically
                }
            }
        }
    }
    ```

### Library | specific source sets

* if you want to use a multiplatform library | specific source sets -> add it exclusively | them
  * -> specified library declarations will then be AVAILABLE ONLY | those source sets
  * recommendations
    * 👀use a common library name != platform-specific name👀
      * see | specific library's documentation

* _Example:_

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                // kotlinx.coroutines will be available in all source sets
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:%coroutinesVersion%")
            }
            androidMain.dependencies {
    
            }
            iosMain.dependencies {
                // SQLDelight will be available only in the iOS source set, but not in Android or common
                implementation("com.squareup.sqldelight:native-driver:%sqlDelightVersion%")
            }
        }
    }
    ```

    ```groovy
    kotlin {
        sourceSets {
            commonMain {
                dependencies {
                    // kotlinx.coroutines will be available in all source sets
                    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:%coroutinesVersion%'
                }
            }
            androidMain {
                dependencies {}
            }
            iosMain {
                dependencies {
                    // SQLDelight will be available only in the iOS source set, but not in Android or common
                    implementation 'com.squareup.sqldelight:native-driver:%sqlDelightVersion%'
                }
            }
        }
    }
    ```

## Dependency on another multiplatform project

* one multiplatform project -- can be connected, via dependency with -- another multiplatform project
  * add a project dependency | source set / needs it

* _Example:_

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation(project(":some-other-multiplatform-module"))
            }
            androidMain.dependencies {
                // platform part of :some-other-multiplatform-module will be added automatically
            }
        }
    }
    ```

    ```groovy
    kotlin {
        sourceSets {
            commonMain {
                dependencies {
                    implementation project(':some-other-multiplatform-module')
                }
            }
            androidMain {
                dependencies {
                    // platform part of :some-other-multiplatform-module will be added automatically
                }
            }
        }
    }
    ```

## What's next?

* [Adding Android dependencies](multiplatform-android-dependencies.md)
* [Adding iOS dependencies](multiplatform-ios-dependencies.md)
