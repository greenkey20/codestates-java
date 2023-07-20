package com.codestates.section1.unit10.file;

import java.io.File;
import java.io.IOException;

// 2023.7.20(목) 16h40
public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("./", "newFileCodestates.txt"); // 이 파일이 존재하지 않아도 컴파일 에러가 발생하지는 않음 + File 인스턴스 생성이 곧 파일을 생성하는 건 아님
        file.createNewFile();

        System.out.println(file.getPath()); // ./newFileCodestates.txt
        System.out.println(file.getParent()); // . -> 16h45 나의 질문 = .(현재 디렉토리) vs .. 어떤 의미이지?
        System.out.println(file.getCanonicalPath()); // /Users/greenpianorabbit/codestates/codestates-java/newFileCodestates.txt
        System.out.println(file.canWrite()); // true
    }
}
