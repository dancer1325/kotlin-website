fun main() {

    // Read only set
    // 1. Type inference
    val readOnlyShapeSet = setOf("triangle", "square", "circle")
    println("readOnlyShapeSet ${readOnlyShapeSet::class.simpleName}")
    println("readOnlyShapeSet ${readOnlyShapeSet::class.java.typeName}")
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
    mutableShapeSet.add("star")
    println("mutableShapeSet $mutableShapeSet")
    // Functions
    // 1. count()
    println("mutableShapeSet.count() ${mutableShapeSet.count()}")
    // Operators
    // 1. in
    println("'star' in mutableShapeSet ${"star" in mutableShapeSet}")


    // Mutable -> Read-only set
    val mutableCastedToReadOnlyShapeSet: Set<String> = mutableShapeSet
    // mutableCastedToReadOnlyShapeSet.add("polygon")    Since it's casted, no-read-only extension functions can be applied to
}