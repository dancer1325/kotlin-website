fun main() {
    // Exercise1
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)

    println(greenNumbers.count() + redNumbers.count())

    // Exercise2
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")

    // Exercise3
    val number2word = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}