package inflearn.section02_array;

import java.util.List;
import java.util.Scanner;

public class Quiz04_FibonacciSequence {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
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

}
