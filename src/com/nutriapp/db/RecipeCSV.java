package com.nutriapp.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.nutriapp.Recipe;

/*
 * This class is responsible for saving and loading recipes to a CSV file.
 */
public class RecipeCSV {
    private static final String FILENAME = "data/recipes.csv";

    public static void saveRecipes(List<Recipe> recipes) {
        try (FileWriter fw = new FileWriter(FILENAME, true); // Pass 'true' to enable append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Recipe recipe : recipes) {
                out.println(recipe.getName() + "," + recipe.getCaloriesPerUnit() + "," + recipe.getFatPerUnit() + "," + recipe.getProteinPerUnit() + "," + recipe.getFiberPerUnit() + "," + recipe.getCarbsPerUnit() + "," + recipe.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    // listRecipes() returns a list of recipes as an array of strings, one recipe per string
    public static String[] listRecipes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            List<String> recipes = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                recipes.add(line);
            }
            return recipes.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}