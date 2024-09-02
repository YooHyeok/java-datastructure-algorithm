package inflearn.section02_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz01_LargeNumberPrint {
    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//        int index = in.nextInt();
//        int[] intArr = new int[index];
//        for (int i = 0; i < index; i++) {
//            intArr[i] = in.nextInt();
//        }
//        System.out.println(solution(input));

        System.out.println(solution(new int[]{130, 135, 148, 140, 145, 150, 153}));

    }

    private static int solution(int[] ints) {
        int answer = 0;
        int max = 0;
        for (int i : ints) {
            if (max < i) {
                max = i;
                answer++;
            }
        }
        return answer;
    }

}
