package inflearn.section02_array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Quiz07_ScoreCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            intArr[i] = sc.nextInt();
        }

        System.out.println(answer(length, intArr));
        System.out.println(refactor(length, intArr));

    }

    private static int answer(int length, int[] intArr) {
        int answer = 0;
        int score = 0;
        for (int i : intArr) {
            if(i == 1) score ++;
            else score = 0;
            answer += score;
        }
        return answer;
    }

    private static int refactor(int length, int[] intArr) {
        int answer = 0, score = 0;
        for (int i : intArr) {
            answer += score = i == 1 ? ++score : 0;
        }
        return answer;
    }
}
