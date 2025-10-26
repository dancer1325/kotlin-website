## requirements
* download & install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/index.html)

## How has it been created?
* | IntelliJ IDEA,
  * **File** > **New** > **Project** > **New Project**
  * Project name: getStarted
  * **Language**: **Kotlin**
  * Build system: IntelliJ
  * **JDK**: choose whatever you want
  * **Add sample code**
    * == create a file / sample `"Hello World!"` application
     
  ![](/docs/images/get-started/jvm-new-project.png)

## How to run it locally?
* ways to run
  * via IDE
    * | gutter, click the green **Run** icon
      * Problems:
        * Problem1: it does NOT identify it
          * Solution: | this path, Mark directory as > Sources root
        * Problem2: "Unresolved reference 'println'."
          * Solution: File > Project structure > Modules > Dependencies > + > Library > "org.jetbrains.kotlin:kotlin-stdlib"
  * via CL
    * `kotlinc Main.kt -include-runtime -d Main.jar`
    * `java -jar Main.jar
