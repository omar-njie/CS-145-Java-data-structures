package com.omar.data_structures.assignments.assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is responsible for decoding a huffman encoded file.
 * It checks for two files create from {@link TextToCode} class,
 * assuming that they exist if not the program will exit.
 *
 * @author Omar
 * @version 12.2.22
 * @see TextToCode
 * @see StringBuilder
 */
public class CodeToText implements Runnable {

    private static FileInputStream fis;
    private static Scanner input;
    private final Map<String, Character> map = new HashMap<>();
    private final StringBuilder sb = new StringBuilder();
    private final File code_file;
    private final File huff_file;


    /**
     * <b>Creates a CodeToText object, sets the .code file, .huff file,
     * input stream for reading files and scanner for user input.</b>
     *
     * @param file_name    the name of the file to be read
     * @param fis          the file input stream
     * @param input        the scanner for user input
     */
    public CodeToText(String file_name, FileInputStream fis, Scanner input) {
        code_file = new File(file_name + ".code");
        huff_file = new File(file_name + ".huff");
        CodeToText.fis = fis;
        CodeToText.input = input;

        if (!(code_file.exists()) || !(huff_file.exists())) {
            System.out.println("Missing file(s)");
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name (without period): ");

        String file_name = in.nextLine();
        if (file_name.contains(".")) {
            System.out.println("File name is invalid please try again.");
            main(args);
        }

        new CodeToText(file_name, fis, input).run();
    }


    /**
     * <p>Reads the .code file and stores the key-value pairs in a map.</p>
     *
     * @see FileInputStream
     */
    public void read_code_file() {
        try {
            fis = new FileInputStream(code_file);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                char ch = (char) Integer.parseInt(sc.nextLine());
                String s = sc.nextLine();
                map.put(s, ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <p>Reads the .huff file and decodes the message.</p>
     *
     * @see FileInputStream
     * @see Scanner
     * @see StringBuilder
     */
    public void read_huff_file() {
        try {
            fis = new FileInputStream(huff_file);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <p>Decodes the message.</p>
     */
    public void decode() {
        String data = sb.toString();
        String mini_string = "";
        for (int i = 0; i < data.length(); i++) {
            mini_string += data.charAt(i);
            if (map.containsKey(mini_string)) {
                // print decoded character to the console
                System.out.print(map.get(mini_string));
                mini_string = "";
            }
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        read_code_file();
        read_huff_file();
        decode();
    }
}
