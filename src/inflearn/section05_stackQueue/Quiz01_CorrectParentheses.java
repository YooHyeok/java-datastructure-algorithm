package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz01_CorrectParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        System.out.println(answer1(value));
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

}
