import kotlin.math.PI
import kotlin.math.pow

// Exercise 1
fun circleArea(radius: Int): Double {
//	return (PI*(radius^2))  // Wrong format for power

//	1. Without pow
//  return PI*radius*radius
//  2. With pow
    return PI*(radius.toDouble().pow(2))		// Required to cast to Double the base
}

// Exercise 2
fun circleAreaExercise2(radius: Int) = PI*(radius.toDouble().pow(2))

// Exercise 3
fun intervalInSecondsExercise3(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds

fun main() {
    println("circleArea ${circleArea(2)}")
    println("circleAreaExercise2 ${circleAreaExercise2(2)}")
    println("intervalInSecondsExercise3 ${intervalInSecondsExercise3(0, 1, 25)}")

    // Exercise 4
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = actions.map{action: String -> "$prefix/$id/action"}		// Lambda expression -> {}, not with ()
    println(urls)

    // Exercise 5
    // action		It's a function type without arguments, and returning nothing === void/Unit
    fun repeatN(n: Int, action: () -> Unit) {
        for (i in 1..n) {
            action()
        }
    }

    // Via trailing lambda
    repeat(5){ println("Hello")}
    // Common calling
    repeat(5, {println("Hello")})
}