package recrutation.task.dao.daoImplementation;

import recrutation.task.dao.DrinkDAO;
import recrutation.task.models.Drink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DrinkDAOImpl implements DrinkDAO {

    private Map<Integer, Drink> drinksMap;

    public DrinkDAOImpl() {
        this.drinksMap = new TreeMap<>();
        {
            Drink orangeJuice = new Drink("Orange juice", new BigDecimal("10.33"));
            Drink appleJuice = new Drink("Apple juice", new BigDecimal("7.50"));
            Drink lemonade = new Drink("Lemonade", new BigDecimal("5.25"));

            drinksMap.put(orangeJuice.getId(), orangeJuice);
            drinksMap.put(appleJuice.getId(), appleJuice);
            drinksMap.put(lemonade.getId(), lemonade);
        }
    }

    @Override
    public List<Drink> getAllDrinks() {
        return new ArrayList<>(drinksMap.values());
    }

    @Override
    public Drink getDrinkById(int id) {
        return drinksMap.get(id);
    }

}
