package com.codestates.section1.unit10.fileio;

import java.io.FileInputStream;

// 2023.7.14(금) 23h
public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInput = new FileInputStream("codestates.txt"); // 터미널에서 만든 이 파일을 section1 > unit10> fileio(x) codestates-java 들어오자마자(o)에 넣었더니 파일 읽혀짐
            int i = 0;
            while ((i = fileInput.read()) != -1) {
                System.out.println((char) i);
            }

            fileInput.close();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }
    }
}
