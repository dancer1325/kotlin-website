# prerequisites
* [get kotlinc](../../command-line.md)

# how to run locally?
## `-d outputPathToJarFile`
* `kotlinc HelloWorld.kt -d HelloWorld.jar`
* ways to run
  * `java -cp HelloWorld.jar:$KOTLIN_HOME/lib/kotlin-stdlib.jar HelloWorldKt`
  * `kotlin -classpath HelloWorld.jar HelloWorldKt`
    * `HelloWorldKt`
      * == generated class
## `-include-runtime` + `-d outputPathToJarFile`  
* `kotlinc HelloWorld.kt -include-runtime -d HelloWorldWithRuntime.jar`
* `java -jar HelloWorldWithRuntime.jar`
## `-d outputPathToDirectory`
* `kotlinc HelloWorld.kt -d output`
* ways to run
  * `java -cp output:$KOTLIN_HOME/lib/kotlin-stdlib.jar HelloWorldKt`
  * `kotlin -classpath output HelloWorldKt`
    * HelloWorldKt
      * == generated class
## `-include-runtime` + `-d outputPathToDirectory` 
* `kotlinc HelloWorld.kt -include-runtime -d outputWithRuntime`
* `java -cp outputWithRuntime HelloWorldKt`

# run the REPL
* `kotlinc`
  * `2+2`
  * `println("Welcome")`

# run scripts
* `kotlinc -script script.kts` OR  `kotlinc -script script.kts -- -d .`
## ALLOWED extensions
### `.kts`
* `kotlinc -script script.kts`
### `.gradle.kts`
* `gradle hello`
  * execute the task
### `.main.kts`
* `kotlinc -script example.main.kts`
### custom extensions
* [CustomScriptDefinition.kt](CustomScriptDefinition.kt)
* `kotlinc -cp kotlin-scripting-common-2.1.21.jar:kotlin-scripting-jvm-2.1.21.jar CustomScriptDefinition.kt -d custom-script.jar`
  * [kotlin-scripting-common-2.1.21.jar](https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-scripting-common/2.1.21/) & [kotlin-scripting-jvm-2.1.21.jar](https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-scripting-jvm/2.1.21/)
    * required
* `kotlinc -cp custom-script.jar -script example.custom.kts`
  * Problems:
    * Problem1: "example.custom.kts:7:12: error: unresolved reference 'File'."
      * Solution: Script definition no se aplica correctamente
        * Añadir `import java.io.File` manualmente
        * Especificar tipos: `{ f: File -> ... }`
        * Las extensiones custom son complejas sin Gradle/Maven
## script definitions
* TODO:
### if the proper jars are included | compilation classpath -> detect & apply AUTOMATICALLY the prepared script definitions
* TODO:
### `-script-templates`
* TODO: 
