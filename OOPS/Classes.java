package OOPS;

public class Classes {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        // new keyword dynamically allocates memory and
        // returns a reference of it.

        // references are stored in stack
        // objects are stored in heap memory

        // reference variables are created at compile time
        // objects are created at runtime

        // just declaration
        Student student1;

        // initialization
        student1 = new Student();

        student1.rNo = 1;
        student1.name = "Kunal Kushwaha";
        student1.marks = 90.0f;

        students[0] = student1;

        // both declaration and initialization
        Student student2 = new Student(2, "Kartik Verma", 99.0f);
        students[1] = student2;

        Student student3 = new Student(student2);
        students[2] = student3;
    }
}

class Student {
    int rNo;
    String name;
    float marks;

    // In Java, constructors do have a name, but they do not have a return type.

    // This is a default (no-argument) constructor. It doesn't perform any specific
    // actions and is provided here to allow the creation of Student objects without
    // passing any arguments.
    Student() {
        // "this" keyword can also be used to call other
        // constructor
        this(0, "random", 100.0f);
    }

    // This is a parameterized constructor.
    // It allows the creation of a Student
    // object with specific values for rNo,
    // name, and marks.
    Student(int rNo, String name, float marks) {
        // The this keyword is used to differentiate between the instance variables and
        // the parameters with the same names

        // In Java, the this keyword is a reference to the current object—the instance
        // of the class in which it is used. It is primarily used to eliminate the
        // confusion between class attributes and parameters with the same name, and it
        // also serves other purposes.
        this.rNo = rNo;
        this.name = name;
        this.marks = marks;
    }

    // copy constructor
    // takes existing object and uses its attributes to create
    // new object
    Student(Student stu) {
        this.rNo = stu.rNo;
        this.name = stu.name;
        this.marks = stu.marks;
    }
}
