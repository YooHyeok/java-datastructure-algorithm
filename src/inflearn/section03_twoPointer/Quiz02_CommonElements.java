package inflearn.section03_twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz02_CommonElements {
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

        for (int i : wrong_answer(firstArrLength, firstArr, secondArrLength, secondArr)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 1차 loop를 가장한 n^2 이므로 TimeLimitExceded Runtime에러가 발생한다.
     */
    private static List<Integer> wrong_answer(int firstArrLength, int[] firstArr, int secondArrLength, int[] secondArr) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstArrLength) {
            if(p1 != firstArrLength && p2 == secondArrLength) { // p1이 모든 p2의 순회를 마쳤을 때 p2를 초기화하여 다음 커서로 이동한다.
                p2 = 0;
                p1++;
                continue;
            }
            if (firstArr[p1] == secondArr[p2]) {
                answer.add(firstArr[p1]);
            }
            p2++;
        }
        answer.sort((o1, o2) -> o1-o2);
        return answer;
    }

}
