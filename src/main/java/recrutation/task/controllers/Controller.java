package recrutation.task.controllers;

import recrutation.task.dao.DrinkDAO;
import recrutation.task.dao.daoImplementation.DrinkDAOImpl;
import recrutation.task.models.Drink;
import recrutation.task.models.Order;
import recrutation.task.views.View;

import java.util.List;

public class Controller {

    static {
        View view = new View();
        view.getWelcomeMessage();
    }

    private View view = new View();
    private Order order = new Order();
    private DrinkDAO drinkDAO = new DrinkDAOImpl();
    private List<Drink> drinks = drinkDAO.getAllDrinks();

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

    private void presentDrinksMenu(List<Drink> drinks) {
        boolean isActive = true;
        int usersChoice;
        do {
            view.showDrinksMenu(drinks);
            usersChoice = Integer.parseInt(view.getUserChoice());
            if (userSelectionIsInMenu(drinks, usersChoice)) {

                Drink chosenDrink = drinks.get(usersChoice - 1);

                System.out.println("You choose: " + chosenDrink); // to delete!

                Drink newDrink = createNewSelectedDrink(chosenDrink);
                askUserIfHeWantsIceCubes(newDrink);
                askUserIfHeWantsLemon(newDrink);

                order.addItemToOrder(newDrink);
            }
            if (usersChoice > drinks.size()) view.chooseRightNumber();
            if (usersChoice == 0) isActive = false;

        } while (isActive);
    }

    private Drink createNewSelectedDrink(Drink choosenDrink) {
        return new Drink(choosenDrink.getName(),choosenDrink.getPrice());
    }

    private void askUserIfHeWantsLemon(Drink choosenDrink) {
        boolean isActive = true;
        String userChoice;
        while (isActive) {
            userChoice = view.askUserForLemon();
            if (userChoice.equalsIgnoreCase("y")) {
                choosenDrink.setLemon(true);
                isActive = false;
            } else {
                isActive = false;
            }
        }
    }

    private void askUserIfHeWantsIceCubes(Drink choosenDrink) {
        boolean isActive = true;
        String userChoice;
        while (isActive) {
            userChoice = view.askUserForIceCubes();
            if (userChoice.equalsIgnoreCase("y")) {
                choosenDrink.setIceCubes(true);
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
