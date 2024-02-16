package com.nutriapp;

/*
 * This interface is responsible for calculating the calories burned during a workout.
 * calculatecaloriesburned takes in duration and intensity for the workout concerete strategies to work. 
 */
public interface WorkoutStrategy {
    int calculateCaloriesBurned(int duration, int intensity);
}
