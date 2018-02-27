package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.*;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Chef implements OrderObserver, Runnable {

    private FoodFactory foodFactory;
    private Kitchen kitchen;
    private boolean thereIsNewOrder = false;
    private boolean isWorking = false;

    public Chef(Kitchen kitchen) {
        this.kitchen = kitchen;
        kitchen.register(this);
        foodFactory = new FoodFactory();
    }

    @Override
    public void run() {
        isWorking = true;
        while (isWorking) {
            if (thereIsNewOrder) {
                Optional<Order> order = kitchen.takeOrder();
                thereIsNewOrder = false;
                if (order.isPresent()) {
                    List<Food> foods = prepareOrderedFood(order.get());
                    for (Food food : foods) {
                        kitchen.addFood(food);
                    }
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // nothing to do
            }
        }
    }

    public List<Food> prepareOrderedFood(Order order) {
        List<Food> preparedFood = new ArrayList<>();
        List<OrderElement> elements = order.getElements();
        for (OrderElement element : elements) {
            preparedFood.add(foodFactory.prepareFood(element));
        }
        return preparedFood;
    }

    public List<Food> prepareOrderedFoodOneLiner(Order order) {
        return order.getElements().stream()
                .map(foodFactory::prepareFood)
                .collect(Collectors.toList());
    }

    @Override
    public void update() {
        thereIsNewOrder = true;
    }
}
