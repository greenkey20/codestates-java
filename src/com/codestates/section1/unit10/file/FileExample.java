package com.codestates.section1.unit10.file;

import java.io.File;
import java.io.IOException;

// 2023.7.20(목) 16h40
public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("../codestates.txt"); // 이 파일이 존재하지 않아도 컴파일 에러가 발생하지는 않음 + File 인스턴스 생성이 곧 파일을 생성하는 건 아님

        System.out.println(file.getPath()); // ../codestates.txt
        System.out.println(file.getParent()); // ..
        System.out.println(file.getCanonicalPath()); // /Users/greenpianorabbit/codestates/codestates.txt
        System.out.println(file.canWrite()); // false
    }
}
