public abstract class Shape {
    protected int x,y;
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw();
    public abstract void erase();
    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    }
}
class Circle extends Shape {
    public Circle(int x,int y) {
        super(x,y);
    }
    public void draw() {
        System.out.printf("Ve hinh tron tai (%d,%d)\n",x,y);
    }
    public void erase() {
        System.out.printf("Xoa hinh tron tai (%d,%d)\n",x,y);
    }
    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    }
}
class Square extends Shape {
    public Square(int x,int y) {
        super(x,y);
    }
    public void draw() {
        System.out.printf("Ve hinh vuong tai (%d,%d)\n",x,y);
    }
    public void erase() {
        System.out.printf("Xoa hinh vuong tai (%d,%d)\n",x,y);
    }
    public void moveTo(int newX, int newY) {
        erase();
        x = newX;
        y = newY;
        draw();
    }
}
class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}
