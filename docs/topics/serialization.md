[//]: # (title: Serialization)

* _Serialization_
  * := process of data used by an application -- is converted to a -- format / can be
    * transferred -- over a -- network
    * stored | database OR file
  * formats
    * [JSON](https://www.json.org/json-en.html)
    * [protocol buffers](https://developers.google.com/protocol-buffers)

* _deserialization_
  * := process of data | external source -- is 
    * read
    * converted it into a -- runtime object
 
* allows
  * being language-neutral & platform-neutral 

* uses
  * MOST applications / exchange data -- with -- third parties

## Libraries

* `org.jetbrains.kotlinx:` group, 
  * ALL Kotlin serialization libraries
  * `kotlinx-serialization-ConcreteSerializationFormat`
    * artifact names
    * _Examples:_
      * `org.jetbrains.kotlinx:kotlinx-serialization-json`
        * JSON serialization
      * `org.jetbrains.kotlinx:kotlinx-serialization-cbor`
        * CBOR serialization
    * support ALL platforms
      * == 1 artifact / ALL platforms

* [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)
  * == 👀SET of data serialization libraries 👀 /
    * SEPARATE component
      * == ❌NOT | kotlin ❌
    * supports
      * platforms
        * JVM
        * JavaScript
        * Native
      * serialization formats
        * official
          * JSON, 
          * CBOR,
          * protocol buffers,
          * ...
        * [community](https://github.com/Kotlin/kotlinx.serialization/blob/master/formats/README.md)
    * versioning != Kotlin's versioning
  * == `org.jetbrains.kotlin.plugin.serialization` Gradle plugin + [runtime libraries](#libraries) + compiler plugins
    * compiler plugins
      * are
        * `kotlinx-serialization-compiler-plugin`
        * `kotlinx-serialization-compiler-plugin-embeddable`
          * 's goal
            * use + `kotlin-compiler-embeddable` artifact 
      * published DIRECTLY | Maven Central
      * | Gradle,
        * if you want to add | your projects -> add -- as -- compiler arguments 
  * `kotlin-compiler-embeddable` artifact
    * allows
      * scripting artifacts
        * indeed, default option

## _Example:_ JSON serialization

* goal
  * serialize Kotlin objects (class instances, collections, ...) -- into -> JSON

### steps
#### 1. Add plugins & dependencies

1. add Kotlin serialization Gradle plugin
    ```kotlin,tittle=build.gradle.kts
    plugins {
      kotlin("jvm") version "%kotlinVersion%"
      kotlin("plugin.serialization") version "%kotlinVersion%"
    }  
    ```

    ```groovy, title=build.gradle
    plugins {
        id 'org.jetbrains.kotlin.jvm' version '%kotlinVersion%'
        id 'org.jetbrains.kotlin.plugin.serialization' version '%kotlinVersion%'  
    }
    ```

2. add JSON serialization library dependency

    ```kotlin,tittle=build.gradle.kts
    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:%serializationVersion%")
    } 
    ```

    ```groovy, title=build.gradle
    dependencies {
        implementation 'org.jetbrains.kotlinx:kotlinx-serialization-json:%serializationVersion%'
    } 
    ```

#### 2. Serialize & deserialize JSON

1. | class,
   1. annotate with `@Serializable`

    ```kotlin
    import kotlinx.serialization.Serializable
    
    @Serializable
    data class Data(val a: Int, val b: String)
    ```

2. if you want to serialize a class' instance -> call `Json.encodeToString()`

```kotlin
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
data class Data(val a: Int, val b: String)

fun main() {
   // serialize a class instance 
   val json = Json.encodeToString(Data(42, "str"))
   val dataList = listOf(Data(42, "str"), Data(12, "test"))
   val jsonList = Json.encodeToString(dataList)
}
```

3. if you want from JSON -- deserialize into -- an object -> use `decodeFromString()`  

```kotlin
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

@Serializable
data class Data(val a: Int, val b: String)

fun main() {
   // deserialize 
   val obj = Json.decodeFromString<Data>("""{"a":42, "b": "str"}""")
}
```

## What's next

* see [Kotlin Serialization Guide](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serialization-guide.md).
