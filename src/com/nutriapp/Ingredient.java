package com.nutriapp;

import java.util.List;
import java.util.ArrayList;

/*
 * this class represents an ingredient
 * it is a subclass of Food
 * it has a stock attribute
 * Has an observer that notifies when a stock is low in stock to be added to shoppinglist
 * Allows to remove/add/get an ingredient
 */
public class Ingredient extends Food {
    private int stock;
    private List<StockObserver> observers;
    private double lowStockThreshold;

    public Ingredient(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbsPerUnit, int stock) {
        super(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
        this.stock = stock;
        this.observers = new ArrayList<>();
    }

    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.updateStock(this);
        }
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public double getLowStockThreshold() {
        return lowStockThreshold;
    }

    @Override
    public int calculateTotalCalories(User user) {
        int totalCalories = (int) (caloriesPerUnit * user.getDailyCalorieIntake() / 2000);
        return totalCalories;
    }

    @Override
    public void addIngredient(Food ingredient) {
        throw new UnsupportedOperationException("Cannot add ingredient to an ingredient.");
    }

    @Override
    public void removeIngredient(Food ingredient) {
        throw new UnsupportedOperationException("Cannot remove ingredient from an ingredient.");
    }

    @Override
    public List<Food> getIngredients() {
        throw new UnsupportedOperationException("An ingredient does not have any ingredients.");
    }
}