package com.omar.learn.Army_Stuff;

import java.io.File;
import java.util.Scanner;

public class ArmySim {

    public static void main(String[] args) {
        ArmyDude[] myArmy = new ArmyDude[10];

        File f = new File("Data.txt");
        Scanner mainScanner = null;
        try {
            mainScanner = new Scanner(f);
        } catch (Exception e) {
            System.out.println("there was an error.");
            System.exit(-1);
        }

        int currentCount = 0;

        // Create the array of Dudes
        while (mainScanner.hasNextLine()) {
            String line = mainScanner.nextLine();
            line = line.trim();
            if (line.length() > 1) {
                Scanner lineScan = new Scanner(line);
                String type = lineScan.next();
                String name = lineScan.next();
                myArmy[currentCount] = createDude(name, type);
                currentCount++;
                //System.out.println("TEST"+type + ":" + name);
            }
        }

        // Print out the results.
        System.out.println("********** Round 1 **************");
        for (ArmyDude armyDude : myArmy) {
            armyDude.printResult();
        }
        System.out.println("********** Round 2 **************");
        for (ArmyDude armyDude : myArmy) {
            armyDude.printResult();
        }

    }

    public static ArmyDude createDude(String name, String type) {
        if (type.equals("PVT")) return new Private(name);
        if (type.equals("SPC")) return new Speciialist(name);
        if (type.equals("CPL")) return new Corporal(name);
        if (type.equals("SGT")) return new Sergeant(name);

        throw new IllegalArgumentException("Bad dude Type :" + type);

    }
}