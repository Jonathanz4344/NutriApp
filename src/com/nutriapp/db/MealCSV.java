package com.nutriapp.db;

import com.nutriapp.Meal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/* 
 * This class is responsible for saving and deleting meals to a CSV file.
 * it implements the MealDAO interface.
 */
public class MealCSV {
    private static String filePath = "data/meals.csv";

    public MealCSV(String filePath) {
        MealCSV.filePath = filePath;
    }

    public static void saveMeal(Meal meal) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            writer.println(meal.getName() + "," + meal.getCaloriesPerUnit() + "," + meal.getFatPerUnit() + ","
                    + meal.getProteinPerUnit() + "," + meal.getFiberPerUnit() + "," + meal.getCarbsPerUnit());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMeal(Meal meal) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("data/temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = meal.getName();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // function that returns a list of meals as array of strings, one meal per string
    public static String[] listMeals() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> meals = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                meals.add(line);
            }
            return meals.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}