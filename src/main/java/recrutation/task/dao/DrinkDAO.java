package recrutation.task.dao;

import recrutation.task.models.Drink;

import java.util.List;

public interface DrinkDAO {

    public List<Drink> getAllDrinks();
    public Drink getDrinkById(int id);
    public void updateDrink();
}
