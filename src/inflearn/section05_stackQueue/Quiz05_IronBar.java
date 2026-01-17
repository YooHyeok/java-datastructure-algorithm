package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz05_IronBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(answer(str));
    }
    private static int answer(String str) {;
        int answer = 0;
        char prevChar = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if(!stack.isEmpty() && prevChar == '(' && str.charAt(i) == ')') {
                stack.pop();
                answer += stack.size();
            } else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (!stack.isEmpty() && prevChar == ')' && str.charAt(i) == ')') {
                stack.pop();
                answer++;
            }
            prevChar = str.charAt(i);
        }
        return answer;
    }

}
