package com.nutriapp;

/* 
 * This interface is responsible for updating the stock of an ingredient.
 * Takes in Ingredient to updateStock when ingredient is low in stock
 */
public interface StockObserver {
    void updateStock(Ingredient ingredient);
}
