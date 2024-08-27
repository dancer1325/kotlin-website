// 1. @JvmStatic | companion object's function
class C {
    companion object {
        @JvmStatic fun callStatic() {}
        fun callNonStatic() {}  // THIS one is NOT marked with @JvmStatic
    }
}

// 2. @JvmStatic | named object's function
object Obj {
    @JvmStatic fun callStatic() {}
    fun callNonStatic() {}      // THIS one is NOT marked with @JvmStatic
}
