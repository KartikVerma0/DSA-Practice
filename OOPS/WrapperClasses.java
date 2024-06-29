package OOPS;

/*
 * In Java, wrapper classes are a part of the java.lang package 
 * and are used to convert primitive data types into objects. 
 * Each primitive data type (such as int, char, boolean, etc.) 
 * has a corresponding wrapper class (such as Integer, Character, Boolean, etc.).
 */

/*
 * Java provides automatic conversion between primitives and their corresponding wrapper classes, 
 * known as autoboxing and unboxing.

 *   Autoboxing: Converting a primitive to a wrapper object.
 *   Unboxing: Converting a wrapper object back to a primitive.
 */

public class WrapperClasses {
    public static void main(String[] args) {

        // Autoboxing: Primitive to Wrapper
        int primitiveInt = 5;
        Integer wrappedInt = primitiveInt; // Equivalent to Integer.valueOf(primitiveInt)

        // Unboxing: Wrapper to Primitive
        Integer wrappedInteger = new Integer(10);
        int primitiveInteger = wrappedInteger; // Equivalent to wrappedInteger.intValue()

        System.out.println("Wrapped Int: " + wrappedInt); // Output: Wrapped Int: 5
        System.out.println("Primitive Integer: " + primitiveInteger); // Output: Primitive Integer: 10
    }
}