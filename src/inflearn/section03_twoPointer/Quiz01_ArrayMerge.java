package inflearn.section03_twoPointer;

import java.util.Arrays;
import java.util.Scanner;

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

        for (int i : answer(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
    }

    private static int[] answer(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        int[] mergeArr = new int[firstArrLength + secondArrLength];
        for (int i = 0; i < firstArrLength; i++) mergeArr[i]=firstArr[i];
        for (int i = 0; i < secondArrLength; i++) mergeArr[i+firstArrLength]=secondArr[i];
        Arrays.sort(mergeArr);
        return mergeArr;
    }

}
