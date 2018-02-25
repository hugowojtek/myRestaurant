package pl.sdacademy.italianrestaurant.food;

import pl.sdacademy.italianrestaurant.supply.OrderElement;

import java.util.Set;

public class FoodFactory {

    public Food prepareFood(OrderElement orderedElement) {
        String orderType = orderedElement.getElementType();
        switch (orderType) {
            case "pizza" :
                return createPizza(orderedElement);
            case "pasta" :
                return createPasta(orderedElement);
            default:
                throw new IllegalArgumentException("I do not know how to prepare " + orderType);
        }
    }

    private Food createPizza(OrderElement orderedElement) {
        String dough = orderedElement.getSpecifics().get("dough").iterator().next();
        String sauce = orderedElement.getSpecifics().get("sauce").iterator().next();
        Set<String> toppings = orderedElement.getSpecifics().get("topping");
        Pizza.Builder pizzaBuilder = Pizza.builder(Dough.valueOf(dough.toUpperCase()));
        pizzaBuilder.sauce(sauce);
        toppings.forEach(pizzaBuilder::topping);
        return pizzaBuilder.build();
    }

    private Food createPasta(OrderElement orderedElement) {
        String pastaType = orderedElement.getSpecifics()
                .get("pastaType").iterator().next();
        Pasta.Builder pastaBuilder = Pasta.builder(PastaType.valueOf(pastaType.toUpperCase()));
        // ustawiam reszte skladników
        return pastaBuilder.build();
    }
}
