package com.omar.learn.file_io;

import java.io.*;

/**
 * @author Omar
 * @version 11/30/22
 */
public class FileEx {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/omar/learn/file_io/FileEx.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // write to file
        /*try {
            FileOutputStream fos = new FileOutputStream(file);
            String text = "Hello World";
            fos.write(text.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // read from file
        try {
            FileInputStream fis = new FileInputStream(file);
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
