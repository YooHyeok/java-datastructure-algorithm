package inflearn.section02_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Quiz09_BingoBoardMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] intArr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                intArr[i][j] = sc.nextInt();
            }
        }

        System.out.println(answer(length, intArr));
        System.out.println(solution(length, intArr));
        System.out.println(stream(length, intArr));

    }

    private static int answer(int length, int[][] intArr) {

        /* 대각선 누적합, 최대값 */
        int xXSum = 0, xYSum = 0, max = 0;

        for (int i = 0; i < length; i++) {
            /* 행, 열 누적합 */
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < length; j++) {
                /* 각 행의 누적합 저장*/
                rowSum += intArr[i][j];
                /* 각 열의 누적합 저장*/
                colSum += intArr[j][i];
            }
            if (rowSum > max) max = rowSum;
            if (colSum > max) max = colSum;
            /* 대각선의 누적 합 저장*/
            xXSum += intArr[i][i];
            xYSum += intArr[i][length-1-i];
        }
        /* 대각선 의 합 추가*/
        if (xXSum > max) max = xXSum;
        if (xYSum > max) max = xYSum;

        return max;
    }

    private static int solution(int length, int[][] intArr) {

        /* 대각선 누적합, 최대값 */
        int xXSum = 0, xYSum = 0, max = 0;

        for (int i = 0; i < length; i++) {
            /* 행, 열 누적합 */
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < length; j++) {
                /* 각 행의 누적합 저장*/
                rowSum += intArr[i][j];
                /* 각 열의 누적합 저장*/
                colSum += intArr[j][i];
            }
            /* 행/열 값 최대값 처리 */
            max = Math.max(max, colSum);
            max = Math.max(max, rowSum);

            /* 대각선의 누적 합 저장*/
            xXSum += intArr[i][i];
            xYSum += intArr[i][length-1-i];
        }
        /* 대각선 의 합 최대값 처리*/
        max = Math.max(max, xXSum);
        max = Math.max(max, xYSum);

        return max;
    }

    /**
     * max를 구하는 방법을 Stream으로 처리했다. <br/>
     * mapToInt를 활용하여 IntStream으로 변환하여 Optional의 max값을 구한다. <br/>
     * @param length
     * @param intArr
     * @return
     */
    private static int stream(int length, int[][] intArr) {
        List<Integer> sums = new ArrayList<>();
        /* 대각선 누적합, 최대값 */
        int xXSum = 0, xYSum = 0, max = 0;

        for (int i = 0; i < length; i++) {
            /* 행, 열 누적합 */
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < length; j++) {
                /* 각 행의 누적합 저장*/
                rowSum += intArr[i][j];
                /* 각 열의 누적합 저장*/
                colSum += intArr[j][i];
            }
            /* 행/열 값 최대값 처리 */
            sums.add(colSum);
            sums.add(rowSum);

            /* 대각선의 누적 합 저장*/
            xXSum += intArr[i][i];
            xYSum += intArr[i][length-1-i];
        }
        /* 대각선 의 합 최대값 처리*/
        sums.add(xXSum);
        sums.add(xYSum);

        return sums.stream().mapToInt(value->value).max().getAsInt();
    }

}
