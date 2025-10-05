package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz04_postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(answer(str));
    }

    /**
     * 숫자를 Stack에 순차적으로 쌓다가 연산자가 나오면 Stack에서 값을 꺼내 연산자로 연산한다.
     * 2번 꺼내어 연산하고, 다시 Stack에 저장.
     * 352+*9- 이라면 먼저 숫자 3, 5, 2를 Stack에 순차적으로 저장
     * 다음 +연산에 대해 2, 5를 순차적으로 꺼내어 + 연산
     * 결과값 7을 다시 스택에 저장.
     * 다시 *연산이 나오고 7, 3을 순차적으로 꺼내어 * 연산
     * 결과값 21을 다시 스택에 저장.
     * 다음은 숫자이므로 Stack에 추가.
     * 21, 9인상태에서 -연산이 나왔으므로 9, 21을 순차적으로 꺼내어 0연산
     * 결과값 -12를 다시 스택에 저장.
     * 이떄 음수값은 무조건 -연산에서 나오기 때문에 -연산에 대해서만 절대값을 씌운다.
     */
    private static int answer(String str) {
        String operator = "+-*/";
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if(stack.size() > 1 && operator.contains(String.valueOf(str.charAt(i)))){
                switch (str.charAt(i)) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        stack.push(Math.abs(stack.pop() - stack.pop()));
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop() / stack.pop());
                        break;
                }
            } else stack.push(str.charAt(i) - '0');
        }
        return stack.pop();
    }

}
