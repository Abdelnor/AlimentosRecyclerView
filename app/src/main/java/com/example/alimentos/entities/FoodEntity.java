package com.example.alimentos.entities;

public class FoodEntity {

    private int id;
    private String name;
    private int calories;
    private int quantity;
    private String unit;
    private String description;

    public FoodEntity(int id, String name, int calories, int quantity, String unit, String description) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.unit = unit;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

}
