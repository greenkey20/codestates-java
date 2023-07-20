package com.codestates.section1.unit10.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 2023.7.20(목) 12h
public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "codestates_read.txt";
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);

            int data = 0;

            while ((data = br.read()) != -1) {
                System.out.print((char) data);
//                System.out.println("data = " + (char) data);
            }

//            file.close(); // Java정석에 따르면 가비지컬렉터가 수거해가므로 굳이 안 닫아줘도 된다?!
            br.close(); // 16h35 나의 질문 = 이렇게 자원 열고 닫고 자원 사용 현황 볼 수 있는 방법이 있나?
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
