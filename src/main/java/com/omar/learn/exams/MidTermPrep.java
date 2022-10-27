package com.omar.learn.exams;

import java.util.*;

/**
 * @author Omar
 * @version 10/26/22
 */
public class MidTermPrep {

    public static void main(String[] args) {
      /*  ArrayList<String> list = new ArrayList<>();
        list.add("four");
        list.add("score");
        list.add("and");
        list.add("seven");
        list.add("years");
        list.add("ago");
        removeShorterStrings(list);
        Set<String> s = new TreeSet<>();
        // "foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"
        s.add("foo");
        s.add("buzz");
        s.add("bar");
        s.add("fork");
        s.add("bort");
        s.add("spoon");
        s.add("!");
        s.add("dude");
        removeEvenLength(s);*/
        //Maps();
        //CharCount("hello");
        //setIterating();
        //removeBelowX();
        //System.out.println(digitSum(12));

        Map<String, String> map = new HashMap<>();
        map.put("Marty", "206-685-2181");
        map.put("Rick", "520-206-6126");
        map.put("Beekto", "206-685-2181");
        map.put("Jenny", "253-867-5309");
        map.put("Stuart", "206-685-9138");
        map.put("DirecTV", "800-494-4388");
        map.put("Bob", "206-685-9138");
        map.put("Benson", "206-616-1246");
        map.put("Hottline", "900-520-2767");
        System.out.println(countInAreaCode(map, "520"));

        Lake var1 = new Ocean();
        Pond var2 = new Pond();
        Pond var3 = new Lake();
        Object var4 = new Bay();
        Lake var5 = new Bay();
        Bay var6 = new Ocean();

        var1.method2();  ((Ocean) var5).method1();

        var2.method2();  ((Lake) var3).method3();

        var3.method2();  /*((Lake) var4).method1();*/

        /*var4.method2();*/ ((Ocean) var1).method1();

        var5.method2();  ((Bay) var4).method1();

        var6.method2();  ((Lake) var2).method3();


        var1.method3();  ((Ocean) var5).method1();


        /*var2.method3();*/  ((Pond) var4).method2();

        /*var3.method3();*/  ((Bay) var4).method1();


        /*var4.method3();*/  ((Lake) var2).method3();


        var5.method3();  ((Ocean) var5).method1();


        var6.method3();  ((Pond) var4).method2();


    }

    void mystery(ArrayList<Integer> list) {
        list.add(30);
        list.add(20);
        list.add(10);
        list.add(60);
        list.add(50);
        list.add(40);
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }
        System.out.println(list);
    }


    public static void removeShorterStrings(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() < list.get(i + 1).length()) {
                list.remove(i);
                i--;
            } else if (list.get(i).length() > list.get(i + 1).length()) {
                list.remove(i + 1);
                i--;
            }
        }
        System.out.println(list);
    }


    public static void removeEvenLength(Set<String> set) {
        Set<String> temp = new TreeSet<String>();

        for (String x : set) {
            if (x.length() % 2 == 0) {
                temp.add(x);
            }
        }
        for (String x : temp) {
            set.remove(x);
        }
    }

    public static int mystery2(int n) {
        if (n < 10) {
            return (10 * n) + n;
        } else {
            int a = mystery2(n / 10);
            System.out.println(a);
            int b = mystery2(n % 10);
            System.out.println(b);
            return (100 * a) + b;
        }
    }

    static void Maps() {
        Map<String, Integer> ages = new TreeMap<>();
        ages.put("tim", 20);
        ages.put("hello", 15);
        ages.put("line", 17);
        ages.put("zine", 25);

        // loop maps
        for (String name : ages.keySet()) {
            int age = ages.get(name);
            System.out.println(name + "->" + age);
        }

        // change a map
        for (String name : ages.keySet()) {
            int put = ages.put(name, ages.get(name) + 10);
            System.out.println(put);
        }
    }

    static void CharCount(String count) {
        Map<Character, Integer> count_map = new HashMap<>();
        for (int i = 0; i < count.length(); i++) {
            char z = count.charAt(i);

            if (count_map.containsKey(z)) {
                int cc = count_map.get(z);
                cc++;
                count_map.put(z,cc);
            } else {
                count_map.put(z, 1);
            }
        }
        for (char i : count_map.keySet()) {
            System.out.println("\"" + i + "\" = " + count_map.get(i));
        }
    }

    // remove from a set while iterating through it
    static void setIterating() {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int element = iter.next();
            if (element % 2 == 0) {
                iter.remove();
            }
        }
        // set.removeIf(element -> element % 2 == 0);
        System.out.println(set);
    }


    static void removeBelowX() {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.removeIf(element -> element < 5);
        System.out.println(set);
    }

     static int digitSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + digitSum(n / 10);
        }
    }

    static int digitMultiply(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 * digitMultiply(n / 10);
        }
    }

    static int digitDivide(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 / digitDivide(n / 10);
        }
    }

    static int countInAreaCode(Map<String, String> map, String areaCode) {
        int count = 0;
        for (String number : map.values()) {
            if (number.substring(0, 3).equals(areaCode)) {
                count++;
            }
        }
        return count;
    }


}

class Bay extends Lake {
    public void method1() {
        System.out.println("Bay 1");
        super.method2();
    }

    public void method2() {
        System.out.println("Bay 2");
    }

}

class Pond {
    public void method2() {
        System.out.println("Pond 2");
    }
}

class Ocean extends Bay {
    public void method2() {
        System.out.println("Ocean 2");
    }

}

class Lake extends Pond {
    public void method3() {
        System.out.println("Lake 2");
        method2();
    }

}