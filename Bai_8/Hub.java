package Homework.Homework_week4.Bai_8;
import java.util.Scanner;
public abstract class Hub {
    public String id,name;
    public boolean status;
    public Hub(String id,String name,boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public void turnOffAll() {
        status = false;
        System.out.println(name + "turn off");
    }
    public void turnOnALL() {
        status = true;
        System.out.println(name + "turn on");
    }
}
interface adjustable {
    void upper();
    void lower();
}
interface wifiConnectable {
    void connectToWifi();
}
class Light extends Hub implements adjustable {
    public Light(String id,String name,boolean status) {
        super(id,name,status);
    }
    public void upper() {
        System.out.println(name + "Uppering light ...");
    }
    public void lower() {
        System.out.println(name + "Lowering light ...");
    }
}
class AC extends Hub implements wifiConnectable{
    public AC(String id,String name,boolean status) {
        super(id,name,status);
    }
    public void connectToWifi() {
        System.out.println(name +"Connecting to neareast Wifi ...");
    }
}
class speaker extends Hub implements adjustable,wifiConnectable {
    public speaker(String id,String name,boolean status) {
        super(id,name,status);
    }
    public void upper() {
        System.out.println(name + "Uppering sounds ...");
    }
    public void lower() {
        System.out.println(name + "Lowering sounds ...");
    }
    public void connectToWifi() {
        System.out.println(name + "Connecting to neareast Wifi ...");
    }
}
class curtain extends Hub {
    public curtain(String id,String name,boolean status) {
        super(id,name,status);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        Hub[] arr = new Hub[x];
        for(int i=0; i<x; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            if(type.equals("L")) {
                arr[i] = new Light(id,name,false);
            } else if(type.equals("AC")) {
                arr[i] = new AC(id,name,false);
            } else if(type.equals("S")) {
                arr[i] = new speaker(id,name,false);
            } else {
                arr[i] = new curtain(id, name, false);
            }
        }
        System.out.println("Turn On All Devices:");
        for(Hub a : arr) {
            a.turnOnALL();
        }
        System.out.println();
        System.out.println("Setup Wifi:");;
        for(Hub a: arr) {
            if(a instanceof wifiConnectable) {
                ((wifiConnectable) a).connectToWifi();
            }
        }
    }
}
