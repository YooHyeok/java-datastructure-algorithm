package inflearn.section03_twoPointer;

import java.util.Scanner;

public class Quiz05_SeqNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(answer1(n));
    }


    private static int answer1(int n) {
        int answer = 0, sum = 1, pl = 1, pr = 1;
        while(pl < n && pr < n) {
            if (sum < n) sum += ++pr;
            if (sum > n) sum -= pl++;
            if (sum == n) {
                if (pl == n || pr == n) break;
                ++answer;
                sum += ++pr;
                sum -= pl++;
            }
        }
        return answer;
    }

}
