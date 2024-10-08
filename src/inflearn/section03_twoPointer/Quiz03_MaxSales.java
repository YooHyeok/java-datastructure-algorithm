package inflearn.section03_twoPointer;

import java.util.Scanner;

public class Quiz03_MaxSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        System.out.println(wrong_answer(n, k, sales) + " ");
        System.out.println(answer(n, k, sales) + " ");
        System.out.println(solution(n, k, sales) + " ");
    }

    /**
     * n: 매출기록 전체 연속 일수
     * k: 최대 매출액을 구할 연속 일수
     * i는 기준값으로 사용한다. (j loop종료시 커서를 1칸씩 옮긴다.)
     * j는 부분배열로 사용한다.
     */
    private static int wrong_answer(int n, int k , int[] sales) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < k+i; j++) {
                if(j >= n) break;
                sum += sales[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int answer(int n, int k , int[] sales) {
        int max = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        max = sum;
        for (int j = 0; j < n; j++) {
            if(j == n-k) break;
            sum = sum - sales[j] + sales[j+k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int solution(int n, int k, int[] arr){
        int answer, sum=0;
        for(int i=0; i<k; i++) sum+=arr[i];
        answer=sum;
        for(int i=k; i<n; i++){
            sum+=(arr[i]-arr[i-k]);
            answer=Math.max(answer, sum);
        }
        return answer;
    }

}
