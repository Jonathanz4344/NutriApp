package com.nutriapp;

/*
 * This class is responsible for updating a user's goal.
 * This class is an goal option for when a user wants to maintain weight.
 * Updates users goal and daily intake
 */
public class MaintainWeight implements Goal {
    public void update(User user) {
        double dailyCalorieIntake = user.getBMR();
        user.setDailyCalorieIntake(dailyCalorieIntake);
        user.setGoal(this);
    }

    public String toString() {
        return "Maintain Weight";
    }
}
