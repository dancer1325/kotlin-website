public class JavaToKotlinInterOp {
    public static void main(String[] args) {
        // 1. Creating an instance of the Kotlin class
        Person person = new Person("Alice", 30);
        // Accessing the properties and methods
        String greeting = person.greet();
        // Printing the result
        System.out.println(greeting);
        // Directly accessing the fields (Java syntax)
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // 2. static fields
        // 2.1 static field's visibility -- via @JvmField -- == property's visibility
        var key1 = new Key(2);
        var key2 = new Key(4);
        Key.COMPARATOR.compare(key1, key2);     // possible to invoke / NO problems
        // 2.2 static field's visibility -- via lateinit -- == property setter's visibility
        // TODO: Comprehend it
        Singleton.provider = new Provider(); // public static non-final field in Singleton class
    }
}
