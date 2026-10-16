package Homework.Homework_week4.Bai_6;

public class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static <T extends Comparable<T>> void sort (T[] array) {
        for(int i=0; i<array.length-1; i++) {
            for(int j=0; j<array.length-i-1; j++) {
                if(array[j].compareTo(array[j+1])>0) {
                    swap(array,j,j+1);
                }
            }
        }
    }
}
class Student implements Comparable<Student> {
    public String id, name;
    public double gpa;
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa,other.gpa);
    }
}
class Main {
    public static void main(String[] args) {
        Integer[] arr = {5,1,3,2};
        ArrayUtils.sort(arr);
        for(Integer x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        String[] s = {"Java", "C++", "Python"};
        ArrayUtils.sort(s);
        for(String y : s) {
            System.out.print(y + " ");
        }
        System.out.println();

        Student[] list = new Student [3];
        list[0] = new Student("001","Nguyen Quang Minh",3.8);
        list[1] = new Student("002","Nguyen Viet Quang",2.7);
        list[2] = new Student("003","Le Thanh Tung",3.4);
        ArrayUtils.sort(list);
        for(Student k : list) {
            System.out.println(k.id + " " + k.name + " " + k.gpa);
        }
    }   
}
