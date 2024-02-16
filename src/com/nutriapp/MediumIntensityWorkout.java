package com.nutriapp;

/*
 * This is responsible for calculating the calories burned during a workout.
 * Medium level intensity workout that user can have for working out
 * Takes in duration of workout and intensity of it.
 */
public class MediumIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 7 * (duration / 2);
    }
}
