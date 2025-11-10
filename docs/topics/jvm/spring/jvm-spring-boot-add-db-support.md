[//]: # (title: Add database support for Spring Boot project)
[//]: # (description: Add a database support for Sprint Boot project written in Kotlin using JDBC template.)

* goal
  * add & configure a database | your project
    * -- via -- JDBC
      * org.springframework.jdbc.core.JdbcTemplate
        * == class / 
          * simplifies the use of JDBC
          * helps to avoid common errors
  * make HTTP requests

* requirements
  * complete PREVIOUS stes

## Add database support

* Spring Framework based applications
  * ' service layer
    * implement the database access logic
    * mark it -- with -- `@Service` annotation

## Update the MessageController class

* `@PostMapping`
  * == annotation / 
    * allows
      * handling HTTP POST requests
* `@RequestBody`
  * == annotation / 
    * allows
      * 👀\+ Jackson library | classpath, converting the HTTP Body content's JSON -- into an -- object👀

## Update the MessageService class

The application code is ready to work with the database. It is now required to configure the data source.

## Configure the database

Configure the database in the application:

1. Create `schema.sql` file in the `src/main/resources` directory. It will store the database object definitions:

   ![Create database schema](create-database-schema.png){width=400}

2. Update the `src/main/resources/schema.sql` file with the following code:

   ```sql
   CREATE TABLE IF NOT EXISTS messages (
   id       VARCHAR(60)  PRIMARY KEY,
   text     VARCHAR      NOT NULL
   );
   ```

   It creates the `messages` table with two columns: `id` and `text`. The table structure matches the structure of the `Message` class.

3. Open the `application.properties` file located in the `src/main/resources` folder and add the following application properties:

   ```none
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.url=jdbc:h2:file:./data/testdb
   spring.datasource.username=name
   spring.datasource.password=password
   spring.sql.init.schema-locations=classpath:schema.sql
   spring.sql.init.mode=always
   ```

   These settings enable the database for the Spring Boot application.  
   See the full list of common application properties in the [Spring documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html).

## Add messages to database via HTTP request

You should use an HTTP client to work with previously created endpoints. In IntelliJ IDEA, use the embedded HTTP client:

1. Run the application. Once the application is up and running, you can execute POST requests to store messages in the database.
   Create the `requests.http` file in the `src/main/resources` folder and add the following HTTP requests:

   ```http request
   ### Post "Hello!"
   POST http://localhost:8080/
   Content-Type: application/json
   
   {
     "text": "Hello!"
   }
   
   ### Post "Bonjour!"
   
   POST http://localhost:8080/
   Content-Type: application/json
   
   {
     "text": "Bonjour!"
   }
   
   ### Post "Privet!"
   
   POST http://localhost:8080/
   Content-Type: application/json
   
   {
     "text": "Privet!"
   }
   
   ### Get all the messages
   GET http://localhost:8080/
   ```

2. Execute all POST requests. Use the green **Run** icon in the gutter next to the request declaration.
   These requests write the text messages to the database:

   ![Execute POST request](execute-post-requests.png)

3. Execute the GET request and see the result in the **Run** tool window:

   ![Execute GET requests](execute-get-requests.png)

### Alternative way to execute requests {initial-collapse-state="collapsed"}

You can also use any other HTTP client or the cURL command-line tool. For example, run the following commands in
the terminal to get the same result:

```bash
curl -X POST --location "http://localhost:8080" -H "Content-Type: application/json" -d "{ \"text\": \"Hello!\" }"

curl -X POST --location "http://localhost:8080" -H "Content-Type: application/json" -d "{ \"text\": \"Bonjour!\" }"

curl -X POST --location "http://localhost:8080" -H "Content-Type: application/json" -d "{ \"text\": \"Privet!\" }"

curl -X GET --location "http://localhost:8080"
```

## Retrieve messages by id

Extend the functionality of the application to retrieve the individual messages by id.

1. In the `MessageService` class, add the new function `findMessageById(id: String)` to retrieve the individual messages by id:

    ```kotlin
    import org.springframework.jdbc.core.query
    
    @Service
    class MessageService(val db: JdbcTemplate) {
    
        fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
            Message(response.getString("id"), response.getString("text"))
        }
    
        fun findMessageById(id: String): List<Message> = db.query("select * from messages where id = ?", id) { response, _ ->
            Message(response.getString("id"), response.getString("text"))
        }
    
        fun save(message: Message) {
            val id = message.id ?: UUID.randomUUID().toString()
            db.update(
                "insert into messages values ( ?, ? )", 
                id, message.text
            )
        }
    }
    ```
   
    > The `.query()` function that is used to fetch the message by its id is a [Kotlin extension function](extensions.md#extension-functions)
    > provided by the Spring Framework. It requires an additional import `import org.springframework.jdbc.core.query` as demonstrated in the code above.
    >
    {type="warning"}

2. Add the new `index(...)` function with the `id` parameter to the `MessageController` class:

    ```kotlin
    import org.springframework.web.bind.annotation.*
    
    @RestController
    class MessageController(val service: MessageService) {
        @GetMapping("/")
        fun index(): List<Message> = service.findMessages()
    
        @GetMapping("/{id}")
        fun index(@PathVariable id: String): List<Message> =
            service.findMessageById(id)
    
        @PostMapping("/")
        fun post(@RequestBody message: Message) {
            service.save(message)
        }
    }
    ```

    <deflist collapsible="true">
    <def title="Retrieving a value from the context path">
       <p>The message <code>id</code> is retrieved from the context path by the Spring Framework as you annotated the new function by <code>@GetMapping(&quot;/{id}&quot;)</code>. By annotating the function argument with <code>@PathVariable</code>, you tell the framework to use the retrieved value as a function argument. The new function makes a call to <code>MessageService</code> to retrieve the individual message by its id.</p>
    </def>
    <def title="vararg argument position in the parameter list">
        <p>The <code>query()</code> function takes three arguments:</p>
        <list>
            <li>SQL query string that requires a parameter to run</li>
            <li>`id`, which is a parameter of type String</li>
            <li><code>RowMapper</code> instance is implemented by a lambda expression</li>
        </list>
        <p>The second parameter for the <code>query()</code> function is declared as a <i>variable argument</i> (<code>vararg</code>). In Kotlin, the position of the variable arguments parameter is not required to be the last in the parameters list.</p>
    </def>
    </deflist>

Here is a complete code of the `DemoApplication.kt`:

```kotlin
package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import java.util.UUID
import org.springframework.jdbc.core.query
import org.springframework.web.bind.annotation.*


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class MessageController(val service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}

data class Message(val id: String?, val text: String)

@Service
class MessageService(val db: JdbcTemplate) {

    fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun findMessageById(id: String): List<Message> = db.query("select * from messages where id = ?", id) { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message) {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into messages values ( ?, ? )",
            id, message.text
        )
    }
}
```
{initial-collapse-state="collapsed"}

## Run the application

The Spring application is ready to run:

1. Run the application again.

2. Open the `requests.http` file and add the new GET request:

    ```http request
    ### Get the message by its id
    GET http://localhost:8080/id
    ```

3. Execute the GET request to retrieve all the messages from the database.

4. In the **Run** tool window copy one of the ids and add it to the request, like this:

    ```http request
    ### Get the message by its id
    GET http://localhost:8080/f16c1d2e-08dc-455c-abfe-68440229b84f
    ```
    
    > Put your message id instead of the mentioned above.
    >
    {type="note"}

5. Execute the GET request and see the result in the **Run** tool window:

    ![Retrieve message by its id](retrieve-message-by-its-id.png){width=706}

## Next step

The final step shows you how to use more popular connection to database using Spring Data. 

**[Proceed to the next chapter](jvm-spring-boot-using-crudrepository.md)**
