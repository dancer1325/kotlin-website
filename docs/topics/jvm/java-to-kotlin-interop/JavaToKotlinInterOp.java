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

        // 3. package-level function
        new org.example.Util();
        org.example.PackageLevelFunctionsKt.getTime();    // package-level function -> static
        // TODO:

        // 4. static methods
        // 4.1 @JvmStatic | companion object's function
        C.callStatic();     // mark it with @JvmStatic -> static function works
        //C.callNonStatic();  // error: NOT a static method
        C.Companion.callStatic();    // via Companion == object -> valid
        C.Companion.callNonStatic(); // via Companion == object -> valid
        // 4.2 @JvmStatic | named object's function
        Obj.callStatic();       // mark it with @JvmStatic -> static function works
        //Obj.callNonStatic();  // error: NOT a static method
        Obj.INSTANCE.callNonStatic(); // via instance -> valid
        Obj.INSTANCE.callStatic();    // via instance -> valid
        // 4.3 @JvmStatic | interface's companion object's function
        ChatBot.greet("Alfred");    // mark it with @JvmStatic -> static function
        // 4.4. @JvmStatic | properties of
        // 4.4.1 companion object
        //System.out.println(AnotherClass.anotherName); // Error, private
        System.out.println(AnotherClass.getAnotherName());
        // 4.4.2 object
        //System.out.println(AnotherObject.name);       // Error, private
        System.out.println(AnotherObject.getName());
    }
}
