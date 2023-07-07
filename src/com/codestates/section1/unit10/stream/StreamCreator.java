package com.codestates.section1.unit10.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.7.7(금) 20h40
public class StreamCreator {
    public static void main(String[] args) {
        // 문자열 배열 생성 + 할당
        String[] arr = new String[]{"Tromm", "Panda", "Miffy"};

        // 문자열 스트림 생성
//        Stream<String> stream = Arrays.stream(arr);
        Stream<String> stream = Stream.of(arr);

        // 출력
        stream.forEach(System.out::println);

        printLine();

        // int형 배열로 스트림 생성
        int[] intArr = {1, 2, 3, 4, 5, 6, 7};
        IntStream intStream = Arrays.stream(intArr);

        System.out.println("sum = " + intStream.sum()); // sum = 28
//        System.out.println("average = " + intStream.average()); // average = OptionalDouble[4.0]

        printLine();

        List<Integer> list = Arrays.asList(7, 6, 5, 4, 3, 2, 1); // 요소들을 list 타입의 참조변수에 할당
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(System.out::print); // 7654321

        printLine();

//        IntStream intStream2 = new Random().ints(5);
        IntStream intStream2 = new Random().ints().limit(5);
        intStream2.forEach(System.out::println);

        printLine();

//        IntStream intStream3 = IntStream.rangeClosed(1, 10); // 12345678910
        IntStream intStream3 = IntStream.range(1, 10); // 123456789
        intStream3.forEach(System.out::print);
    }
}
