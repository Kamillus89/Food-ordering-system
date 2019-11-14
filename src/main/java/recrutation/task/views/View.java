package recrutation.task.views;

import recrutation.task.models.Drink;

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
        drinks.forEach( drink -> System.out.println(drink));
        System.out.println("\nPlease select drink by number or press 0 to go back to main menu");
    }

    public void choseRigthNumber() {
        System.out.println("Please provide right drink number");
    }
}
