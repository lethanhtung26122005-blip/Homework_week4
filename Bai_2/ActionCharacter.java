package Homework.Homework_week4.Bai_2;

interface CanFly{
    void fly();
}
interface CanSwim {
    void swim();
}
interface CanFight {
    void fight();
}

public class ActionCharacter {
    public void fight() {
        System.out.println("Dam boc ...");
    }
}
class Hero extends ActionCharacter implements CanFly,CanSwim,CanFight {
    public void fly(){
        System.out.println("Dang bay ...");
    }
    public void swim() {
        System.out.println("Dang boi ...");
    }
}
class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        CanSwim s = (CanSwim) hero;
        s.swim();

        CanFight f = (CanFight) hero;
        f.fight();
    }
}
