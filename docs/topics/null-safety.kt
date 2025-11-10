fun rootCausesNPEHappen() {
    // 1.   throw NullPointerException()
    //throw NullPointerException()              // uncomment to see the error

    // 2.   !!
    val a: String? = null
    //a!!.toString()                            // throw KotlinNullPointerException         --  uncomment to see the error

    // 3.   TODO:
}

fun elvisOperator(b: String?) {
    // 1. -- via --     if else
    val lengthViaIfElse: Int = if (b != null) b.length else -1
    println("lengthViaIfElse: $lengthViaIfElse")
    // 2. -- via --     ?:
    val lengthViaElvisOperator: Int = b?.length ?: -1           //  == PREVIOUS if else
    println("lengthViaElvisOperator: $lengthViaElvisOperator")
    // 3. -- via --     ?:      / right hand side can be any Kotlin's expression
    val lengthViaElvisOperator2: Int = b?.length ?: return null
    val lengthViaElvisOperator2: Int = b?.length ?: throw IllegalArgumentException("b is null")
}


fun main(args: Array<String>) {
    rootCausesNPEHappen()
    elvisOperator(args.firstOrNull())
}
