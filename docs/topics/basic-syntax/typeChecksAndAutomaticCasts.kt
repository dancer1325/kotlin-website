// 1. Checking if it's affirmative
// obj	is val === immutable		-- Because, by default it's val --
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch !!
        //  -> you can make .lenght, assuming that it's already a String
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

// 2. Checking if it's not affirmative
fun getStringLengthOpposite(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}


// 3. Casting is valid also for consecutive expressions to evaluate=
fun getStringLengthCastingDoneForConsecutiveExpressions(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}


fun main() {
    // For 1.
    fun printLength(obj: Any) {
        println("[1.] Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")		// ?:	For null safer
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))


    // For 2.
    fun printLengthOpposite(obj: Any) {
        println("[2.] Getting the length of '$obj'. Result: ${getStringLengthOpposite(obj) ?: "Error: The object is not a string"} ")
    }
    printLengthOpposite("Incomprehensibilities")
    printLengthOpposite(1000)
    printLengthOpposite(listOf(Any()))


    // For 3.
    fun printLengthCastingDoneForConsecutiveExpressions(obj: Any) {
        println("[3.] Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")
    }
    printLengthCastingDoneForConsecutiveExpressions("Incomprehensibilities")
    printLengthCastingDoneForConsecutiveExpressions("")
    printLengthCastingDoneForConsecutiveExpressions(1000)
}