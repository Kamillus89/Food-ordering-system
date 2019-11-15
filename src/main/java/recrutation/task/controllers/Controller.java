package recrutation.task.controllers;

import recrutation.task.dao.DrinkDAO;
import recrutation.task.dao.MealDAO;
import recrutation.task.dao.daoImplementation.DefaultDrinkDAO;
import recrutation.task.dao.daoImplementation.DefaultMealDAO;
import recrutation.task.models.*;
import recrutation.task.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {

    static {
        View view = new View();
        view.getWelcomeMessage();
    }

    private View view = new View();
    private Order order = new Order();

    private DrinkDAO drinkDAO = new DefaultDrinkDAO();
    private List<Drink> drinks = drinkDAO.getAllDrinks();

    private MealDAO mealDAO = new DefaultMealDAO();
    private List<Meal> meals = mealDAO.getAllMeals();
    private Set<Cuisine> cuisines = mealDAO.getAvailableCuisines();

    public Controller() {
        run();
    }

    public void run() {
        showStartMenu();
    }

    public void showStartMenu() {
        boolean finish = false;
        String usersChoice;
        do {
            view.showMainMenu();
            usersChoice = view.getUserChoice().toUpperCase();
            switch (usersChoice) {
                case "D":
                    presentDrinksMenu(drinks);
                    break;
                case "M":
                    presentCuisine(meals);
                    break;
                case "S":
                    view.showOrder(order);
                    break;
                case "Q":
                    finish = true;
                    break;
                default:
                    view.pleaseProvideCorrectOption();
            }
        } while (!finish);
    }

    private void presentCuisine(List<Meal> meals) {
        boolean isActive = true;
        String usersChoice;
        int numericalChoice = 0;
        do {
            view.showCuisines(cuisines);
            numericalChoice = checkIfUserProvideNumeric(numericalChoice);
            switch (numericalChoice) {
                case 1:
                    presentChosenCuisineMenu(meals,Cuisine.POLISH);
                    break;
                case 2:
                    presentChosenCuisineMenu(meals,Cuisine.ITALIAN);
                    break;
                case 3:
                    presentChosenCuisineMenu(meals,Cuisine.MEXICAN);
                    break;
                case 0:
                    isActive = false;
                    break;
                default:
                    view.pleaseProvideCorrectOption();
            }
        } while (isActive);
    }

    private void presentChosenCuisineMenu(List<Meal> meals, Cuisine cuisine) {
        boolean isActive = true;
        String usersChoice;
        int numericalChoice = 0;

        while (isActive) {
            view.showChosenCuisineMenu(meals, cuisine);
            numericalChoice = checkIfUserProvideNumeric(numericalChoice);

            List<Integer> itemIds = getItemIdFromSelectedCuisine(cuisine);
            if (itemIds.contains(numericalChoice)) {
                addMealToOrder(meals, numericalChoice);
                isActive = false;
            }
            if(numericalChoice == 0) isActive = false;
        }

    }

    private List<Integer> getItemIdFromSelectedCuisine(Cuisine cuisine) {
        List<Integer> itemIds = new ArrayList<>();
        for (Meal meal : mealDAO.getMealsByCuisine(cuisine)) {
            itemIds.add(meal.getId());
        }
        return itemIds;
    }

    private boolean isNumeric(String userChoice) {
        try {
            Integer.parseInt(userChoice);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private void addMealToOrder(List<Meal> meals, int usersChoice) {
        Meal chosenMeal = mealDAO.getMealById(usersChoice);
        view.showSelectMessage(chosenMeal);
        Meal newMeal = createNewSelectedItem(chosenMeal);
        order.addItemToOrder(newMeal);
    }

    private void presentDrinksMenu(List<Drink> drinks) {
        boolean isActive = true;
        String usersChoice;
        int numericalChoice = 0;
        do {
            view.showDrinksMenu(drinks);
            numericalChoice = checkIfUserProvideNumeric(numericalChoice);
            if (userSelectionIsInMenu(drinks, numericalChoice)) {
                Drink chosenDrink = drinks.get(numericalChoice - 1);
                view.showSelectMessage(chosenDrink);
                Drink newDrink = createNewSelectedItem(chosenDrink);
                askUserIfHeWantsIceCubes(newDrink);
                askUserIfHeWantsLemon(newDrink);

                order.addItemToOrder(newDrink);
            }
            if (numericalChoice > drinks.size()) view.chooseRightNumber();
            if (numericalChoice == 0) isActive = false;

        } while (isActive);
    }

    private int checkIfUserProvideNumeric(int numericalChoice) {
        String usersChoice;
        usersChoice = view.getUserChoice();
        if (isNumeric(usersChoice)) {
            numericalChoice = Integer.parseInt(usersChoice);
        } else {
            view.pleaseProvideCorrectOption();
        }
        return numericalChoice;
    }

    private Drink createNewSelectedItem(Drink chosenDrink) {
        return new Drink(chosenDrink.getName(), chosenDrink.getPrice());
    }

    private Meal createNewSelectedItem(Meal chosenMeal) {
        return new Meal(chosenMeal.getId(),chosenMeal.getName(), chosenMeal.getPrice(), chosenMeal.getCuisine());
    }

    private void askUserIfHeWantsLemon(Drink chosenDrink) {
        boolean isActive = true;
        String userChoice;
        while (isActive) {
            userChoice = view.askUserForLemon();
            if (userChoice.equalsIgnoreCase("y")) {
                chosenDrink.setWithLemon(true);
                isActive = false;
            } else {
                isActive = false;
            }
        }
    }

    private void askUserIfHeWantsIceCubes(Drink chosenDrink) {
        boolean isActive = true;
        String userChoice;
        while (isActive) {
            userChoice = view.askUserForIceCubes();
            if (userChoice.equalsIgnoreCase("y")) {
                chosenDrink.setWithIceCubes(true);
                isActive = false;
            } else {
                isActive = false;
            }
        }
    }

    private boolean userSelectionIsInMenu(List<Drink> drinks, int usersChoice) {
        return usersChoice != 0 && usersChoice <= drinks.size();
    }
}
