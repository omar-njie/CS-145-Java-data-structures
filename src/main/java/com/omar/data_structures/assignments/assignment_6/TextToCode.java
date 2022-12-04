package com.omar.data_structures.assignments.assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * <p>This class is responsible for encoding a text file into a huffman encoded file.
 * It checks for a file with the given name, if it doesn't exist the program will exit.
 * It also creates two files, one for the huffman tree and one for the encoded text.
 * The huffman tree is stored in a file with the extension .code and the encoded text
 * is stored in a file with the extension .huff.
 * </p>
 *
 * @author Omar
 * @version 12.2.22
 * @see CodeToText
 *
 */
public class TextToCode implements Runnable {

    private final String CODE_FILE_NAME;
    private final String HUFF_FILE_NAME;
    private final List<Character> char_list;
    private final Map<Character, Integer> map;
    private PriorityQueue<Node<Character>> pq;
    private Node<Character> root;
    private PrintWriter code_file;
    private PrintWriter huff_file;


    /**
     *  Creates a TextToCode object, sets the character list, map, priority queue,
     *  root to null and the variables for some file operations.
     *
     *  @param file_name the name of the file to be read
     */
    public TextToCode(String file_name) {
        char_list = new ArrayList<>();
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        root = null;

        File file = new File(file_name);
        CODE_FILE_NAME = file_name.substring(0, file_name.indexOf(".")) + ".code";
        HUFF_FILE_NAME = file_name.substring(0, file_name.indexOf(".")) + ".huff";
        code_file = null;
        huff_file = null;
    }


    /**
     * <p>This method ask the user for a file name, and check if the entered file
     * is valid, if not it will ask the user to enter a valid file name.</p>
     */
    public static void user_input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name (Should end with .txt): ");
        String file_name = in.nextLine();

        if (!(file_name.contains("HAMLET"))
                && !(file_name.contains("hamlet"))
                || !(file_name.contains(".txt"))) {
            System.out.println("File name is invalid please try again.");
            user_input();
        }
    }


    /**
     * <p>This method reads the file and stores the characters in a list, and
     * also check if the file is available or not</p>
     */
    public void read_file() {
        try {
            FileInputStream fis = new FileInputStream("hamlet.txt");
            while (fis.available() > 0) {
                char c = (char) fis.read();
                char_list.add(c);
                System.out.print(c);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <p>This method counts the number of occurrences of each character in the
     * list and stores them in a map.</p>
     * @see PrintWriter
     */
    public void huffManCode() {
        try {
            read_file();
            for (Character ch : char_list)
                map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);

            for (Map.Entry<Character, Integer> entry : map.entrySet())
                pq.add(new Node<>(entry.getValue(), entry.getKey()));

            while (pq.size() > 1) {
                Node<Character> left = pq.poll();
                Node<Character> right = pq.poll();
                assert right != null; // to avoid warning of NullPointerException
                Node<Character> parent = new Node<>(left.frequency + right.frequency, null);
                parent.left = left;
                parent.right = right;
                pq.add(parent);
            }

            Map<Character, String> map_2 = new HashMap<>();
            root = pq.poll();
            huffManCode(root, "", map_2);

            code_file = new PrintWriter(CODE_FILE_NAME);
            huff_file = new PrintWriter(HUFF_FILE_NAME);


            for (Map.Entry<Character, String> entry : map_2.entrySet()) {
                code_file.println((int) entry.getKey());
                code_file.println(entry.getValue());
            }

            for (Character c : char_list)
                huff_file.print(map_2.get(c));

            code_file.close();
            huff_file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void huffManCode(Node<Character> root, String s,
                                    Map<Character, String> map_2) {
        if (root == null) {
            return;
        }
        if (root.isLeaf()) {
            map_2.put(root.ch, s);
            return;
        }
        huffManCode(root.left, s + "0", map_2);
        huffManCode(root.right, s + "1", map_2);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        user_input();
        huffManCode();
    }


    public static void main(String[] args) {
        TextToCode ttc = new TextToCode("hamlet.txt");
        ttc.run();
    }


    private static class Node<E> implements Comparable<Node<E>> {

        E data;
        Node<E> left;
        Node<E> right;
        Integer frequency;
        Character ch;

        Node(Integer frequency, Character ch) {
            this.frequency = frequency;
            this.ch = ch;
        }

        Node() {
            this.data = null;
            this.frequency = null;
            this.ch = null;

        }

        Node(E data) {
            this(data, null, null);
        }


        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "Character: " + ch + " Frequency: " + frequency;
        }

        public int compareTo(Node<E> other) {
            return this.frequency.compareTo(other.frequency);
        }


        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

}

