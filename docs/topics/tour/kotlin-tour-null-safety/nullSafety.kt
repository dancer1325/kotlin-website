fun main() {
    //                                  -- Nullable types --
    // neverNull has String type
    var neverNull: String = "This can't be null"

    // Throws a compiler error, because `null` is NOT allowed
    //neverNull = null

    // nullable has nullable String type
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    // By default, null values aren't accepted
    var inferredNonNull = "The compiler assumes non-null"

    // Throws a compiler error
    // inferredNonNull = null

    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    println(strLength(neverNull)) // 18
    //println(strLength(nullable))  // Throws a compiler error


    //                                  -- Check for null values --
    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }
    var nullString: String? = null  // Thanks to ?      --> it's null accepted
    println(describeString(nullString))
    // It doesn't throw compiler error, because it's checked if it's null


    //                                  -- Use safe calls --
    // 1. For properties
    fun lengthString(maybeString: String?): Int? = maybeString?.length
    // maybeString		is a nullable type
    // maybeString?.	is a safe call
    var anotherNullStringFirst: String? = null		// nullString	is a nullable type
    println(lengthString(anotherNullStringFirst))
    // 2. For functions
    var anotherNullStringSecond: String? = null	//Nullable type
    println(anotherNullStringSecond?.uppercase())


    //                                  -- Use Elvis operator --
    var anotherNullString: String? = null		// Nullable type
    println(anotherNullString?.length ?: 0)	// ?:		Elvis operator
}