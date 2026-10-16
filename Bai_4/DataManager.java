package Homework.Homework_week4.Bai_4;

interface IData {
void show(); // Mặc định là public abstract
}
public class DataManager implements IData {
// Cố tình KHÔNG ghi public
public void show() { 
System.out.println("Show Data");
}
}
class Main {
    public static void main(String[] args) {
        DataManager a = new DataManager();
        ((IData)a).show();
    }
}
