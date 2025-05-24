package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz02_RemoveParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        System.out.println(answer(value));
    }

    private static String answer(String value) {
        Stack<Character> stack = new Stack();
        StringBuffer sb = new StringBuffer();
        for (char c : value.toCharArray()) {
            if (stack.isEmpty() && (c != '(' && c != ')')) {
                sb.append(c);
            }
            if (c == '(') stack.add('(');
            if (c == ')') {
                stack.pop();
            }
        }
        return sb.toString();
    }

}
