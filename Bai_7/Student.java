package Homework.Homework_week4.Bai_7;
import java.util.Scanner;
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
}
class Main {
    pubic static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    Student[] students = new Student[x];
    for(int i=0; i<x; i++) {
        String id = sc.next();
        String name = sc.next();
        double gpa = sc.nextDouble();
        students[i] = new Student(id, name, gpa);
    }
    students.removeIf(student -> student.getGpa()<5.0);
    }
}