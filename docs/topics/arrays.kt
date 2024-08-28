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
}