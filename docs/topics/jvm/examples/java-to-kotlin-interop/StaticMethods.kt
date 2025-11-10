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

// 3. @JvmStatic | interface's companion object's function
interface ChatBot {
    companion object {
        @JvmStatic fun greet(username: String) {
            println("Hello, $username")
        }
    }
}

// 4. @JvmStatic | properties of
// 4.1 companion object
class AnotherClass {
    companion object {
        @JvmStatic var anotherName: String = "ClassAlfred"
    }
}
// 4.2 object
object AnotherObject {
    @JvmStatic var name: String = "ObjectAlfred"
}
