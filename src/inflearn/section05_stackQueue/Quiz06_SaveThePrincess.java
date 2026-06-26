package inflearn.section05_stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz06_SaveThePrincess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(answer(n, k));
    }

    /**
     * 12`3`45678
     * 45`6`78-12
     * 78`1`2-45
     * 24`5`-78
     * 78-`2`4
     * 4-7`8`
     * `4`7
     */
    private static int answer(int n, int k) {;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.add(i + 1);
        while (queue.size() > 1) {
            if (count == k-1)  count = 0;
            else {
                queue.add(queue.peek());
                count ++;
            }
            queue.remove();

        }
        return queue.peek();
    }

}
