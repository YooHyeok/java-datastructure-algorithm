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

}
