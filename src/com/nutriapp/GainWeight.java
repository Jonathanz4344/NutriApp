package com.nutriapp;


/*
 * This class represents a goal to gain weight.
 * The GainWeight class is only used when user wants to gain weight as their goal. 
 * It updates user darilyCaloriesIntake and setting goal to GainWeight
 */
public class GainWeight implements Goal {
    public void update(User user) {
        double dailyCalorieIntake = user.getBMR() * 1.2;
        user.setDailyCalorieIntake(dailyCalorieIntake);
        user.setGoal(this);
    }

    public String toString() {
        return "Gain Weight";
    }
}
