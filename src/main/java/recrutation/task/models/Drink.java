package recrutation.task.models;

import java.math.BigDecimal;

public class Drink {

    private static int nextrId = 1;

    private int id;
    private String name;
    private BigDecimal price;
    private boolean iceCubes = false;
    private boolean lemon = false;

    public Drink(String name, BigDecimal price) {
        this.id = Drink.nextrId;
        this.name = name;
        this.price = price;
        Drink.nextrId++;
    }

    public int getId() {
        return id;
    }

    public void setIceCubes(boolean iceCubes) {
        this.iceCubes = iceCubes;
    }

    public void setLemon(boolean lemon) {
        this.lemon = lemon;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        if (iceCubes == true && lemon == true) {
            return id + " \t" + name + " with ice cubes and lemon \t" + price.toString() + " pln";
        }
        if (lemon == false && iceCubes == true) {
            return id + " \t" + name + " with ice cubes \t" + price.toString() + " pln";
        }
        if (iceCubes == false && lemon == true) {
            return id + " \t" + name + " with lemon \t" + price.toString() + " pln";
        }
        return id + " \t" + name + " \t" + price.toString() + " pln";
    }
}
