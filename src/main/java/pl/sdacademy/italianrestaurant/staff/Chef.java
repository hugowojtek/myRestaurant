package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.*;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Chef {

    private FoodFactory foodFactory;

    public Chef() {
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
}
