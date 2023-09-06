fun main() {

    // Read only set
    // 1. Type inference
    val readOnlyShapeMap = mapOf(1 to 100,2 to 200,3 to 100)
    println("readOnlyShapeMap ${readOnlyShapeMap::class.simpleName}")
    println("readOnlyShapeMap ${readOnlyShapeMap::class.java.typeName}")
    // 2. Specifying the type
    val readOnlyShapeSpecifiedMap: Map<Int, Int> = mapOf(1 to 100,2 to 200,3 to 100)
    println("readOnlyShapeSpecifiedMap ${readOnlyShapeSpecifiedMap::class.simpleName}")
    println("readOnlyShapeSpecifiedMap ${readOnlyShapeSpecifiedMap::class.java.typeName}")
    // Invalid to make write operations, since it's read-only
    //readOnlyShapeMap.put(6,2)
    //readOnlyShapeMap.remove(2)


    // Mutable set
    val mutableShapeMap = mutableMapOf(1 to 100,2 to 200,3 to 100)
    println("mutableShapeMap ${mutableShapeMap::class.simpleName}")
    println("mutableShapeMap ${mutableShapeMap::class.java.typeName}")
    println("mutableShapeMap $mutableShapeMap")
    println("mutableShapeMap.count() ${mutableShapeMap.count()}")
    // mutableShapeMap.put(4 to 400)			// Not valid syntax
    mutableShapeMap.put(4, 400)
    // 1. Functions
    println("mutableShapeMap $mutableShapeMap")
    // 1.1 count()
    println("mutableShapeMap.count() ${mutableShapeMap.count()}")
    // 1.2 [] -- indexed access operator --
    println("mutableShapeMap[2] ${mutableShapeMap[2]}")				// Indexed access operator
    println("mutableShapeMap[3] ${mutableShapeMap[3]}")
    // 1.3 remove()
    mutableShapeMap.remove(6)			// If the key doesn't exist -> No error
    mutableShapeMap.remove(2)
    println("mutableShapeMap $mutableShapeMap")
    // 1.4 contains()
    println("mutableShapeMap.contains(1) ${mutableShapeMap.contains(1)}")
    println("mutableShapeMap.keys ${mutableShapeMap.keys}")			// It's a property
    println("mutableShapeMap.values ${mutableShapeMap.values}")		// It's a property
    // 2. Operators
    // 2.1 in
    println("3 in mutableShapeMap.keys ${3 in mutableShapeMap.keys}")
    println("100 in mutableShapeMap.values ${100 in mutableShapeMap.values}")
    println("Another line")


    // Mutable -> Read-only set
    val mutableCastedToReadOnlyShapeMap: Map<Int, Int> = mutableShapeMap
    // mutableCastedToReadOnlyShapeMap.add(5 to 400)    Since it's casted, no-read-only extension functions can be applied to
}