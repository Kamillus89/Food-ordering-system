package recrutation.task.dao;

import recrutation.task.models.Drink;

import java.util.List;

public interface DrinkDAO {

    List<Drink> getAllDrinks();
    Drink getDrinkById(int id);
}
