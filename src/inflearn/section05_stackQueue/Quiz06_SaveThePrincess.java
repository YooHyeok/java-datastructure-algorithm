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
        System.out.println(solution(n, k));
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

    /**
     * 큐의 1번부터 k-1번째 값까지 순차적으로 순회하며 큐의 끝으로 이동
     * 이후 k번째 값을 무조건 제거함.
     * 만약 queue에 데이터가 1개남으면 제거하고 해당 데이터를 반환
     * (queue가 비므로 while 종료)
     */
    private static int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.offer(i);
        while (!queue.isEmpty()) { //Queue가 비어있지 않은동안 반복 (비면 중단)
            for (int i = 1; i < k; i++) queue.offer(queue.poll()); // k번 만큼 제거 후 끝에 저장
            queue.poll(); // k번 이후 값 제거....
            if(queue.size() == 1) answer = queue.poll(); // queue에 데이터가 1개남으면 제거하고 해당 데이터를 반환 (queue가 비므로 while 종료)
        }
        return answer;
    }

}
