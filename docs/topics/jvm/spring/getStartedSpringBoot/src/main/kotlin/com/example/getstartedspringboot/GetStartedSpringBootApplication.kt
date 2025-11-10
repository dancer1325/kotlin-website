package com.example.getstartedspringboot

import java.util.UUID
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
class MessageController(val service: MessageService) {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String?) {
		val messageWithNullableId = Message(null, "Hello!")
		println("Hello, $name!")
		listOf(
			Message("1", "Hello!"),
			Message("2", "Bonjour!"),
			Message("3", "Privet!"),
		)
	}

	@GetMapping("/anotherList")
	fun anotherList() =
		listOf(
			Message("1", "Hello!"),
			Message("2", "Bonjour!"),
			Message("3", "Privet!"),
		)

	@GetMapping("/services")
	fun index(): List<Message> = service.findMessages()

	@PostMapping("/services")
	fun post(@RequestBody message: Message) {
		service.save(message)
	}
}

@Service
class MessageService(val db: JdbcTemplate) {
	// trailing lambda + SAM conversion
	// _		== unused Lambda arguments
	fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
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
