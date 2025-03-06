package inflearn.section03_twoPointer;

import java.util.Scanner;

public class Quiz05_SeqNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(answer1(n));
        System.out.println(answer2(n));
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
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    private static int answer2(int n) {
        int sum =0, lp =1, answer =0;
        for (int rp = 1; rp < n; rp++) {
            sum += rp;
            if (sum == n) answer ++;
            while (sum >= n) {
                sum -= lp++;
                if (sum == n) answer++;
            }
        }
        return answer;
    }

}
