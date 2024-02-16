package com.nutriapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * This class is responsible for storing a user's history.
 * This class takes in the day's worth of data into a user's history by adding the day.
 * Method getDay to get a specific day's history
 */
public class History {
    private List<Day> days;

    public History() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public List<Day> getDays() {
        return days;
    }

    public Day getDay(LocalDate date) {
        for (Day day : days) {
            if (day.getDate().equals(date)) {
                return day;
            }
        }
        return null;
    }
}
