package com.polahtech.comparator;

import com.polahtech.comparable.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarSpeedComparatorTest {

    @Test
    void testIfCarIsSlower() {
        Car car1 = new Car("red", "Mercedes", 240);
        Car car2 = new Car("blue", "BMW", 220);
        Car car3 = new Car("gray", "Trabant", 230);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        CarSpeedComparator carSpeedComparator = new CarSpeedComparator();
        System.out.println(carList);
        Collections.sort(carList);
        System.out.println(carList);
    }

}