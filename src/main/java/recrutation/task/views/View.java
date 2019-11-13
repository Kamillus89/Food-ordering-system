package recrutation.task.views;

import java.util.Scanner;

public class View {

    public void getWellcomeMessage() {
        System.out.println("Wellcome in Food ordering app, how can I help you?\n");
    }


    public void showMainMenu() {
        System.out.println("What would you like to order: " +
                "\n   [D] Drinks " +
                "\n   [M] Meals " +
                "\n   [Q] Quit");
    }

    public String getUserChoice() {
        Scanner scan = new Scanner(System.in);
        String usersChoice = scan.nextLine();
        return usersChoice;
    }

    public void pleaseProvideCorrectOption() {
        System.out.println("Please press rigth key from menu\n");
    }
}
