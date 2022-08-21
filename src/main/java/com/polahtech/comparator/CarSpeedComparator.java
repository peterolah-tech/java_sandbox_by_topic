package com.polahtech.comparator;

import com.polahtech.comparable.Car;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getSpeed(), car2.getSpeed());
    }
}
