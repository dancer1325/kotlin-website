## How has it been created?
### Manually
* download & paste | "../lib/"
  * "kotlinx-serialization-core-jvm-1.6.0.jar"
  * "kotlinx-serialization-json-jvm-1.6.0.jar"
### Dependency Manager
* TODO:

## How to run it locally?
### Manually
* via IDE
  * TODO: NOT display green click button
* via CL
  * | this path
    * `kotlinc -cp "../lib/*" serialization.kt -include-runtime -d serialization.jar`
      * Problems:
        * Problem1: "warning: classpath entry points to a non-existent location: ../lib/*"
          * Attempt1: `kotlinc -cp "../lib/kotlinx-serialization-json-jvm-1.6.0.jar:../lib/kotlinx-serialization-core-jvm-1.6.0.jar" serialization.kt -include-runtime -d serialization.jar`
          * Solution: TODO:
    * `java -jar serialization.jar`
      * Problems:
        * Problem1: "Caused by: java.lang.ClassNotFoundException: kotlinx.serialization.json.Json"
          * Attempt1: `java -cp "../lib/kotlinx-serialization-json-jvm-1.6.0.jar:../lib/kotlinx-serialization-core-jvm-1.6.0.jar" -jar serialization.jar`
          * Attempt2: `java -cp "../lib/kotlinx-serialization-json-jvm-1.6.0.jar:../lib/kotlinx-serialization-core-jvm-1.6.0.jar:serialization.jar" SerializationKt`
          * Solution: TODO:
### Dependency Manager
* TODO: