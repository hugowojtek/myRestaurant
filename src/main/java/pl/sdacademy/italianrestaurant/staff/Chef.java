package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.*;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Chef implements OrderObserver {

    private FoodFactory foodFactory;
    private Kitchen kitchen;

    public Chef(Kitchen kitchen) {
        this.kitchen = kitchen;
        kitchen.register(this);
        foodFactory = new FoodFactory();
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
        Optional<Order> order = kitchen.takeOrder();
        if (order.isPresent()) {
            List<Food> foods = prepareOrderedFood(order.get());
            for (Food food : foods) {
                kitchen.addFood(food);
            }
        }
    }
}
