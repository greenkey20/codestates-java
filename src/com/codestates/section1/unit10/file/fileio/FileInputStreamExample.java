package com.codestates.section1.unit10.file.fileio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

// 2023.7.14(금) 23h
public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInput = new FileInputStream("codestates_read.txt"); // 터미널에서 만든 이 파일을 section1 > unit10> fileio(x) codestates-java 들어오자마자(o)에 넣었더니 파일 읽혀짐
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput); // 보조스트림, 버퍼 = 바이트 배열 -> 사용하면 성능 향상
            int i = 0;
            while ((i = bufferedInput.read()) != -1) {
                System.out.print((char) i);
//                System.out.println("i = " + (char) i);
            }

//            fileInput.close();
            bufferedInput.close(); // 2023.7.20(목) 11h20 나의 생각 = reference 코드에는 이건 없는데, close() 안 해줘도 되나..? 해야 한다면 이 순서로 하면 되나..? -> Java정석 p.895에 따르면 보조스트림의 close()가 기반스트림의 close()를 호출하기 때문에, 보조스트림의 close()만 호출하면 된다?!
            // 11h35 나의 질문 = close() 안 하면 생기는 문제점은 무엇인가?

        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }
    }
}
