package recrutation.task.models;

import java.math.BigDecimal;

public class Meal implements Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Cuisine cuisine;

    public Meal(Integer id, String name, BigDecimal price, Cuisine cuisine) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    public Meal(String name, BigDecimal price, Cuisine cuisine) {
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }
}
