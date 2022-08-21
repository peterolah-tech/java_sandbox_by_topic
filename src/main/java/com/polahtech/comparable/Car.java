package com.polahtech.comparable;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String color;
    private final String brand;
    private final int speed;

    public Car(String color, String brand, int speed) {
        this.color = color;
        this.brand = brand;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(getSpeed(), otherCar.getSpeed());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        // Note the different nature of getColor.equals() and Objects.equals(...) - handling of null values
        // Although color could be null, leaving as is to test it
        return getSpeed() == car.getSpeed() && getColor().equals(car.getColor()) && Objects.equals(getBrand(), car.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getBrand(), getSpeed());
    }
}
