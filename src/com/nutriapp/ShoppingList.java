package com.nutriapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


/*
 * This class is responsible for storing a user's shopping list.
 * Observers that updates shoppinglist whenever ingredient is low in stock
 */
public class ShoppingList implements StockObserver {
    private List<Ingredient> ingredients;
    private List<Recipe> recipes;
    private List<StockObserver> stockObservers;

    public ShoppingList(List<Ingredient> ingredients, List<Recipe> recipes) {
        this.ingredients = ingredients;
        this.recipes = recipes;
        this.stockObservers = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredient.addObserver(this);
        }
    }

    public void addStockObserver(StockObserver observer) {
        this.stockObservers.add(observer);
    }

    public void removeStockObserver(StockObserver observer) {
        this.stockObservers.remove(observer);
    }

    @Override
    public void updateStock(Ingredient ingredient) {
        if (ingredient.getStock() == 0) {
            System.out.println("Need to buy " + ingredient.getName());
        }
        for (StockObserver observer : this.stockObservers) {
            observer.updateStock(ingredient);
        }
    }

    public List<Ingredient> getLowStockIngredients() {
        List<Ingredient> lowStockIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getStock() < ingredient.getLowStockThreshold()) {
                lowStockIngredients.add(ingredient);
            }
        }
        return lowStockIngredients;
    }

    public List<Ingredient> getOutOfStockIngredients() {
        List<Ingredient> outOfStockIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getStock() == 0) {
                outOfStockIngredients.add(ingredient);
            }
        }
        return outOfStockIngredients;
    }

}