package Homework.Homework_week4.Bai_5;

public class Pair<K,V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K newkey) {
        key = newkey;
    }
    public void setValue(V newValue) {
        value = newValue;
    }
    @Override 
    public String toString() {
        return key + " - " + value;
    }
}
class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Tuoi",20);
        Pair<String, String> p2 = new Pair<>("Ma SV","SV001");
        Pair<Integer, Double> p3 = new Pair<>(105,21.5);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
