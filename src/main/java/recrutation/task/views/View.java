package recrutation.task.views;

import recrutation.task.models.Drink;
import recrutation.task.models.Order;

import java.util.List;
import java.util.Scanner;

public class View {

    public void getWellcomeMessage() {
        System.out.println("Wellcome in Food ordering app, how can I help you?\n");
    }


    public void showMainMenu() {
        System.out.println("What would you like to order: " +
                "\n   [D] Drinks " +
                "\n   [M] Meals " +
                "\n   [L] Lunch (main course + dessert) " +
                "\n   [S] Show my order " +
                "\n\n Press [Q] to Quit");
    }

    public String getUserChoice() {
        Scanner scan = new Scanner(System.in);
        String usersChoice = scan.nextLine();
        return usersChoice;
    }

    public void pleaseProvideCorrectOption() {
        clearScreen();
        System.out.println("Please press rigth key from menu\n");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showDrinksMenu(List<Drink> drinks) {
        clearScreen();
        System.out.println("Drinks menu: ");
        drinks.forEach(drink -> System.out.println(drink));
        System.out.println("\nPlease select drink by number or press 0 to go back to main menu");
    }

    public void chooseRightNumber() {
        System.out.println("Please provide right drink number");
    }

    public String askUserForIceCubes() {
        System.out.println("Would you like some ice cubes to drink? [y/n]");
        return getUserChoice();
    }

    public String askUserForLemon() {
        System.out.println("Would you like some lemon to drink? [y/n]");
        return getUserChoice();
    }

    public void showOrder(Order order) {
        clearScreen();
        System.out.println("This is your current order: ");
        List<Drink> orderedDrinks = order.getOrderedDrinks();
        orderedDrinks.forEach(orderedDrink -> System.out.println(orderedDrink));
        System.out.println("______________________");
        System.out.println("Total cost = " + order.getTotalCost(orderedDrinks) + " pln\n");
    }
}
