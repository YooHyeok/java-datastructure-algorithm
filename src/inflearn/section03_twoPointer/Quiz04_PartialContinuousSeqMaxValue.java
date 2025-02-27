package inflearn.section03_twoPointer;

import java.util.Scanner;

public class Quiz04_PartialContinuousSeqMaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        System.out.println(answer1(n, k, sales) + " ");
    }

    /**
     * 투포인터로 풀어나간다. <br/>
     * 처음부터 값을 더해나간다. <br/>
     * 작으면 뒷값을 이동, 크면 앞값을 이동 <br/>
     * 값이 6이 되면 앞,뒤 모두 한칸씩 이동한다.
     */
    private static int answer1(int n, int k , int[] sales) {
        int pi = 0, pj = 0, count = 0, sum = 0;
        sum = sales[pi];
        while (pi < n && pj < n) {
            if(pi == n-1 || pj == n-1) break;
            if(sum < k)  sum += sales[++pj];
            if (sum > k)  sum -= sales[pi++];
            if (sum == k) { // 같을 경우!
                ++count;
                if(pi == n-1 || pj == n-1) break;
                sum -= sales[pi++];
                sum += sales[++pj];
            }
        }
        return count;
    }

}
