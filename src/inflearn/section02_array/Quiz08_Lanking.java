package inflearn.section02_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Quiz08_Lanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            intArr[i] = sc.nextInt();
        }

        for (Integer integer : answer(length, intArr)) {
            System.out.print(integer + " ");
        }
        for (Integer integer : solution(length, intArr)) {
            System.out.print(integer + " ");
        }

    }

    private static List<Integer> answer(int length, int[] intArr) {
        List<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int rank = length;
            for (int j = 0; j< length; j++) {
                if(i != j && intArr[i] >= intArr[j]) {
                    rank--;
                }
            }
            ranks.add(rank);
        }
        return ranks;
    }

    /**
     * 나의 풀이와 같지만, rank 점수를 반대로 늘려나감으로써,
     * 동일한 값에 대한 높은점수 처리에 대한 조건이 필요없게 되었다.
     * @param length
     * @param intArr
     * @return
     */
    private static int[] solution(int length, int[] intArr) {
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int rank = 1;
            for (int j = 0; j < intArr.length; j++) {
                if (intArr[j] > intArr[i]) {
                    rank ++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }

}
