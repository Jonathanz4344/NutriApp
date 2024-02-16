package com.nutriapp.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.nutriapp.Day;
import com.nutriapp.User;


/*
 * This class is responsible for saving and loading user history to a CSV file.
 */
public class UserHistoryCSV {
    private final String FILENAME = "user_history.csv";


    public void saveUserHistory(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            for (Day day : user.getHistory()) {
                String line = user.getName() + "," + day.getDate() + "," + day.getWeight() + "," + day.getMeals() + "," + day.getWorkouts() + "\n" ;
                writer.write(line);
            }
            System.out.println("User history saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving user history.");
        }
    }

    // public void loadUserHistory(User user) {
    //     try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] parts = line.split(",");
    //             if (parts[0].equals(user.getName())) {
    //                 Day day = new Day(parts[1]);
    //                 day.setCaloriesConsumed(Integer.parseInt(parts[2]));
    //                 day.setCaloriesBurned(Integer.parseInt(parts[3]));
    //                 user.getHistory().addDay(day);
    //             }
    //         }
    //         System.out.println("User history loaded successfully.");
    //     } catch (IOException e) {
    //         System.out.println("Error loading user history.");
    //     }
    // }
}