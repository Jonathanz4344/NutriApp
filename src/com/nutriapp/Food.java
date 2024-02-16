package com.nutriapp;

import java.util.List;


/*
 * This class represonts food items.
 * It is an abstract class because it is not meant to be instantiated.
 * Food has name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, and carbsPerUnit
 */
abstract class Food {
    protected String name;
    protected int caloriesPerUnit;
    protected int fatPerUnit;
    protected int proteinPerUnit;
    protected int fiberPerUnit;
    protected int carbsPerUnit;
  
    public Food(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbsPerUnit) {
      this.name = name;
      this.caloriesPerUnit = caloriesPerUnit;
      this.fatPerUnit = fatPerUnit;
      this.proteinPerUnit = proteinPerUnit;
      this.fiberPerUnit = fiberPerUnit;
      this.carbsPerUnit = carbsPerUnit;
    }
  
    public String getName() {
      return this.name;
    }
  
    public int getCaloriesPerUnit() {
      return this.caloriesPerUnit;
    }
  
    public int getFatPerUnit() {
      return this.fatPerUnit;
    }
  
    public int getProteinPerUnit() {
      return this.proteinPerUnit;
    }
  
    public int getFiberPerUnit() {
      return this.fiberPerUnit;
    }
  
    public int getCarbsPerUnit() {
      return this.carbsPerUnit;
    }

    public abstract int getStock();

    public abstract void setStock(int stock);
  
    public abstract int calculateTotalCalories(User user);
  
    public abstract void addIngredient(Food ingredient);
  
    public abstract void removeIngredient(Food ingredient);
  
    public abstract List<Food> getIngredients();
  }
