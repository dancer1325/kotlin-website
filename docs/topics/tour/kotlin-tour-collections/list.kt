fun main() {

    // Read only list
    // 1. Type inference
    val readOnlyShapesInferType = listOf("triangle", "square", "circle")
    println("readOnlyShapesInferType ${readOnlyShapesInferType::class.simpleName}")
    println("readOnlyShapesInferType ${readOnlyShapesInferType::class.java.typeName}")
    // 2. Declaring type
    val readOnlyShapesDeclaredType: List<String> = listOf("triangle", "square", "circle")
    println("readOnlyShapesDeclaredType ${readOnlyShapesDeclaredType::class.simpleName}")
    println("readOnlyShapesDeclaredType ${readOnlyShapesDeclaredType::class.java.typeName}")
    // 3. Functions
    // 3.1 [] -- indexed access operator --
    println("readOnlyShapesInferType[0] ${readOnlyShapesInferType[0]}")
    // 3.2 .first()
    println("readOnlyShapesInferType.first() ${readOnlyShapesInferType.first()}")
    // 3.3 .last()
    println("readOnlyShapesInferType.last() ${readOnlyShapesInferType.last()}")
    // 3.4 .count()
    println("readOnlyShapesInferType.count() ${readOnlyShapesInferType.count()}")
    // 3.5 .remove()				Impossible because it's read-only
    //println("readOnlyShapesInferType.remove('pentagon') ${readOnlyShapesInferType.remove("pentagon")}")
    // 4. Operators
    // 4.1 in
    println("circle in readOnlyShapesInferType ${"circle" in readOnlyShapesInferType}")
    println("star in readOnlyShapesInferType ${"star" in readOnlyShapesInferType}")


    // Mutable list
    // 1. Type inference
    val mutableShapesInferType = mutableListOf("triangle", "square", "circle")
    println("mutableShapesInferType ${mutableShapesInferType::class.simpleName}")
    println("mutableShapesInferType ${mutableShapesInferType::class.java.typeName}")
    // 2. Although it's declared as var, you can add entries
    mutableShapesInferType.add("rectangle")
    println("mutableShapesInferType.get(3) ${mutableShapesInferType.get(3)}")
    // 3. Declaring type
    val mutableShapesDeclaredType: MutableList<String> = mutableListOf("triangle", "square", "circle")
    println("mutableShapesDeclaredType ${mutableShapesDeclaredType::class.simpleName}")
    println("mutableShapesDeclaredType ${mutableShapesDeclaredType::class.java.typeName}")
    // 4. Read-only view of mutable list
    val mutableShapesCastedToReadOnly: List<String> = mutableShapesDeclaredType
    //mutableShapesCastedToReadOnly.add("star") // Compilation error
    // 5. Functions
    // 5.1 .remove()                    -- It can be applied now, because it's mutable --
    println("mutableShapesDeclaredType.count() ${mutableShapesDeclaredType.count()}")
    println("mutableShapesDeclaredType.remove('square') ${mutableShapesDeclaredType.remove("square")}")
    println("mutableShapesDeclaredType.count() ${mutableShapesDeclaredType.count()}")
    // Trying to remove an item which doesn't exist
    println("mutableShapesDeclaredType.remove('pentagon') ${mutableShapesDeclaredType.remove("pentagon")}")
    println("mutableShapesDeclaredType.count() ${mutableShapesDeclaredType.count()}")
}