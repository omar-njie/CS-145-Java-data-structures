package com.omar.learn;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Omar
 * @version 9/29/22
 */
public class RandomChance {

    public static void main(String[] args) {

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int num = r.nextInt(5) + 1;
            System.out.println(num);
        }
        System.out.println("--------------------");
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < 5) {
            set.add(r.nextInt(5) + 1);
        }
        System.out.println("Random numbers with no duplicates = " + set);

        /*        Set<Color> colors = new LinkedHashSet<>();
        while (colors.size() < 5) {
            int random_color = rand.nextInt(5) + 1;
            colors.add(switch (random_color) {
                case 1 -> Color.RED;
                case 2 -> Color.GREEN;
                case 3 -> Color.YELLOW;
                case 4 -> Color.BLUE;
                case 5 -> Color.PINK;
                default -> Color.BLACK;
            });
        }
        return colors.iterator().next();*/
    }

}
