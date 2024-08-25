[//]: # (title: Get started with Kotlin/JVM)

* goal
  * use IntelliJ IDEA -- for -- creating a console application

* requirements
  * download and install the latest version of [IntelliJ IDEA](https://www.jetbrains.com/idea/download/index.html)

## Create a project
1. In IntelliJ IDEA, select **File** | **New** | **Project**.
2. In the panel on the left, select **New Project**.
3. Name the new project and change its location if necessary.
4. From the **Language** list, select **Kotlin**.
   
   ![Create a console application](jvm-new-project.png){width=700}

5. Select the **IntelliJ** build system.
   6. := native builder / does NOT require downloading additional artifacts
   7. if you want to create a more complex project -> select Maven or Gradle (choose a language for the build script: Kotlin or Groovy)
6. From the **JDK list**, select the [JDK](https://www.oracle.com/java/technologies/downloads/) / you want to use
   * If the JDK is installed | your computer, BUT NOT defined | the IDE -> select **Add JDK** / specify the path to the
   JDK home directory. 
   * If you do NOT have the necessary JDK | your computer -> select **Download JDK**.

7. Enable the **Add sample code** option / create a file with a sample `"Hello World!"` application.

8. Click **Create**.

## Create an application

1. Open the `Main.kt` file in `src/main/kotlin`

   ![Main.kt with main fun](jvm-main-kt-initial.png){width=700}

2. Modify the code / it requests your name and says `Hello` to you alone

   ![Updated main fun](jvm-main-kt-updated.png){width=350}

## Run the application

* ways to run it
  * via IDE
    * click the green **Run** icon in the gutter and select **Run 'MainKt'**
  * via CL
    * `kotlinc Main.kt -include-runtime -d Main.jar`
    * `java -jar Main.jar`


## What's next?
* Check [JetBrains Academy plugin](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy)
* complete exercises from the [Kotlin Koans course](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy/docs/learner-start-guide.html?section=Kotlin%20Koans)