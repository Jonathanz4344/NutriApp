package com.nutriapp;

import java.util.List;
import java.util.ArrayList;

/*
 * This class is responsible for creating a meal with low carbs.
 * LowCarbMeal option that allows to create a low carb meal and calculate the total
 * calories for the meal
 */
class LowCarbMealStrategy implements MealStrategy {
    public int calculateTotalCalories(List<Food> foods, User user) {
        int totalCalories = 0;
        int totalCarbs = 0;

        for (Food food : foods) {
            totalCalories += food.calculateTotalCalories(user);
            totalCarbs += food.getCarbsPerUnit();
        }

        // subtract half the carbs from the total calories
        totalCalories -= totalCarbs / 2;

        return totalCalories;
    }

    @Override
    public List<Food> createMeal(User user) {
        List<Food> lowCarbFoods = new ArrayList<>();

        // for (Food food : user.getFoods()) {
        //     if (food.getCarbsPerUnit() < 10) { // only add foods with less than 10 carbs per unit
        //         lowCarbFoods.add(food);
        //     }
        // }

        return lowCarbFoods;
    }

}
