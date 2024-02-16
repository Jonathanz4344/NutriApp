package com.nutriapp;

import java.util.List;

/*
 * This interface is responsible for creating a meal.
 * Meal Strategy that takes in list of food which user creates a meal
 */
public interface MealStrategy {
    List<Food> createMeal(User user);
}
