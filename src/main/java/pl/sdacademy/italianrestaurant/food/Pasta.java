package pl.sdacademy.italianrestaurant.food;

import java.util.HashSet;
import java.util.Set;

public class Pasta implements Food {
    private final PastaType pastaType;
    private final String sauce;
    private final Set<String> spices;
    private final boolean parmesan;

    public PastaType getPastaType() {
        return pastaType;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getSpices() {
        return new HashSet<>(spices);
    }

    public boolean isParmesan() {
        return parmesan;
    }

    private Pasta(Builder pastaBuilder) {
        pastaType = pastaBuilder.pastaType;
        sauce = pastaBuilder.sauce;
        spices = pastaBuilder.spices;
        parmesan = pastaBuilder.parmesan;
    }

    public static Builder builder(PastaType type) {
        return new Builder(type);
    }

    public static class Builder {
        private PastaType pastaType;
        private String sauce;
        private Set<String> spices;
        private boolean parmesan;

        private Builder(PastaType type) {
            pastaType = type;
            spices = new HashSet<>();
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder spices(String spice) {
            spices.add(spice);
            return this;
        }

        public Builder spices(Set<String> spices) {
            this.spices.addAll(spices);
            return this;
        }

        public Builder parmesan(boolean parmesan) {
            this.parmesan = parmesan;
            return this;
        }

        public Pasta build() {
            return new Pasta(this);
        }
    }
}
