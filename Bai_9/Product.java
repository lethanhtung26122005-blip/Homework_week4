package Homework.Homework_week4.Bai_9;
import java.util.*;
abstract class Product {
    protected String id;
    protected String name;
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getInfo();
}
class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }
    @Override
    public String getInfo() {
        return name + " - " + expiryDate;
    }
}
class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }
    @Override
    public String getInfo() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}
// Kho tổng quát: chỉ chấp nhận các kiểu kế thừa Product
class Warehouse<T extends Product> {
    private List<T> products = new ArrayList<>();
    public void importProduct(T product) {
        products.add(product);
    }
    public void exportProduct(String id) {
        products.removeIf(p -> p.id.equals(id));
    }
    public void inventory() {
        for (T p : products) {
            System.out.println(p.getInfo());
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronic> electronicWarehouse = new Warehouse<>();
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            String id = data[1];
            String name = data[2];
            if (type.equals("F")) {
                String expiryDate = data[3];
                foodWarehouse.importProduct(
                    new Food(id, name, expiryDate)
                );
            } else if (type.equals("E")) {
                int warrantyMonths = Integer.parseInt(data[3]);
                electronicWarehouse.importProduct(
                    new Electronic(id, name, warrantyMonths)
                );
            }
        }
        System.out.println("Kho Thực phẩm:");
        foodWarehouse.inventory();

        System.out.println();
        System.out.println("Kho Điện tử:");
        electronicWarehouse.inventory();
        sc.close();
    }
}

