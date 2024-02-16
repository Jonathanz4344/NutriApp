package com.nutriapp;

/*
 * This interface is responsible for updating a shopping list.
 * takes in Shoppinglist to update it.
 */
public interface ShoppingListObserver {
    void update(ShoppingList shoppingList);
}