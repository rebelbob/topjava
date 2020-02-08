package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class UserMeal {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private static HashMap<LocalDate, Integer> caloriesEachDay = new HashMap<>();

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;

        caloriesEachDay.put(dateTime.toLocalDate(), caloriesEachDay.getOrDefault(dateTime.toLocalDate(), 0) + calories);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExcess(int caloriesPerDay){
        return caloriesEachDay.get(dateTime.toLocalDate()) > caloriesPerDay;
    }
}
