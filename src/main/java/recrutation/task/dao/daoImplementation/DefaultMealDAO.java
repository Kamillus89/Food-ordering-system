package recrutation.task.dao.daoImplementation;

import recrutation.task.dao.MealDAO;
import recrutation.task.models.Cuisine;
import recrutation.task.models.Meal;

import java.math.BigDecimal;
import java.util.*;

public class DefaultMealDAO implements MealDAO {

    private Map<Integer,Meal> mealsMap;

    public DefaultMealDAO() {
        this.mealsMap = new TreeMap<>();
        {
            Meal bigos = new Meal(1, "Bigos", new BigDecimal("18.50"), Cuisine.POLISH);
            Meal pierogi = new Meal(2, "Pierogi", new BigDecimal("12.50"), Cuisine.POLISH);
            Meal kotletSchobowy = new Meal(3, "Kotlet schabowy", new BigDecimal("33.00"), Cuisine.POLISH);

            mealsMap.put(1, bigos);
            mealsMap.put(2, pierogi);
            mealsMap.put(3, kotletSchobowy);

            Meal tortilla = new Meal(11, "Tortilla", new BigDecimal("13.50"), Cuisine.MEXICAN);
            Meal buritto = new Meal(12, "Buritto", new BigDecimal("23.50"), Cuisine.MEXICAN);
            Meal tostadas = new Meal(13, "Tostadas", new BigDecimal("28.70"), Cuisine.MEXICAN);

            mealsMap.put(11, tortilla);
            mealsMap.put(12, buritto);
            mealsMap.put(13, tostadas);

            Meal pizza = new Meal(21, "Pizza", new BigDecimal("12.50"), Cuisine.ITALIAN);
            Meal spaghetti = new Meal(22, "Spaghetti", new BigDecimal("19.90"), Cuisine.ITALIAN);
            Meal lasagna = new Meal(23, "Lasagna", new BigDecimal("30.20"), Cuisine.ITALIAN);

            mealsMap.put(21, pizza);
            mealsMap.put(22, spaghetti);
            mealsMap.put(23, lasagna);
        }

    }

    @Override
    public List<Meal> getAllMeals() {
        return new ArrayList<>(mealsMap.values());
    }

    @Override
    public Meal getMealById(int id) {
        return mealsMap.get(id);
    }

    @Override
    public List<Meal> getMealsByCuisine(Cuisine cuisine) {
        List<Meal> mealsFromSelectedCuisine = new ArrayList<>();

        for (Meal meal: mealsMap.values()) {
            if (meal.getCuisine().equals(cuisine)) {
                mealsFromSelectedCuisine.add(meal);
            }
        }

        return mealsFromSelectedCuisine;
    }

    @Override
    public Set<Cuisine> getAvailableCuisines(){
        Set<Cuisine> cuisines = new HashSet<>();
        for (Meal meal: mealsMap.values()) {
            cuisines.add(meal.getCuisine());
        }
        return cuisines;
    }
}
