package inflearn.section02_array;

import java.util.List;
import java.util.Scanner;

public class Quiz04_FibonacciSequence {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
        answer1(n);
        for (int x : answer2(n)) System.out.print(x + " ");
    }

    // 1 1 2 3 5 8 13
    private static void solution(int n) {
        int temp = 0; // 임시 저장
        int cur = 1; // 현재행
        int next = 1; // 다음행
        for (int i = 0; i < n; i++) {
            System.out.print(cur + " ");
            temp = next;
            next = cur + next;
            cur = temp;
        }
    }

    /**
     * 배열을 사용하지 않고 손코딩하는 경우
     * @param n
     */
    private static void answer1(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }

    /**
     * 피보나치 수열 규칙중 첫번째, 두번째 두개의 항은 무조건 1,1 이다.
     * @param n
     */
    private static int[] answer2(int n) {
        int[] answer = new int[n];
        answer[0] = answer[1] = 1;
        for(int i = 2; i < n; i++)
            answer[i] = answer[i-2] + answer[i - 1];
        return answer;
    }

}
