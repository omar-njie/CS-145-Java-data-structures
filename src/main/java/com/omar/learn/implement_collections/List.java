package com.omar.learn.implement_collections;

import java.util.Iterator;

/**
 * @author Omar
 * @version 11/16/22
 */
public interface List<E extends Iterator> {

    int size();
    E get(int index);
    int indexOf(E value);
    boolean isEmpty();
    boolean contains(E value);
    void add(E value);
    void add(int index, E value);
    void addAll(List<E> list);
    void remove(int index);
    void set(int index, E value);
    void clear();

}
