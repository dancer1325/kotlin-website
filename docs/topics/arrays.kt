fun main() {
    // 1. arrays are fixed size -> if you try to add an element -> new array is created
    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
    val originalReference = riversArray.hashCode()
    println("Original Array: ${riversArray.joinToString()}")
    println("Original Array Reference: ${originalReference}")

    // += ->  creates a new riversArray / copies over the original elements & adds the element
    riversArray += "Mississippi"
    val newReference = riversArray.hashCode()
    println("New Array: ${riversArray.joinToString()}")
    println("New Array Reference: ${newReference}")
    println("originalReference $originalReference vs newReference $newReference are different ${originalReference!=newReference}")

    // 2. == compare references
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(1, 2, 3)
    println("array1 == array2   ${array1 == array2}") // false, because it compares references

    // 3. contentEquals     if you want to compare array's content
    println("array1.contentEquals(array2)   ${array1.contentEquals(array2)}")       // true, because it compares the content

    // 4. ways to create arrays
    // 4.1 functions
    // 4.1.1 arrayOf()
    val simpleArray = arrayOf(1, 2, 3)
    println(simpleArray.joinToString())
    // 4.1.2 arrayOfNulls()
    val nullArray: Array<Int?> = arrayOfNulls(3)        // ALL items are null
    println(nullArray.joinToString())
    // 4.1.3 emptyArray()
    val exampleArray = emptyArray<String>()
    println(exampleArray.joinToString())        // NOTHING is displayed, because it's empty
    // 4.2 Array constructor
    val initArray = Array<Int>(3) { 0 } // Array<Int>(size) { lambdaExpressionWithTIntReturned }
    println(initArray.joinToString())
    val asc = Array(5) { i -> (i * i).toString() } // Array(size) { lambdaExpressionWithTypeInferredReturned }
    asc.forEach { println(it) }

    // 5. ways to specify the type of array
    // 5.1 | left-hand of the assigment
    var leftHandSideTypeArray: Array<String> = emptyArray()
    // 5.2 | right-hand of the assigment
    var rightHandSideTypeArray = emptyArray<String>()
}