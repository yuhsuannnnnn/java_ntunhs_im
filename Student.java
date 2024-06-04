package test;

import java.util.HashMap;
import java.util.Map;

class Student {
    private String name;
    private double height;  // in centimeters
    private double weight;  // in kilograms

    public Student(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateBMI() {
        double heightInMeters = height / 100;  // convert cm to meters
        return weight / (heightInMeters * heightInMeters);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Height: %.2f cm, Weight: %.2f kg, BMI: %.2f", name, height, weight, calculateBMI());
    }
}
