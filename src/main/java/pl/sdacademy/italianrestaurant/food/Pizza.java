package pl.sdacademy.italianrestaurant.food;

import java.util.*;

public class Pizza implements Food, Bakeable {

    private final Dough dough;
    private final Size size;
    private final String sauce;
    private final Set<String> toppings;

    private Pizza(Builder builder) {
        this.dough = builder.dough;
        this.size = builder.size;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    public Dough getDough() {
        return dough;
    }

    public Size getSize() {
        return size;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getToppings() {
        return new HashSet<>(toppings);
    }

    public void bake(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", size=" + size +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    public static Builder builder(Dough dough) {
        return new Builder(dough);
    }

    public static class Builder {
        private Dough dough;
        private Size size;
        private String sauce;
        private Set<String> toppings;

        private Builder(Dough dough) {
            this.dough = dough;
            size = Size.MEDIUM;
            this.toppings = new HashSet<>();
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder topping(String... topping) {
            this.toppings.addAll(Arrays.asList(topping));
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }

    }

}










