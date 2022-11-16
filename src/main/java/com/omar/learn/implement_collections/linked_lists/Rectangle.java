package com.omar.learn.implement_collections.linked_lists;

/**
 * @author Omar
 * @version 11/15/22
 */
public class Rectangle implements Comparable<Rectangle> {

    private int height;
    private int width;

    public Rectangle() {
        height = 10;
        width = 10;
    }

    public Rectangle(int s) {
        height = s;
        width = s;
    }

    public Rectangle(int l, int w) {
        height = Math.abs(l);
        width = Math.abs(w);
    }

    public String toString() {
        return "[" + height + "x" + width + "]";
    }

    public int getArea() {
        return height * width;
    }

    public boolean equals(Rectangle other) {
        return this.height == other.height
                && this.width == other.width;
    }

    public int compareTo(Rectangle o) {
        return this.getArea() - o.getArea();
    }
}
