package Homework.Homework_week4.Bai_7;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class Student  {
    public String id, name;
    public double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}
class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    List<Student> students = new ArrayList<>();
    for(int i=0; i<x; i++) {
        String id = sc.next();
        String name = sc.next();
        double gpa = sc.nextDouble();
        students.add(new Student(id, name, gpa));
    }
    students.removeIf(student -> student.getGpa()<5.0);
    System.out.println("After removing GPA < 5.0:");   
    students.forEach(s -> System.out.println(s));      

    System.out.println();                              

    students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));  
    System.out.println("After sorting by name:");      
    students.forEach(s -> System.out.println(s));     
    }
}