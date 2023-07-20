package com.codestates.section1.unit10.fileio;

import java.io.FileOutputStream;
import java.io.IOException;

// 2023.7.20(목) 11h45
public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("codestates_write.txt");
            String word = "code12\nstates34\n\nKEY";
            /*
            code12
            states34

            KEY
             */

            byte[] b = word.getBytes();
            fileOutput.write(b);
            fileOutput.close();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
