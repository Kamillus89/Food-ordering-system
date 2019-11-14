package recrutation.task.controllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import recrutation.task.dao.DrinkDAO;
import recrutation.task.dao.daoImplementation.DrinkDAOImpl;
import recrutation.task.models.Drink;
import recrutation.task.models.Order;
import recrutation.task.views.View;

import java.util.List;

public class Controller {

    static {
        View view = new View();
        view.getWellcomeMessage();
    }

    View view = new View();
    Order order = new Order();
    DrinkDAO drinkDAO = new DrinkDAOImpl();
    List<Drink> drinks = drinkDAO.getAllDrinks();

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

                Drink choosenDrink = drinks.get(usersChoice - 1);
                System.out.println("You choose: " + choosenDrink);

                askUserIfHeWantsIceCubes(choosenDrink);
                askUserIfHeWantsLemon(choosenDrink);
                order.addItemToOrder(choosenDrink);
            }
            if (usersChoice > drinks.size()) view.chooseRightNumber();
            if (usersChoice == 0) isActive = false;

        } while (isActive);
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
