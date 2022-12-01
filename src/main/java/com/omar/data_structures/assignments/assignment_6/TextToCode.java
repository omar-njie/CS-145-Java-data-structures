package com.omar.data_structures.assignments.assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Omar
 * @version 11.27.22
 */
public class TextToCode implements Runnable {

    private List<Character> ch;
    private Map<Character, Integer> map;
    private PriorityQueue<Node> pq;
    private Node root;
    private Map<Character, String> codeMap;
    private FileUtil fileUtil;

    public TextToCode() {
        ch = new ArrayList<>();
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        codeMap = new HashMap<>();
    }

    public void text_to_code() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey()));
        }

        while (pq.size() > 1) {
            Node left = pq.remove();
            Node right = pq.remove();
            Node parent = new Node(left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        root = pq.remove();

        Map<Character, String> char_to_str = new HashMap<>();
        traverse(root, "", char_to_str);

    }

    private void traverse(Node root, String s,
                          Map<Character, String> char_to_str) {
        if (root == null) {
            return;
        }
        if (root.isLeaf()) {
            char_to_str.put(root.ch, s);
            codeMap.put(root.ch, s);
            return;
        }
        traverse(root.left, s + "0", char_to_str);
        traverse(root.right, s + "1", char_to_str);
    }

    public void output_code() {
        String file_name = "FILENAME.code";
        file_creator(file_name);
        // read the content of FILENAME.txt
        // and write the code to FILENAME.code
        String text = fileUtil.read_file("FILENAME.txt");
        StringBuilder sb = new StringBuilder();
    }

    public void file_creator(String file_name) {
        try {
            File f = new File(file_name);
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        FileUtil fileUtil = new FileUtil();
        fileUtil.user_input();
        fileUtil.file_creator();
        output_code();
    }

    public static void main(String[] args) {
        TextToCode textToCode = new TextToCode();
        textToCode.run();
    }

    private class FileUtil {
        private File file;
        private String file_name;
        private Scanner input;

        public FileUtil() {
            this(null, null, null);
        }

        public FileUtil(File file, String file_name, Scanner input) {
            this.file = file;
            this.file_name = file_name;
            this.input = input;
        }

        public void user_input() {
            input = new Scanner(System.in);
            System.out.print("Enter file name (Should be FILENAME.txt): ");
            file_name = input.nextLine();

            if (!(file_name.contains(".txt")
                    && file_name.contains("FILENAME"))) {
                System.out.println("File name must be FILENAME and end with \".txt\"");
                user_input();
            }
            read_file();
        }

        public void file_creator() {
            file = new File(file_name);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void read_file() {
            try {
                FileInputStream fis = new FileInputStream(file_name);
                int i;
                while ((i = fis.read()) != -1) {
                    ch.add((char) i);
                    System.out.print((char) i);
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

