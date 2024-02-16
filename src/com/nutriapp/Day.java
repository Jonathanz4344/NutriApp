package com.nutriapp;

import java.time.LocalDate;
import java.util.List;

/*
 * This class is responsible for storing a day's worth of data.
 * Allow current date, weight, list of meals, and workouts the user has done to be saved.
 */
public class Day {
    private LocalDate date;
    private double weight;
    private List<Meal> meals;
    private List<WorkoutStrategy> workouts;

    public Day(LocalDate date, double weight, List<Meal> meals, List<WorkoutStrategy> workouts) {
        this.date = date;
        this.weight = weight;
        this.meals = meals;
        this.workouts = workouts;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<WorkoutStrategy> getWorkouts() {
        return workouts;
    }
}
