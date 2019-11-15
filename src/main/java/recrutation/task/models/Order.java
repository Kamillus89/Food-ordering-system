package recrutation.task.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> orderedItems;

    public Order() {
        this.orderedItems = new ArrayList<>();
    }

    public List<Item> getOrderedItems() {
        return orderedItems;
    }

    public void addItemToOrder(Item item) {
        orderedItems.add(item);
    }

    public BigDecimal getTotalCost(List<Item> orderedItems) {
        return orderedItems.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
