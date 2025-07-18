fun main() {

    // Read only set
    // 1. Type inference
    val readOnlyShapeSet = setOf("triangle", "square", "circle", "circle")
    println("readOnlyShapeSet ${readOnlyShapeSet::class.simpleName}")
    println("readOnlyShapeSet ${readOnlyShapeSet::class.java.typeName}")
    readOnlyShapeSet.forEach{item -> println("${item}")}    // duplicated items are dropped
    // 2. Specifying the type
    val readOnlyShapeSpecifiedSet: Set<String> = setOf("triangle", "square", "circle")
    println("readOnlyShapeSpecifiedSet ${readOnlyShapeSpecifiedSet::class.simpleName}")
    println("readOnlyShapeSpecifiedSet ${readOnlyShapeSpecifiedSet::class.java.typeName}")


    // Mutable set
    val mutableShapeSet = mutableSetOf("triangle", "square", "circle", "circle")
    println("mutableShapeSet ${mutableShapeSet::class.simpleName}")
    println("mutableShapeSet ${mutableShapeSet::class.java.typeName}")
    println("mutableShapeSet $mutableShapeSet")
    println("mutableShapeSet.count() ${mutableShapeSet.count()}")
    // Functions
    // 1. count()
    println("mutableShapeSet.count() ${mutableShapeSet.count()}")
    // 2. add()
    mutableShapeSet.add("star")
    println("mutableShapeSet $mutableShapeSet")
    // 3. remove()
    mutableShapeSet.remove("star")
    println("mutableShapeSet $mutableShapeSet")
    // Operators
    // 1. in
    println("'star' in mutableShapeSet ${"star" in mutableShapeSet}")
    // 2 [] -- indexed access operator --
    //println("mutableShapeSet[0] ${mutableShapeSet[0]}")           NOT allowed, because it's an unordered


    // Mutable -> Read-only set
    val mutableCastedToReadOnlyShapeSet: Set<String> = mutableShapeSet
    // mutableCastedToReadOnlyShapeSet.add("polygon")    Since it's casted, no-read-only extension functions can be applied to
}