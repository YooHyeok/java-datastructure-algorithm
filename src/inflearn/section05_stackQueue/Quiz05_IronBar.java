package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz05_IronBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(answer(str));
        System.out.println(solution(str));
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

    /**
     * 첫 시작 괄호가 무조건 열린다는 전제로 짠 코드.
     * 현재 괄호가 열린 상태라면 stack에 열린괄호를 추가.
     * 현재 괄호가 닫힌 상태라면 stack에서 최신으로 삽입된 열린괄호를 제거한 뒤
     * (닫힌 상태라면 stack이 무조건 비어있지 않은 경우)
     *  만약 이전 문자가 열려있었다면 현재까지 쌓여있는 stack 즉, 열린 괄호의 갯수를 누적으로 저장하고,
     *  아니라면 (이전 문자가 닫혀있었다면) 값을 1 증가시킨다.
     */
    private static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if (str.charAt(i-1) == '(') answer += stack.size();
                else answer ++;
            }
        }
        return answer;
    }
}
