fun declaringProperties() {
    // var
    // 1. Error during compiling time : "initializer is redundant" -- since I initialize and after making any operation -> I adjust it --
    /*var varFirst = 2
    varFirst = 3*/
    // 2. Adjust var property
    var varFirst = 2
    println("varFirst " + varFirst)
    varFirst = 3
    println("varFirst adjusted " + varFirst)

    // val
    val valFirst = 2
    //valFirst = 3                  # Error during compiling time, since I am trying to modify read-only property -- val --
    println("val valFirst" + valFirst)

}

fun main() {
    declaringProperties()
}