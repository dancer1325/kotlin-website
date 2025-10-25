import kotlin.math.absoluteValue

fun main() {
    val dates = listOf(1 to "January", 13 to "May", 22 to "September", 23 to "December")

    // 1. destructure declarations
    dates.forEach { (day, month) ->
        println("${day.ordinal()} of $month")
    }

    // 3. scope functions (apply, also, let, takeIf)
    Window(300, 200, true).also(::showWindow)
    createEmptyWindow()
        .apply {
            width = 300
            height = 200
            isVisible = true
        }.also { w ->
            showWindow(w)
        }

    // 4. safe calls & null handling
    issueById["13456"]
        ?.takeIf { it.status == Status.FIXED }
        ?.let {
            println("We've fixed this: $it")
        }
}

// 2. Extension function
fun Int.ordinal() = this.absoluteValue.let { iAbs ->
    val suffix = if (iAbs % 100 in 11..13) "th" else
        // 5. smart cast & when expressions
        when (iAbs % 10) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    "$this$suffix"
}

data class Window(var width: Int, var height: Int, var isVisible: Boolean)

fun createEmptyWindow() = Window(0, 0, false)

fun showWindow(window: Window) {
    println("Showing $window")
}

enum class Status { OPEN, FIXED, IN_PROGRESS }

data class Issue(val status: Status)

val issueById = mutableMapOf(
    "13456" to Issue(Status.FIXED)
)
