package recrutation.task.controllers;

import recrutation.task.views.View;

public class Controller {

    static {
        View view = new View();
        view.getWellcomeMessage();
    }

    View view = new View();

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
                    System.out.println("User choose drinks");
                    break;
                case "Q":
                    finish = true;
                    break;
                default:
                    view.pleaseProvideCorrectOption();
            }
        } while (!finish);
    }
}
