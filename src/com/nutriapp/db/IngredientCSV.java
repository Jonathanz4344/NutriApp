package com.nutriapp.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.nutriapp.Ingredient;

/*
 * This class is responsible for saving and loading ingredients to a CSV file.
 */
public class IngredientCSV {
    private static final String FILENAME = "data/ingredients.csv";

    public static void saveIngredients(List<Ingredient> ingredients) {
        try (FileWriter fw = new FileWriter(FILENAME, true); // Pass 'true' to enable append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Ingredient ingredient : ingredients) {
                out.println(ingredient.getName() + "," + ingredient.getCaloriesPerUnit() + "," + ingredient.getFatPerUnit() + "," + ingredient.getProteinPerUnit() + "," + ingredient.getFiberPerUnit() + "," + ingredient.getCarbsPerUnit() + "," + ingredient.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // listIngredients() returns a list of ingredients as an array of strings, one ingredient per string
    public static String[] listIngredients() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            List<String> ingredients = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                ingredients.add(line);
            }
            return ingredients.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}