package recrutation.task.controllers;

import recrutation.task.dao.DrinkDAO;
import recrutation.task.dao.daoImplementation.DrinkDAOImpl;
import recrutation.task.models.Drink;
import recrutation.task.views.View;

import java.util.List;

public class Controller {

    static {
        View view = new View();
        view.getWellcomeMessage();
    }

    View view = new View();
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
        do{
            view.showDrinksMenu(drinks);
            usersChoice = Integer.parseInt(view.getUserChoice());
            if(usersChoice != 0 && usersChoice <= drinks.size()){
                System.out.println("You choose: " + drinks.get(usersChoice-1));
            }
            if(usersChoice > drinks.size()) view.choseRigthNumber();
            if(usersChoice == 0){
                isActive = false;
            }

        }while (isActive);
    }
}
