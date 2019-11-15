package recrutation.task.views;

import recrutation.task.models.Cuisine;
import recrutation.task.models.Drink;
import recrutation.task.models.Meal;
import recrutation.task.models.Order;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {

    private Scanner scan = new Scanner(System.in);

    public void getWelcomeMessage() {
        System.out.println("Welcome in Food ordering app, how can I help you?\n");
    }


    public void showMainMenu() {
        System.out.println("What would you like to order: " +
                "\n   [D] Drinks " +
                "\n   [M] Meals " +
                "\n   [S] Show my order " +
                "\n\n Press [Q] to Quit");
    }

    public String getUserChoice() {
        return scan.nextLine();
    }

    public void pleaseProvideCorrectOption() {
        clearScreen();
        System.out.println("Please press right key from menu\n");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showDrinksMenu(List<Drink> drinks) {
        clearScreen();
        System.out.println("Drinks menu: ");
        drinks.forEach(System.out::println);
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
        orderedDrinks.forEach(System.out::println);
        System.out.println("______________________");
        System.out.println("Total cost = " + order.getTotalCost(orderedDrinks) + " pln\n");
    }

    public void showCusines(Set<Cuisine> cuisines) {
        clearScreen();
        System.out.println("Which cuisine would you prefer? :");
        int i = 1;
        for (Cuisine cuisine : cuisines) {
            System.out.println(i + " " + cuisine);
            i++;
        }

        System.out.println("\n Press 0 to back to main menu");
    }

    public void showChosenCuisineMenu(List<Meal> meals, Cuisine cuisine) {
        clearScreen();
        System.out.println(cuisine + " menu: ");
        for (Meal meal: meals) {
            if (meal.getCuisine().equals(cuisine)) {
                System.out.println(meal);
            }
        }
        System.out.println("\nPlease select meal by number or press 0 to go back to main menu");
    }
}
