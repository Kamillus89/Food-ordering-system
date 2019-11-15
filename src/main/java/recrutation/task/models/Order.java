package recrutation.task.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    List<Item> orderedDrinks;

    public Order() {
        this.orderedDrinks = new ArrayList<>();
    }

    public List<Item> getOrderedItems() {
        return orderedDrinks;
    }

    public void addItemToOrder(Item item) {
        orderedDrinks.add(item);
    }

    public BigDecimal getTotalCost(List<Item> orderedItems) {
        return orderedItems.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
