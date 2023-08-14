package ru.yandex.tasks;

import java.util.Stack;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        /*
         * sequence - последовательность скобок []{}() длины до 10^5
         * Выход: true/false, является ли строка ПСП
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        char[] open = {'[', '{', '('};
        char[] close = {']', '}', ')'};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == open[0] || sequence.charAt(i) == open[1] || sequence.charAt(i) == open[2]) {
                stack.push(sequence.charAt(i));
            } else {
                // когда только закрывающая скобка
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == open[0] && sequence.charAt(i) == close[0] ||
                    stack.peek() == open[1] && sequence.charAt(i) == close[1] ||
                    stack.peek() == open[2] && sequence.charAt(i) == close[2]
                ) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
