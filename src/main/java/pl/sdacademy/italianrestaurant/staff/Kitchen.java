package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.supply.Order;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Kitchen {
    private List<OrderObserver> orderObservers;
    private List<FoodObserver> foodObservers;
    private Queue<Order> orders;
    private Queue<Food> foods;

    public Kitchen() {
        orderObservers = new ArrayList<>();
        orders = new LinkedBlockingDeque<>();
        this.foodObservers = new ArrayList<>();
        this.foods = new LinkedBlockingDeque<>();
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

        return Optional.ofNullable(foods.poll());
    }

    public void addFood(Food food) {

        this.foods.add(food);

        for (FoodObserver foodObserver : foodObservers){
            foodObserver.update();
        }

    }
}
