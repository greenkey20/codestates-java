package com.codestates.section1.unit10.file;

import java.io.File;

// 2023.7.20(목) 16h50
public class FileExample2 {
    public static void main(String[] args) {
        File parentDir = new File("./");
        File[] list = parentDir.listFiles();

        String prefix = "KEY";

        for (int i = 0; i < list.length; i++) {
            String fileName = list[i].getName();

            if (fileName.endsWith("txt") && !fileName.startsWith("code")) {
                list[i].renameTo(new File(parentDir, prefix + fileName));
            }
        }
    }
}
