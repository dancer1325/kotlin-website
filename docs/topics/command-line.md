[//]: # (title: Kotlin command-line compiler)

* Kotlin compiler
  * standalone version / EACH Kotlin release 
    * _Example:_ [here](https://github.com/JetBrains/kotlin/releases/tag/v2.2.21)
  * 💡ways to get💡
    * [install it](#ways-to-install-the-compiler)
    * included | IDEs OR code editors / have official Kotlin support 
      * [IntelliJ IDEA](https://www.jetbrains.com/idea/),
      * [JetBrains Fleet](https://www.jetbrains.com/fleet/),
      * [Android Studio](https://developer.android.com/studio)

## Ways to install the compiler

### Manual install
* steps
  1. | [GitHub Kotlin Releases](https://github.com/JetBrains/kotlin/releases), download `kotlin-compiler-%kotlinVersion%.zip` 
  2. Unzip | directory + OPTIONALLY add the `bin` | path
     3. Reason: 🧠 contains scripts / allows compiling & run Kotlin | Windows, macOS, and Linux🧠

* | Windows, recommended option

### SDKMAN!
* TODO:
An easier way to install Kotlin on UNIX-based systems, such as macOS, Linux, Cygwin, FreeBSD, and Solaris, is
[SDKMAN!](https://sdkman.io)
* It also works in Bash and ZSH shells
* [Learn how to install SDKMAN!](https://sdkman.io/install).

To install the Kotlin compiler via SDKMAN!, run the following command in the terminal:

```bash
sdk install kotlin
```

### Homebrew

```bash
brew update
brew install kotlin
```

### Snap package

If you use [Snap](https://snapcraft.io/) on Ubuntu 16.04 or later, you can install the compiler from the command line:

```bash
sudo snap install --classic kotlin
```

## Create and run an application

* `kotlinc pathToKotlinFile.kt -include-runtime -d someJarFileOrSomeFolder`
  * `-include-runtime`
    * include Kotlin runtime | output
  * `-d someJarFileOrSomeFolder`
    * `-d someJarFile`
      * create a .jar file
      * \+ `-include-runtime` -> executable .jar
    * `-d someFolder`
      * create .class files

## Compile a library

* library
  * uses
    * by OTHER Kotlin applications

* `kotlinc pathToKotlinFile.kt -d someJarFileOrSomeFolder`
  * build the **.jar** WITHOUT Kotlin runtime /
    * PathToKotlinFileKt
      * generated class

* if you want to run ->  ways
  * `java -cp someJarFileOrSomeFolder:kotlinRuntime.jar GeneratedClass`
  * `kotlin -classpath someJarFileOrSomeFolder GeneratedClass`

## Run the REPL

* REPL
  * == Read-Eval-Print Loop
  * == interactive shell
  * `kotlinc`
    * WITHOUT arguments
  * uses
    * type any valid Kotlin code

![](/docs/images/command-line/kotlin-shell.png)

## Run scripts

* == Kotlin -- as a -- scripting language
* Kotlin script
  * == 💡`.kts` / top-level executable code💡
    * ALLOWED extensions
      * `.kts`
        * == standard Kotlin script
      * `.gradle.kts`
        * == Gradle Kotlin script 
      * `.main.kts` 
        * == AUTOMATIC dependencies script
      * custom extensions
  * _script definitions_
    * == annotated kotlin classes /
      * allows
        * customizations (add external properties, provide static or dynamic dependencies)
      * if the proper jars are included | compilation classpath -> detect & apply AUTOMATICALLY the prepared script definitions
      * OTHERWISE, specify MANUALLY -- by -- passing `-script-templates`
        * [KEEP-75](https://github.com/Kotlin/KEEP/blob/master/proposals/scripting-support.md)

* `kotlinc -script scriptPath.kts -- -d <path_to_folder_to_inspect>`
  * run a script
