package inflearn.section03_twoPointer;

import java.util.Scanner;

public class Quiz06_PartContMaxSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        System.out.println(wrong_answer(n, k, sales));
    }
    
    /**
     *
     * @param n
     * @param k
     * @param sales
     * @return
     */
    private static int wrong_answer(int n, int k , int[] sales) {
        int count = k, answer = 0, value = 0, pl = 0, pr = 0;
        while (pl < n && pr < n) {
            if (sales[pr] == 0) {
                sales[pr] = 1;
                --count;
            }
            if (count == 0) {
                value = 0;
                for (int i = pl; i < n; i++) {
                    if (sales[i] == 0) break;
                    ++value;
                }
                ++pl;
                ++count;
                if (answer < value) answer = value;
            }
            ++pr;
        }
        return answer;
    }

}
