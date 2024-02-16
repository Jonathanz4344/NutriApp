package com.nutriapp;

/*
 * This class is responsible for running the NutriApp.
 */ 
public class Nutriapp {
    private NutriAppUI ui = new NutriAppUI();

    public static void main(String[] args) {
        Nutriapp app = new Nutriapp();
        app.run();
    }

    public void run() {
        ui.initialPrompt();
        int choice = 0;
        while (choice != 10) {
            ui.displayMenu();
            choice = ui.getUserChoice();
            switch (choice) {
                case 1:
                    ui.handleUserSubmenu();
                    break;
                case 2:
                    ui.handleMealsSubmenu();
                    break;
                case 3:
                    ui.handleRecipesSubmenu();
                    break;
                case 4:
                    ui.handleIngredientsSubmenu();
                    break;
                case 5:
                    ui.displayUserHistory();
                    break;
                case 6:
                    ui.logMeal();
                    break;
                case 7:
                    ui.logExercise();
                    break;
                case 8:
                    ui.displayCalories();
                    break;
                case 9:
                    ui.displayCurrentTimeAndDate();
                    break;
                case 10:
                    ui.displayExitMessage();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
