package com.codestates.section1.unit10.lambda;

// 2022.9.15(목) 15h5
public class LambdaExample1 {
    public static void main(String[] args) {
        /* Java에서 람다식 사용
        람다식 = 객체, 익명(이름 없는) 클래스

        방법1) 람다식을 익명 객체로 만들고 Object 타입의 참조변수 obj에 담음
         */
        Object obj = new Object() { // 익명 클래스(객체의 선언과 생성을 동시에 함 -> 단 1개의 객체 생성, 단 1번만 사용/1회용)
            int sum(int num1, int num2) {
                return num1 + num2;
            }
        };

        // 객체 생성 시 만든 Object 클래스에 sum이라는 메서드가 없기 때문에, sum 메서드 사용 불가능
//        Object controller = (num1, num2) -> num1 + num2;

        // 방법2) 함수형 인터페이스 사용
        SumFunction sumFunction = (num1, num2) -> num1 + num2;
        System.out.println(sumFunction.sum(21, 37));

        // 매개변수 없는 람다식
        AcceptFunction acceptFunction;

        acceptFunction = () -> {
            String str = "accept() 함수 1번째 호출";
            System.out.println(str);
        };
        acceptFunction.accept();

        acceptFunction = () -> System.out.println("accept() 함수 2번째 호출");
        acceptFunction.accept();

        // 매개변수 있는 람다식
        OneParameterFunction oneParameterFunction;

        oneParameterFunction = (y) -> {
            int result = y * 4;
            System.out.println("매개변수 1개 있는 람다식 1번째 호출 결과 = " + result);
        };

        oneParameterFunction.accept(7);

        oneParameterFunction = (z) -> System.out.println("매개변수 1개 있는 람다식 2번째 호출 결과 = " + z * 9);
        oneParameterFunction.accept(17);

        // 리턴 값 있는 람다식
        ReturnFunction returnFunction;

        returnFunction = (x, y, z) -> {
            int result = x + y + z;
            return result;
        };
        int result1 = returnFunction.accept(4, 6, 8);
        System.out.println(result1);

//        returnFunction = (x, y, z) -> { return x + y + z; };
        returnFunction = (x, y, z) -> x + y + z;
        int result2 = returnFunction.accept(4, 6, 8);
        System.out.println(result2);
    } // main() 종료
}

@FunctionalInterface // annotation을 써서 컴파일러가 확인할 수 있도록 함
interface SumFunction {
    int sum(int num1, int num2);
//    int sum2(int num1, int num2, int num3);
}

@FunctionalInterface
interface AcceptFunction {
    void accept();
}

@FunctionalInterface
interface OneParameterFunction {
    void accept(int x);
}

@FunctionalInterface
interface ReturnFunction {
    int accept(int a, int b, int c);
}