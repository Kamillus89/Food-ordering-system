package recrutation.task.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    List<Drink> orderedDrinks;
//    private BigDecimal totalCost = new BigDecimal(0);

    public Order() {
        this.orderedDrinks = new ArrayList<>();
    }

    public List<Drink> getOrderedDrinks() {
        return orderedDrinks;
    }

    public void addItemToOrder(Drink drink) {
        orderedDrinks.add(drink);
    }

    public BigDecimal getTotalCost(List<Drink> orderedDrinks) {
        return orderedDrinks.stream()
                .map(drink -> drink.getPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
