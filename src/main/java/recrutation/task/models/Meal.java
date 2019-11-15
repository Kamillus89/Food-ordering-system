package recrutation.task.models;

import java.math.BigDecimal;

public class Meal implements Item {

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

    public Integer getId() {
        return id;
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

    @Override
    public String toString() {
        return id + " \t" + name + " \t\t" + price + " pln";
    }
}
