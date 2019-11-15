package recrutation.task.models;

import java.math.BigDecimal;

public class Drink implements Item {

    private static int nextId = 1;

    private int id;
    private String name;
    private BigDecimal price;
    private boolean withIceCubes = false;
    private boolean withLemon = false;

    public Drink(String name, BigDecimal price) {
        this.id = Drink.nextId;
        this.name = name;
        this.price = price;
        Drink.nextId++;
    }

    public int getId() {
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

    public void setWithIceCubes(boolean withIceCubes) {
        this.withIceCubes = withIceCubes;
    }

    public void setWithLemon(boolean withLemon) {
        this.withLemon = withLemon;
    }

    @Override
    public String toString() {
        if (withIceCubes && withLemon) {
            return id + " \t" + name + " with ice cubes and with Lemon \t" + price.toString() + " pln";
        }
        if (!withLemon && withIceCubes) {
            return id + " \t" + name + " with ice cubes \t" + price.toString() + " pln";
        }
        if (!withIceCubes && withLemon) {
            return id + " \t" + name + " with with Lemon \t" + price.toString() + " pln";
        }
        return id + " \t" + name + " \t" + price.toString() + " pln";
    }
}
