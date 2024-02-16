package com.nutriapp;

import java.util.List;

import java.util.ArrayList;

/*
 * This class is responsible for creating a meal with high protein.
 * Class takes in a list of foods and the user that is taking the food.
 * Method to createMeal that takes in a user that allows user to create a high protein meal
 */
class HighProteinMealStrategy implements MealStrategy {
    public int calculateTotalCalories(List<Food> foods, User user) {
        int totalCalories = 0;
        int totalProtein = 0;

        for (Food food : foods) {
            totalCalories += food.calculateTotalCalories(user);
            totalProtein += food.getProteinPerUnit();
        }

        // add twice the protein to the total calories
        totalCalories += totalProtein * 2;

        return totalCalories;
    }

    @Override
    public List<Food> createMeal(User user) {
    List<Food> highProteinFoods = new ArrayList<>();

    for (Food food : user.getFoods()) {
        if (food.getProteinPerUnit() > 20) { // only add foods with more than 20 protein per unit
            highProteinFoods.add(food);
        }
    }

    return highProteinFoods;
}
}