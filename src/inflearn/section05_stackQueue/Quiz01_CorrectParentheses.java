package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz01_CorrectParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        System.out.println(answer1(value));
        System.out.println(answer2(value));
        System.out.println(solution(value));
    }

    /**
     * Stack의 원리와 비슷한 개념이다.
     */
    private static String answer1(String value) {
//        int open = 0, close = 0;
        int open = 0;
        if (value.charAt(0) == ')' || value.charAt(value.length()-1) == '(' ) return "NO";
        for (char c : value.toCharArray()) {
            if (c == '(') open ++;
//            if (c == ')') close++;
            if (c == ')') open--;
        }
//        return open == close ? "YES" : "NO";
        return open == 0 ? "YES" : "NO";
    }

    /**
     * stack이 열린게 하나도 없는데 문자가 ) 잘못된 괄호이므로 No return
     */
    private static String answer2(String value) {

        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            if (c == '(') stack.add(c);
            if (c == ')') {
                if(!stack.contains('(')) return "NO";
                stack.remove(new Character('('));
            }
        }
        return stack.size() == 0 ? "YES" : "NO";
    }

    /**
     * 가장 최근(top) 데이터 삭제 : pop()
     * stack이 비어있는데 문자가 ) 라면 열린적없는데 닫으면 잘못된 괄호이므로 No return
     */
    private static String solution(String value) {

        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            if (c == '(') stack.add(c);
            if (c == ')') {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        return stack.size() == 0 ? "YES" : "NO";
    }
}
