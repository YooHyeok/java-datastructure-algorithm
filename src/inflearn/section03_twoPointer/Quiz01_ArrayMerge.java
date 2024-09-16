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
        for (int i : solution(firstArrLength, firstArr, secondArrLength, secondArr)) {
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

    /**
     * [MergeSort]
     * 두 길이가 일치할 때 까지 loop를 돈다.
     * 첫번째 배열의 요소가 두번째 배열의 요소보다 작을 경우 작은 값인 첫번째 배열의 요소를 리스트에 추가한다.
     * 만약 같거나 크다면 두번째 배열 요소를 리스트에 추가한다.
     * 두 길이가 일치하지 않아졌을 때, 요소의 길이를 넘지않는 조건으로 각각의 Loop를 돌려 남은 요소를 리스트에 추가한다.
     *
     *
     * @param firstArrLength
     * @param firstArr
     * @param secondArrLength
     * @param secondArr
     * @return
     */
    private static ArrayList<Integer> solution(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstArrLength && p2 < secondArrLength) {
            if (firstArr[p1] < secondArr[p2]) answer.add(firstArr[p1++]);
            else answer.add(secondArr[p2++]);
        }
        while (p1 < firstArrLength) answer.add(firstArr[p1++]);
        while (p2 < secondArrLength) answer.add(secondArr[p2++]);
        return answer;
    }

}
