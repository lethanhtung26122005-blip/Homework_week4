package Homework.Homework_week4.Bai_10;
import java.util.*;
abstract class MediaItem {
    protected String id;
    protected String name;
    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public abstract String getInfo();
}
class Book extends MediaItem {
    private String author;
    private int pages;
    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }
    @Override
    public String getInfo() {
        return name + " - " + author + " - " + pages;
    }
}
class DVD extends MediaItem {
    private String director;
    private int duration;
    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }
    @Override
    public String getInfo() {
        return name + " - " + director + " - " + duration;
    }
}
class LibrarySection<T extends MediaItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }
    public void removeItem(String id) {
        items.removeIf(item -> item.id.equals(id));
    }
    public void displayItems() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            String id = data[1];
            String name = data[2];
            if (type.equals("B")) {
                String author = data[3];
                int pages = Integer.parseInt(data[4]);
                bookSection.addItem(
                    new Book(id, name, author, pages)
                );
            } else if (type.equals("D")) {
                String director = data[3];
                int duration = Integer.parseInt(data[4]);
                dvdSection.addItem(
                    new DVD(id, name, director, duration)
                );
            }
        }
        System.out.println("Khu vực Sách:");
        bookSection.displayItems();
        System.out.println();
        System.out.println("Khu vực DVD:");
        dvdSection.displayItems();
        sc.close();
    }
}
