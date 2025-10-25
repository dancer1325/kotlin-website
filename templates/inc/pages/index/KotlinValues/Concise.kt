// vs Java
//      30% fewer lines

data class Book (
    val title: String,
    val year: Int
    // AUTOMATICALLY generate
    //  1. equals(),
    //  2. hashCode(),
    //  3. toString(),
    //  4. copy()
)

// 1!-expression body
fun century(year: Int) = (year - 1) / 100 + 1  // Top-level function,

fun main() {
    // construct a list -- WITHOUT -- `new` keyword
    val books = listOf(
        Book("Don Quixote", 1605),
        Book("The Lord of the Rings", 1955)
    )
    val classics = books.filter { century(it.year) < 20 } // Trailing 1!-argument lambda
    println("Classic books: $classics")                   // AUTOMATICALLY call Book.toString()
}
