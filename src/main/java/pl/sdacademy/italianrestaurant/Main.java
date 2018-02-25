package pl.sdacademy.italianrestaurant;

import pl.sdacademy.italianrestaurant.staff.Chef;
import pl.sdacademy.italianrestaurant.staff.Kitchen;
import pl.sdacademy.italianrestaurant.staff.Waiter;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        new Thread(new Waiter(kitchen)).start();
        new Thread(new Waiter(kitchen)).start();
        new Thread(new Chef(kitchen)).start();
        new Thread(new Chef(kitchen)).start();
        new Thread(new Chef(kitchen)).start();
        System.out.println("PREGO restaurant is working!");
    }
}
