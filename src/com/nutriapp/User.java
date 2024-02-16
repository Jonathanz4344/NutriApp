package com.nutriapp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * This class represents a user.
 * A user has a name, height, weight, birthdate, goal, daily calorie intake, foods, 
 * weight observers, workout strategy, shopping list observers, and day length.
 * A user can add a food, remove a food, add a weight observer, remove a weight
 * observer, add a shopping list observer, remove a shopping list observer, and update their goal.
 */
public class User implements StockObserver {
    private String name;
    private double height;
    private double weight;
    private LocalDate birthdate;
    private Goal goal;
    private int goalWeight;
    private double dailyCalorieIntake;
    private List<Food> foods;
    private List<WeightObserver> weightObservers;
    private WorkoutStrategy workoutStrategy;
    private List<ShoppingListObserver> shoppingListObservers;
    private int dayLength;

    public User(String name, double height, double weight, LocalDate birthdate, int goal) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        // this.foods = foods;
        this.weightObservers = new ArrayList<>();
        // this.workoutStrategy = workoutStrategy;
        this.shoppingListObservers = new ArrayList<>();
        // if the goal is less than their weight, they want to lose weight
        if (goal < weight) {
            this.goal = new LoseWeight();
        } else if (goal > weight) {
            this.goal = new GainWeight();
        } else {
            this.goal = new MaintainWeight();
        }
        this.goalWeight = goal;
        // this.goal.update(this);
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        for (WeightObserver observer : weightObservers) {
            observer.updateWeight(weight);
        }
    }

    // public List<Food> getFoods() {
    //     return foods;
    // }

    public int getDayLength() {
        return dayLength;
    }

    public void registerWeightObserver(WeightObserver observer) {
        weightObservers.add(observer);
    }

    public void unregisterWeightObserver(WeightObserver observer) {
        weightObservers.remove(observer);
    }

    public int calculateCaloriesBurned(int duration, int intensity) {
        return workoutStrategy.calculateCaloriesBurned(duration, intensity);
    }

    // public void setWorkoutStrategy(WorkoutStrategy workoutStrategy) {
    //     this.workoutStrategy = workoutStrategy;
    // }

    // public WorkoutStrategy getWorkoutStrategy() {
    //     return workoutStrategy;
    // }


    public void setGoal(Goal goal) {
        if (goal != null) {
            this.goal = goal;
            goal.update(this);
        } else {
            throw new IllegalArgumentException("Goal cannot be null.");
        }
    }

    public void setDailyCalorieIntake(double dailyCalorieIntake) {
        this.dailyCalorieIntake = dailyCalorieIntake;
    }

    @Override
    public void updateStock(Ingredient ingredient) {
        System.out.println("Need to buy " + ingredient.getName() + " for " + getName());
    }
    
    
    
    public double getBMR() {
        double bmr = 0;
        if (goal instanceof LoseWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else if (goal instanceof GainWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else if (goal instanceof MaintainWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        }
        return bmr;
    }

    public double getDailyCalorieIntake() {
        double bmr = getBMR();
        if (goal instanceof LoseWeight) {
            dailyCalorieIntake = bmr * 0.8;
        } else if (goal instanceof GainWeight) {
            dailyCalorieIntake = bmr * 1.2;
        } else if (goal instanceof MaintainWeight) {
            dailyCalorieIntake = bmr;
        }
        return dailyCalorieIntake;
    }

    public void addShoppingListObserver(ShoppingListObserver observer) {
        shoppingListObservers.add(observer);
    }

    public void removeShoppingListObserver(ShoppingListObserver observer) {
        shoppingListObservers.remove(observer);
    }

    public void notifyShoppingListObservers(ShoppingList shoppingList) {
        for (ShoppingListObserver observer : shoppingListObservers) {
            observer.update(shoppingList);
        }
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "Height: " + height + " cm\n" +
                "Weight: " + weight + " kg\n" +
                "Birthdate: " + birthdate + "\n" +
                "Goal: " + goal + "\n";
    }
}