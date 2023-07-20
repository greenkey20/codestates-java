package com.codestates.section1.unit10.file.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 2023.7.20(목) 16h30
public class FileWriterExample {
    public static void main(String[] args) {
        String fileName = "codestates_write.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(writer);

            String str = "written v2!\n한글도 쓰기! ^^";
            writer.write(str);

//            writer.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
