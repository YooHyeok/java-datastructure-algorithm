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
        System.out.println(solution(n, k, sales));
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

    /**
     * 우측 포인터가 가리키는곳이 0 이면 해당 지점을 1로 변경하고 count값을 1 증가시킨다.
     * count값이 k보다 커진다면, 변경한 1지점을 다시 0으로 변경한다.
     * 좌측~우측 까지의 길이 : 우측포인터 - 좌측포인터 + 1
     * count값이 k보다 커지면 변경했던 1을 다시 0으로 로 변경한다고 했으나, 실제로 변경하지 않고 count만 샌다.
     * 즉, count가 k값을 초과하지 않을때까지 pl값을 증가시켜 가며, count값을 감소시킨다.
     * 이후 pl~pr의 길이를 구할때 pl값은 1에서 0으로 변경한 인덱스의 다음인덱스부터 길이를 구해야한다.
     * 위 과정은 1을 0으로 변경하고 해당 index 다음 값으로 pl값을 이동하는것과 같다.
     */
    private static int solution(int n, int k, int[] sales) {
        int count = 0, answer = 0, pl = 0;
        for (int pr = 0; pr < n; pr++) {
            if (sales[pr] == 0) count ++; // 0이면 1씩 카운트
            while(count > k) if(sales[pl] == 0) count--;
            if (answer < pr - pl + 1) answer = pr - pl + 1; // pl조정후 max값 초기화
        }

        return answer;
    }


}
