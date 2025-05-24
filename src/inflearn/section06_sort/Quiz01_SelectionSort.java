package inflearn.section06_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz01_SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i : solution(N, nums)) {
            System.out.print(i + " ");
        }

    }

    /**
     * 선택정렬
     * 첫번쨰 요소부터 순회하며, 최소값을 찾아 swap
     * 5 13 11 7 23 15
     * 5 7 11 13 23 15
     * 5 7 11
     */
    private static int[] answer(int N, int[] nums) {
        for (int i = 0; i < N; i++) { // 최소값과 변경될 순회값
            int min = nums[i];
            int minIdx = i;
            for (int j = i+1; j < N; j++) {
                /* 최소값이라면 최소값에 저장하고, 최소값위치를 임시 저장 */
                if (min > nums[j]) {
                    min = nums[j];
                    minIdx = j;
                }
            }
            /* 현재 순회 값과 최소값 swap */
            nums[minIdx] = nums[i];
            nums[i] = min;
        }
        return nums;
    }

    /**
     * 최소값이 매번 저장하지 않는 대신, minIdx값을 저장하여 해당 값과 순차적으로 비교해나간다.
     * nums[idx]를 기준으로 nums[j]의 위치가 반복 증가하며 끝까지 비교한다.
     * (초기 idx = i 이고 더 작은값에 대한 index로 초기화된다.)
     * 마지막까지 돌며, 값이 더 큰지 비교하고, 값이 더 작다면, 반복적으로 idx에 해당 index를 저장한다.
     * 반복문 종료 이후 i와 idx 값의 위치를 서로 변경한다.
     */
    private static int[] solution(int N, int[] nums) {
        for (int i = 0; i < N; i++) {
            int idx = i;
            for (int j = i+1; j < N; j++) {
                if(nums[idx] > nums[j]) idx = j;
            }
            System.out.println("nums[idx] = " + nums[idx]);
            /* swap한다 */
            int tmp = nums[i]; //
            nums[i] = nums[idx]; // 최소값을
            nums[idx] = tmp;
        }
        return nums;
    }
}
