package com.omar.learn.comparable_interface;

import com.omar.data_structures.assignments.assignment_4.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static com.omar.data_structures.assignments.assignment_4.Card.Cost;

/**
 * @author Omar
 * @version 11/3/22
 */
public class Car implements Comparable<Car> {

    private final String name;
    private final int id;

    public Car(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(@NotNull Car o) {
        if (this.getId() == o.getId()) {
            return 0;
        } else if (this.getId() > o.getId()) {
            return 1; // other way around returns -1
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("Audi", 2);
        Car car3 = new Car("Mercedes", 3);
        Car car4 = new Car("Toyota", 4);
        Car car5 = new Car("Honda", 5);
        Car car6 = new Car("Ford", 6);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        Collections.sort(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " " + car.getId());
        }

        Random y = new Random();
        int low = 1;
        int high = 6;
        int result = y.nextInt(high - low) + low + 1;
        System.out.println(result);
        int z = y.nextInt(6) + 1;
        System.out.println(z);
        int r = 5;
        int s = 5;
        int p = 5;
        int x = r + p + s;
        double f = 12 / (10 * ((Math.pow((double) r / (double) x, 5)) + (Math.pow((double) s / (double) x, 5)) + (Math.pow((double) p / (double) x, 5))));
        // [12/10 * ((R/X)^5 + (S/X)^5 + (P/X)^5)]
        System.out.println(f);
        System.out.println(Cost(50, 60, 80));
        // [12/10 * ((R/X)^5 + (S/X)^5 + (P/X)^5)] in html
        System.out.println("<html><body><p> [12/10 * ((R/X)^5 + (S/X)^5 + (P/X)^5)] </p></body></html>");
    }

    static int customPow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}
