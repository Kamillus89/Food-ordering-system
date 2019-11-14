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

    @Override
    public String toString() {
        return id +" \t"+ name + " \t"+ price.toString() + " pln";
    }
}
