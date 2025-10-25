fun printMessagesUppercased(messages: List<String?>) {

    // 3. collections read-only vs mutable
    // messages.add(Message("Java"))                   // ERROR: List is read-only

    messages.onEachIndexed { index, msg ->
        print("\nMessage #$index: ")
        // print(msg.uppercase())                      // ERROR: `msg` can be null

        // 1. null safety
        msg?.let {
            print(it.uppercase())               // 4. smart casts
        }
    }
}
fun main() {
    // 2. val       can NOT be reassigned
    val messages = mutableListOf("hello", null, "world")
    // messages = mutableListOf("!!!")                 // ERROR: can't reassign a value
    messages.add("Kotlin")                             // OK: the list is mutable
    printMessagesUppercased(messages)                  // Pass the list as read-only
}
