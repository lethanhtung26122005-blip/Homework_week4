package Homework.Homework_week4.Bai_3;
import java.util.Scanner;
interface IWorkable {
    public void work();
}
public abstract class Employee implements IWorkable {
    public  String id;
    public  String name;
    public double baseSalary;
    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculatePay();
}
class OfficWorker extends Employee {
    public OfficWorker(String id, String name, double baseSalary) {
        super(id,name,baseSalary);
    }
    public double calculatePay() {
        return baseSalary;
    }
    public void work() {
        System.out.println("Soan thao van ban");
    }
}
class Technician extends Employee {
    public float overtimeHours;
    public Technician(String id, String name, double baseSalary,float overtimeHours) {
        super(id,name,baseSalary);
        this.overtimeHours = overtimeHours;
    }
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }
    public void work() {
        System.out.println("Lap dat thiet bi");
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        Employee[] arr = new Employee[x];
        for(int i=0; i<x; i++) {
            String s = sc.next();
            char type = s.charAt(0);
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();
            if(type == 'O') {
                arr[i] = new OfficWorker(id, name, baseSalary);
            } else {
                float overtimeHours = sc.nextFloat();
                arr[i] = new Technician(id, name, baseSalary, overtimeHours);
            }
            sc.nextLine();
        }
        for(Employee a : arr) {
            System.out.println(a.name + "-Pay: " + a.calculatePay());
            a.work();
        }
    }
}
