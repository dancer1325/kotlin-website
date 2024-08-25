[//]: # (title: Create a Spring Boot project with Kotlin)
[//]: # (description: Create a Spring Boot application with Kotlin using IntelliJ IDEA.)

* goal
  * create a Spring Boot project | IntelliJ IDEA -- via -- Project Wizard

## Requisites

* Download and install the latest version of [IntelliJ IDEA Ultimate Edition](https://www.jetbrains.com/idea/download/index.html)
* if you use IntelliJ IDEA Community Edition or another IDE -> generate a Spring Boot project using a [Spring Initialzr](https://start.spring.io)

## Create a Spring Boot project

1. In IntelliJ IDEA, select **File** | **New** | **Project**. 
2. In the panel on the left, select **New Project** | **Spring Initializr**.
3. Specify the following fields and options in the Project Wizard window:
   
   * **Name**: demo
   * **Language**: Kotlin
   * **Build system**: Gradle
   * **JDK**: Java 17 JDK -- Amazon Corretto version 18 is used | this tutorial --
   * **Java**: 17

   ![Create Spring Boot project](create-spring-boot-project.png){width=800}

4. Select the dependencies:

   * **Web / Spring Web**
   * **SQL / Spring Data JDBC**
   * **SQL / H2 Database**

   ![Set up Spring Boot project](set-up-spring-boot-project.png){width=800}

5. structure in the **Project view**

   ![Set up Spring Boot project](spring-boot-project-view.png){width=400}

## Explore the project Gradle build file {initial-collapse-state="collapsed"}

* `build.gradle.kts`
  * Gradle Kotlin build script
  * == necessary Kotlin dependencies + plugins

## Explore the generated Spring Boot application

* check `GetStartedSpringBootApplication.kt`

## Create a controller

* Add `MessageController` class | "GetStartedSpringBootApplication.kt"

## Run the application

* via IDE
  * Click the green Run icon in the gutter beside the `main()` method:

    ![Run Spring Boot application](run-spring-boot-application.png){width=706}
  
* via CL
  * `./gradlew bootRun`

* Once the application starts -> open "http://localhost:8080?name=John" | your browser

    ![Spring Application response](spring-application-response.png){width=706}

## Next step

* [Proceed to the next chapter](jvm-spring-boot-add-data-class.md)
* other alternatives to create it
  * [IntelliJ IDEA with the Spring Boot plugin](https://www.jetbrains.com/help/idea/spring-boot.html)
