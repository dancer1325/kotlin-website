// Use any existing JVM library or framework
// Call Kotlin code from Java without an issue

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class MessageResource {
    @GetMapping
    fun index(): List&lt;Message> = listOf(
    Message("1", "Hello!"),
    Message("2", "Bonjour!"),
    Message("3", "Privet!"),
    )
}

data class Message(val id: String?, val text: String)
