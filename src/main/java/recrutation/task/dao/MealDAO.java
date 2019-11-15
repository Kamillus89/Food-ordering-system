package recrutation.task.dao;

import recrutation.task.models.Cuisine;
import recrutation.task.models.Meal;

import java.util.List;
import java.util.Set;

public interface MealDAO {

    List<Meal> getAllMeals();

    Meal getMealById(int id);

    List<Meal> getMealsByCuisine(Cuisine cuisine);

    Set<Cuisine> getAvailableCuisines();
}
