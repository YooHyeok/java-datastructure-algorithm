package inflearn.section05_stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Quiz02_RemoveParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        System.out.println(answer(value));
        System.out.println(solution(value));
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
    
    public static String solution(String str){
        String answer="";
        Stack<Character> stack=new Stack<>();
        for(char x : str.toCharArray()){
            if(x==')'){
                while(stack.pop()!='(');
            }
            else stack.push(x);
        }
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
        return answer;
    }
}
