import kotlin.random.Random

data class Employee(val name: String, var salary: Int)

class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    // Define a list of possible names
    val names = listOf("John", "Mary", "Ann", "Paul", "Jack", "Elizabeth")
    // Member function
    fun generateEmployee() =
        Employee(names.random(),
            Random.nextInt(from = minSalary, until = maxSalary))
}

fun main() {
    // Exercise 1
    val emp = Employee("Mary", 20)
    println("emp without adjustment - $emp")		// .toString() is called automatically
    emp.salary += 10
    println("emp with salary adjustment - $emp")	// .toString() is called automatically

    // Exercise 2
    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}