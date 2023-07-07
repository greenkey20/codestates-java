package com.codestates.section1.unit10.stream;

import java.util.Arrays;
import java.util.List;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printBoldLine;
import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.7.7(금) 22h10
public class StreamIntermediateOperation {
    public static void main(String[] args) {
        // filter()

        // distinct()

        // map()
        List<String> names3 = Arrays.asList("panda", "miffy", "tromm", "happy");
        names3.stream()
                .map(element -> element.toUpperCase())
                .forEach(System.out::println);

        printLine();

        List<Integer> list3 = Arrays.asList(1, 3, 6, 9);
        list3.stream()
                .map(number -> number * 3)
                .forEach(System.out::println);

        printLine();

        String[][] professorsArray = new String[][]{{"Moomin KANG", "database"}, {"Snorkmaiden KANG", "Java"}};
        Arrays.stream(professorsArray)
                .map(inner -> Arrays.stream(inner)) // Stream<Stream<String>>, 스트림의 스트림, 중첩 스트림 반환 <- 람다식으로 바꿔쓰면 map(Arrays::stream)
                .forEach(System.out::println);
        // java.util.stream.ReferencePipeline$Head@57829d67
        // java.util.stream.ReferencePipeline$Head@19dfb72a

        printLine();

        // depth 있는 요소들애 접근 방법1)
        Arrays.stream(professorsArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(names -> names.forEach(System.out::println));

        printLine();

        // 방법2)
        Arrays.stream(professorsArray)
                .flatMap(inner -> Arrays.stream(inner)) // 중첩 구조 제거 -> 단일 컬렉션 Stream<String>으로 만들어줌
                .forEach(System.out::println);

        printBoldLine();

        // sorted()
        // skip()
        // limit()
        // peek()
    }
}
