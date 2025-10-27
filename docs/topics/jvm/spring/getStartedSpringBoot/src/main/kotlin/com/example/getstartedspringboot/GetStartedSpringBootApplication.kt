package com.example.getstartedspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class GetStartedSpringBootApplication

fun main(args: Array<String>) {
	runApplication<GetStartedSpringBootApplication>(*args)
	// *args	== vararg == variable # of String arguments
	// *		spread operator
}

// uses
//		transfer data
data class Message(val id: String?, val text: String)

@RestController
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String?) {
		val messageWithNullableId = Message(null, "Hello!")
		println("Hello, $name!")
		listOf(
			Message("1", "Hello!"),
			Message("2", "Bonjour!"),
			Message("3", "Privet!")
		)
	}

}
