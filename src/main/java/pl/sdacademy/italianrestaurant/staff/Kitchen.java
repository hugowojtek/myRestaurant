package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.supply.Order;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Kitchen {
    private List<OrderObserver> orderObservers;
    private Queue<Order> orders;

    public Kitchen() {
        orderObservers = new ArrayList<>();
        orders = new LinkedBlockingDeque<>();
    }

    public void register(OrderObserver observer) {
        orderObservers.add(observer);
    }

    public void unregister(OrderObserver observer) {
        orderObservers.remove(observer);
    }

    public void addOrder(Order order) {
        orders.add(order);
        for (OrderObserver orderObserver : orderObservers) {
            orderObserver.update();
        }
    }

    public Optional<Order> takeOrder() {
        return Optional.ofNullable(orders.poll());
    }
}
