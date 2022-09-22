package com.codestates.section2.unit2.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Stack3Reference {
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.add(start);

        for (int i = 0; i < actions.length; i++) {
            if (actions[i].equals("-1") && !prevStack.empty()) {
                String prevPage = prevStack.pop();
                nextStack.push(current.pop());
                current.push(prevPage);
            } else if (actions[i].equals("1") && !nextStack.empty()) {
                String nextPage = nextStack.pop();
                prevStack.push(current.pop());
                current.push(nextPage);
            } else if (actions[i].equals("1") || actions[i].equals("-1")) {

            } else {
                prevStack.push(current.pop());
                current.push(actions[i]);
                nextStack.clear();
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}
