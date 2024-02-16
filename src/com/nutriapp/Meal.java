package com.nutriapp;

import java.util.ArrayList;
import java.util.List;


/*
 * This class represents a meal.
 * A meal is a collection of ingredients.
 * A meal has a name, calories, fat, protein, fiber, and carbs per unit.
 * Allow to add ingredient, remove ingredient for a meal
 */
public class Meal extends Food {
    private List<Food> ingredients;

    public Meal(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbsPerUnit) {
        super(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
        this.ingredients = new ArrayList<>();
    }

    public int getStock() {
        return 0;
    }

    public void setStock(int stock) {
        throw new UnsupportedOperationException("Cannot set stock for a meal.");
    }

    public int calculateTotalCalories(User user) {
        int totalCalories = 0;
        for (Food ingredient : ingredients) {
            totalCalories += ingredient.calculateTotalCalories(user);
        }
        return totalCalories;
    }

    public void addIngredient(Food ingredient) {
        if (ingredient instanceof Ingredient) {
            ingredients.add(ingredient);
        } else {
            throw new IllegalArgumentException("Only ingredients can be added to a meal.");
        }
    }

    public void removeIngredient(Food ingredient) {
        ingredients.remove(ingredient);
    }

    public List<Food> getIngredients() {
        return ingredients;
    }
}
