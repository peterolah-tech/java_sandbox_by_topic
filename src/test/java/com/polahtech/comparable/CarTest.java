package com.polahtech.comparable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    // TODO: discuss if it was better to use @BeforeAll for car1-2 (these are used in several tests, although not in all)
    @Test
    void testIfCarIsSlower() {
        Car car1 = new Car("red", "Mercedes", 220);
        Car car2 = new Car("blue", "BMW", 240);
        assertTrue(car1.compareTo(car2) < 0);
    }

    @Test
    void testIfCarIsFaster() {
        Car car1 = new Car("red", "Mercedes", 220);
        Car car2 = new Car("blue", "BMW", 240);
        assertTrue(car2.compareTo(car1) > 0);
    }

    @Test
    void testIfCarsAreEquallyFast() {
        Car car1 = new Car("red", "Mercedes", 220);
        Car car8 = new Car("blue", "BMW", 220);
        assertEquals(0, car1.compareTo(car8));
    }

    @Test
    void testIfDifferentCars() {
        Car car1 = new Car("red", "Mercedes", 220);
        Car car2 = new Car("blue", "BMW", 240);
        assertNotEquals(car1, car2);
    }

    @Test
    void testIfSameCars() {
        Car car1 = new Car("red", "Mercedes", 220);
        Car car3 = new Car("red", "Mercedes", 220);
        assertEquals(car1, car3);
    }

    @Test
    void testIfSameCarsWithNullAsBrand() {
        Car car4 = new Car("yellow", null, 230);
        Car car5 = new Car("yellow", null, 230);
        assertEquals(car4, car5);
    }

    @Test
    void testIfSameCarsWithNullAsColor() {
        // Due to the incorrect implementation of Car class
        // (color can be null, but it is not reflected in the 'equals' method),
        // a NullPointerException is thrown
        Car car6 = new Car(null, "Jaguar", 200);
        Car car7 = new Car(null, "Jaguar", 200);
        assertThrows(NullPointerException.class, () -> {
            car6.equals(car7);
        });
    }
}