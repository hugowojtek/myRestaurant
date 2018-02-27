package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.supply.Order;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Kitchen {
    private List<OrderObserver> orderObservers;
    private List<FoodObserver> foodObservers;
    private Queue<Order> orders;

    public Kitchen() {
        orderObservers = new ArrayList<>();
        this.foodObservers = new ArrayList<>();
        orders = new LinkedBlockingDeque<>();
    }

    public void register(OrderObserver observer) {
        orderObservers.add(observer);
    }

    public void unregister(OrderObserver observer) {
        orderObservers.remove(observer);
    }

    public void registerFO (FoodObserver foodObserver) {this.foodObservers.add(foodObserver);}

    public void addOrder(Order order) {
        orders.add(order);
        for (OrderObserver orderObserver : orderObservers) {
            orderObserver.update();
        }
    }
    
    

    public Optional<Order> takeOrder() {
        return Optional.ofNullable(orders.poll());
    }

    public Optional<Food> takeFood() {
        return null;
    }

    public void addFood(Food food) {

    }
}
