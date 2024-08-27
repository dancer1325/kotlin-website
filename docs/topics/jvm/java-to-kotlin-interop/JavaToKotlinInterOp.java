public class JavaToKotlinInterOp {
    public static void main(String[] args) {
        // Creating an instance of the Kotlin class
        Person person = new Person("Alice", 30);

        // Accessing the properties and methods
        String greeting = person.greet();

        // Printing the result
        System.out.println(greeting);

        // Directly accessing the fields (Java syntax)
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
