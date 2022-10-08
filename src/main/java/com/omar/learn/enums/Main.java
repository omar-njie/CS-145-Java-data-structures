package com.omar.learn.enums;

/**
 * @author Omar
 * @version 10/7/22
 */
public class Main {

    public static void main(String[] args) {
        DaysOfTheWeek day = DaysOfTheWeek.SUNDAY;
        System.out.println(day);

        for (DaysOfTheWeek days : DaysOfTheWeek.values()) {
            System.out.println(days);
        }

        int levelOfDeliciousness = Cereals.CAPTAIN_CRUNCH.levelOfDeliciousness;
        System.out.println(levelOfDeliciousness);
    }

}
