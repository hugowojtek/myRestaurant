package pl.sdacademy.italianrestaurant.staff;

import pl.sdacademy.italianrestaurant.food.Dough;
import pl.sdacademy.italianrestaurant.food.Food;
import pl.sdacademy.italianrestaurant.food.Pizza;
import pl.sdacademy.italianrestaurant.food.Size;
import pl.sdacademy.italianrestaurant.supply.Order;
import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Chef {
    public List<Food> prepareOrderedFood(Order order) {
        List<Food> preparedFood = new ArrayList<>();
        for (OrderElement element : order.getElements()) {
            String dough = element.getSpecifics().get("dough").iterator().next();
            String sauce = element.getSpecifics().get("sauce").iterator().next();
            Set<String> toppings = element.getSpecifics().get("topping");
            Pizza.Builder pizzaBuilder = Pizza.builder(Dough.valueOf(dough.toUpperCase()));
            pizzaBuilder.sauce(sauce);
            // 1 sposob
//            for (String topping : toppings) {
//                pizzaBuilder.topping(topping);
//            }
            // 2 krok
//            toppings.forEach(topping -> {
//                pizzaBuilder.topping(topping);
//            });
            // 3 krok
//            toppings.forEach(topping -> pizzaBuilder.topping(topping));
            // 4 krok
            toppings.forEach(pizzaBuilder::topping);
            Pizza pizza = pizzaBuilder.build();
            preparedFood.add(pizza);
        }
        return preparedFood;
    }
}
