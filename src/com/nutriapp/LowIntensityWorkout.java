package com.nutriapp;

/*
 * This is responsible for calculating the calories burned during a workout.
 * Low Intensity workout option and the amount burned 
 */
public class LowIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 5 * duration;
    }
}

