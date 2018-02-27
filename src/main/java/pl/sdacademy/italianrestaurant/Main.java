package pl.sdacademy.italianrestaurant;

import pl.sdacademy.italianrestaurant.staff.Chef;
import pl.sdacademy.italianrestaurant.staff.Kitchen;
import pl.sdacademy.italianrestaurant.staff.Waiter;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Kitchen kitchen = new Kitchen();
      /*
        Thread[] threadsWaiters = new Thread[2];
        Thread[] threadsChef = new Thread[3];
        for (int i=0;i<2;i++ ){
            threadsWaiters[i] =  new Thread(new Waiter(kitchen));
            threadsWaiters[i].start();

            //threadsWaiters[i].join();
        }
        for (int i=0;i<3;i++ ){
            threadsChef[i] =  new Thread(new Chef(kitchen));
            threadsChef[i].start();
            //threadsChef[i].join();
        }
        //threadsWaiters[0].join();
        //threadsWaiters[1].join();
        //threadsChef[0].join();
        //threadsChef[1].join();
        //threadsChef[2].join();

        */
        System.out.println("PREGO restaurant is working!");

        Thread t1 = new Thread(new Waiter(kitchen));
                t1.start();
        Thread t2 = new Thread(new Waiter(kitchen));
                t2.start();
        Thread t3 = new Thread(new Chef(kitchen));
                t3.start();
        Thread t4 = new Thread(new Chef(kitchen));
                t4.start();
        Thread t5 = new Thread(new Chef(kitchen));
                t5.start();


    }
}
