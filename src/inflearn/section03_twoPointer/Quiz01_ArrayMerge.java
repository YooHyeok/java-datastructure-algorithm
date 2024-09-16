package inflearn.section03_twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz01_ArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstArrLength = sc.nextInt();
        int[] firstArr = new int[firstArrLength];
        for (int i = 0; i < firstArrLength; i++) {
            firstArr[i] = sc.nextInt();
        }
        int secondArrLength = sc.nextInt();
        int[] secondArr = new int[secondArrLength];
        for (int i = 0; i < secondArrLength; i++) {
            secondArr[i] = sc.nextInt();
        }

        for (int i : answer1(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
        for (int i : answer2(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
        for (int i : stream(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
        for (int i : stream2(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
    }

    private static int[] answer1(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        int[] mergeArr = new int[firstArrLength + secondArrLength];
        for (int i = 0; i < firstArrLength; i++) mergeArr[i]=firstArr[i];
        for (int i = 0; i < secondArrLength; i++) mergeArr[i+firstArrLength]=secondArr[i];
        Arrays.sort(mergeArr);
        return mergeArr;
    }
    private static List<Integer> answer2(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < firstArrLength; i++) answer.add(firstArr[i]);
        for (int i = 0; i < secondArrLength; i++) answer.add(secondArr[i]);
        answer.sort((o1, o2) -> o1 - o2);
        return answer;
    }

    private static int[] stream(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        return Stream.concat(Stream.of(firstArr), Stream.of(secondArr)).flatMapToInt(Arrays::stream).sorted().distinct().toArray();
    }
    private static int[] stream2(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        return IntStream.concat(IntStream.of(firstArr), IntStream.of(secondArr)).sorted().toArray();
    }

}
