package com.nutriapp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nutriapp.db.IngredientCSV;
import com.nutriapp.db.MealCSV;
import com.nutriapp.db.RecipeCSV;
import com.nutriapp.db.UserCSV;

public class NutriAppUI {
    private Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    private User currentUser = null;

    public void initialPrompt() {
        System.out.println("Welcome to NutriApp!");
        System.out.println("1. Create a new user");
        System.out.println("2. Log in as a user");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            displayUserForm(0);
        } else if (choice == 2) {
            loginUser();
        } else {
            System.out.println("Invalid choice, please try again.");
            initialPrompt();
        }
    }

    public void loginUser() {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        User user = UserCSV.getUser(username);
        if (user == null) {
            System.out.println("User not found. Please try again.");
            loginUser();
        } else {
            currentUser = user;
            System.out.println("Logged in as: " + currentUser.getName());
            checkDailyLogin();
        }
    }

    private void checkDailyLogin() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);
        System.out.print("Have you logged in today? (yes/no): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("no")) {
            System.out.print("Enter your current weight (lbs): ");
            double weight = scanner.nextDouble();
            // Save the user's weight to the database
            // Uncomment the line below and replace with the appropriate code when ready
            // saveWeightToDatabase(currentUser, weight);
        }
        displayMenu();
    }

    public void displayMenu() {
        System.out.println("\nDATABASE CONTROLS:");
        System.out.println("1. User");
        System.out.println("2. Meals");
        System.out.println("3. Recipes");
        System.out.println("4. Ingredients");
        System.out.println("5. History");
        System.out.println("\nNUTRIAPP FUNCTIONS:");
        System.out.println("6. Log meal");
        System.out.println("7. Log exercise");
        System.out.println("8. Show calories consumed vs daily goal");
        System.out.println("9. Show current time and date");
        System.out.println("10. Exit");
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void handleUserSubmenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nUser Submenu:");
            System.out.println("1. Create a new user");
            System.out.println("2. Update a user");
            System.out.println("3. Remove a user");
            System.out.println("4. List all users");
            System.out.println("5. Go back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayUserForm(0); // Create a new user
                    break;
                case 2:
                    displayUserForm(1); // Update a user
                    break;
                case 3:
                    displayUserForm(2); // Remove a user
                    break;
                case 4:
                    // UserCSV.listUsers() returns an array of strings, so we need to print each element
                    String[] users = UserCSV.listUsers();
                    for (String user : users) {
                        System.out.println(user);
                    }
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void handleMealsSubmenu() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\nMeals Submenu:");
            System.out.println("1. Create a new meal");
            System.out.println("2. List all meals");
            System.out.println("3. Go back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayMealForm();
                    break;
                case 2:
                    // MealCSV.listMeals() returns an array of strings, so we need to print each element
                    String[] meals = MealCSV.listMeals();
                    for (String meal : meals) {
                        System.out.println(meal);
                    }
                    break;
                case 3:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void handleIngredientsSubmenu() {
        System.out.println("Ingredient Submenu");
        System.out.println("1. Create an ingredient");
        System.out.println("2. View all ingredients");
        System.out.println("3. Go back to main menu");
    
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                displayIngredientForm();
                break;
            case 2:
                // IngredientCSV.listIngredients() returns an array of strings, so we need to print each element
                String[] ingredients = IngredientCSV.listIngredients();
                for (String ingredient : ingredients) {
                    System.out.println(ingredient);
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    
    public Ingredient displayIngredientForm() {
        System.out.println("Create a new ingredient");
        System.out.print("Enter the name of the ingredient: ");
        String name = scanner.next();
        System.out.print("Enter the calories per unit: ");
        int caloriesPerUnit = scanner.nextInt();
        System.out.print("Enter the fat per unit: ");
        int fatPerUnit = scanner.nextInt();
        System.out.print("Enter the protein per unit: ");
        int proteinPerUnit = scanner.nextInt();
        System.out.print("Enter the fiber per unit: ");
        int fiberPerUnit = scanner.nextInt();
        System.out.print("Enter the carbs per unit: ");
        int carbsPerUnit = scanner.nextInt();
        System.out.print("Enter the stock amount: ");
        int stock = scanner.nextInt();
    
        Ingredient ingredient = new Ingredient(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit, stock);
    
        // Save the ingredient data to the database
        // create a list of ingredients
        // add the ingredient to the list
        // save the list to the database
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        IngredientCSV.saveIngredients(ingredients);

        return ingredient;
    }
    
    public void handleRecipesSubmenu() {
        System.out.println("Recipe Submenu");
        System.out.println("1. Create a recipe");
        System.out.println("2. View all recipes");
        System.out.println("3. Go back to main menu");
    
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                displayRecipeForm();
                break;
            case 2:
                // RecipeCSV.listRecipes();  returns an array of strings, so we need to print each element
                String[] recipes = RecipeCSV.listRecipes();
                for (String recipe : recipes) {
                    System.out.println(recipe);
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    
    public void displayRecipeForm() {
        System.out.println("Create a new recipe");
        System.out.print("Enter the name of the recipe: ");
        String name = scanner.next();
        System.out.print("Enter the calories per unit: ");
        int caloriesPerUnit = scanner.nextInt();
        System.out.print("Enter the fat per unit: ");
        int fatPerUnit = scanner.nextInt();
        System.out.print("Enter the protein per unit: ");
        int proteinPerUnit = scanner.nextInt();
        System.out.print("Enter the fiber per unit: ");
        int fiberPerUnit = scanner.nextInt();
        System.out.print("Enter the carbs per unit: ");
        int carbsPerUnit = scanner.nextInt();
    
        Recipe recipe = new Recipe(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
        
        // Adding ingredients to the recipe
        boolean addingIngredients = true;
        while (addingIngredients) {
            System.out.println("Add an ingredient to the recipe:");
            // Call displayIngredientForm() function to create a new ingredient
            // You may need to modify this function to return the created ingredient
            Ingredient ingredient = displayIngredientForm();
            recipe.addIngredient(ingredient);
    
            System.out.println("Would you like to add another ingredient? (y/n)");
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("n")) {
                addingIngredients = false;
            }
        }
        // make recipe into a list of recipes containing just the recipe
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        RecipeCSV.saveRecipes(recipeList);
    }

    public void logMeal() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nMeal Submenu:");
            System.out.println("1. Enter date to get records of meal(s) consumed");
            System.out.println("2. Meal consumed today");;
            System.out.println("3. Go back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayUserForm(0); // Date
                    break;
                case 2:
                    displayUserForm(1); // Meal consumed
                    break;
                case 3:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void logExercise() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nExercise Submenu:");
            System.out.println("1. Total time spent");
            System.out.println("2. Track current exercise time");;
            System.out.println("3. Go back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayUserForm(0); // Total time spent
                    break;
                case 2:
                    displayUserForm(1); // Track current exercise time
                    break;
                case 3:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }

    public void displayCalories() {
        // Placeholder for displaying calories consumed vs daily goal
        System.out.println("Calories consumed: 1200");
        System.out.println("Daily calorie goal: 2000");
    }

    public void displayCurrentTimeAndDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);
    }

    public void displayUserForm(int action) {
        if (action == 0) {
            System.out.println("Create a new user");
        } else if (action == 1) {
            System.out.println("Update a user");
        } else if (action == 2) {
            System.out.println("Remove a user");
        }
    
        System.out.print("Enter the user's name: ");
        String name = scanner.next();
    
        if (action == 2) {
            // Remove the user with the given name
            try {
                UserCSV.removeUser(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    
        System.out.print("Enter the user's height (feet): ");
        double height = scanner.nextDouble();
        System.out.print("Enter the user's weight (lbs): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter the user's birthdate (YYYY-MM-DD): ");
        String birthdate = scanner.next();
        System.out.print("Enter the user's goal weight (lbs): ");
        int goalWeight = scanner.nextInt();
    
        LocalDate birthDate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        User user = new User(name, height, weight, birthDate, goalWeight);
    
        try {
            if (action == 0) {
                // Create the user
                UserCSV.createUser(user);
                users.add(user);
            } else if (action == 1) {
                UserCSV.updateUser(user, user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void displayMealForm() {
        System.out.println("Add a new meal");
        System.out.print("Enter the name of the meal: ");
        String mealName = scanner.next();
        // System.out.print("Enter the ingredients (comma separated): ");
        // String ingredients = scanner.next();

        // List<String> ingredientList = new ArrayList<>();
        // for (String ingredient : ingredients.split(",")) {
        //     ingredientList.add(ingredient);
        // }

        System.out.print("Enter the calories: ");
        int calories = scanner.nextInt();
        System.out.print("Enter the fat: ");
        int fat = scanner.nextInt();
        System.out.print("Enter the protein: ");
        int protein = scanner.nextInt();
        System.out.print("Enter the fiber: ");
        int fiber = scanner.nextInt();
        System.out.print("Enter the carbs: ");
        int carbs = scanner.nextInt();
        // Save the meal data to the database
        Meal meal = new Meal(mealName, calories, fat, protein, fiber, carbs);
        MealCSV.saveMeal(meal);

    }

    public void displayWorkoutForm() {
        System.out.println("Add a new workout");
        System.out.print("Enter the duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.print("Enter the intensity: ");
        String intensity = scanner.next();
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String date = scanner.next();
        // Save the workout data to the databases
    }

    public void displayHoursLeftInDay() {
        User user = null;
        System.out.print("Which user would you like to modify the length of day for? ");
        String name = scanner.next();
        for(User u : users) {
            if(u.getName().equals(name)) {
                user = u;
            }
        } if(user == null) {
            System.out.println("Error: User not found!\n");
            return;
        }

        System.out.println("The modified day length should be the remaining time in the day.");
        System.out.print("Enter the duration (in seconds): ");
        double time = scanner.nextDouble();

        // Save the workout duration to the database
        User updatedUser = new User(user.getName(), user.getHeight(), user.getWeight(),user.getBirthdate(), user.getGoalWeight());
        UserCSV.updateUser(updatedUser, user);
    }

    

    public void displayUserHistory() {
        System.out.println("User history");
        
        // Retrieve the user history from the database and display it on the console
            File file = new File("users.csv");
            if (!file.exists()) {
                System.out.println("Error: No user file found!\n");
                return;
            }
    
            List<String[]> history = new ArrayList<>();

            try {
                System.out.print("Enter the name of the user whose history you would like to view: ");
                String name = scanner.next();
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] tokens = line.split(",");
                    if (tokens[0].equals(name)) {
                        history.add(tokens);
                    }
                }

                scanner.close();

                if(history.size() == 0) {
                    System.out.println("Error: User not found!\n");
                    return;
                }

                System.out.println("\nUser history:");
                for (String[] tokens : history) {
                    System.out.println("Username: " + tokens[0] + "\nHeight: " + tokens[1] + "\nWeight: " + tokens[2] + "\nBirthdate: " + tokens[3] + "\nCurrent Goal: " + tokens[4] + "Length of Day (seconds): " + tokens[5] + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
    }

    public void displayExitMessage() {
        System.out.println("Goodbye!");
    }
}