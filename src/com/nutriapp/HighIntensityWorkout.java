package com.nutriapp;

/*
 * This class is the highest intensity workout allowing user to burn calories the fastest
 */
public class HighIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 10 * duration;
    }
}
