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
        return name + " - " + warrantyMonths + " thang bao hanh";
    }
}
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
        int n = sc.nextInt();
        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronic> electronicWarehouse = new Warehouse<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String expiryDate = sc.next();

                foodWarehouse.importProduct(
                    new Food(id, name, expiryDate)
                );

            } else if (type.equals("E")) {
                int warrantyMonths = sc.nextInt();

                electronicWarehouse.importProduct(
                    new Electronic(id, name, warrantyMonths)
                );
            }
        }
        System.out.println("Kho thuc pham:");
        foodWarehouse.inventory();
        System.out.println();
        System.out.println("Kho dien tu:");
        electronicWarehouse.inventory();
        sc.close();
    }
}
