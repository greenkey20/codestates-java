package com.codestates.section2.unit2.stack;

// 2022.9.22(목) 15h45
public class ArrayListAsStack {
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        System.out.println(stack); // com.codestates.section2.unit2.stack.StackImplementation@5a39699c
        System.out.println(stack.show()); // []

        stack.push(1);
        System.out.println(stack.show()); // [1]

        stack.push(2);
        System.out.println(stack.show());

        stack.push(3);
        System.out.println(stack.show());

        stack.push(4);
        System.out.println(stack.show());

        stack.push(5);
        System.out.println(stack.show()); // [1, 2, 3, 4, 5]

        stack.pop();
        System.out.println(stack.show()); // [1, 2, 3, 4]

        stack.pop();
        System.out.println(stack.show()); // [1, 2, 3]

        stack.pop();
        System.out.println(stack.show()); // [1, 2]

        System.out.println(stack.pop());
        System.out.println(stack.show()); // [1]

        stack.pop();
        System.out.println(stack.show()); // []

        stack.pop();
        System.out.println(stack.show()); // [] vs Stack 클래스의 pop()은 빈 스택에서 pop하려고 했더니 Empty Stack Exception 발생하도록 구현되어 있음
    }
}
