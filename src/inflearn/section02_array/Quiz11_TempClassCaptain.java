package inflearn.section02_array;

import java.util.Scanner;

public class Quiz11_TempClassCaptain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] intArr = new int[length][5];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 5; j++) {
                intArr[i][j] = sc.nextInt();
            }
        }

        System.out.println(answer(length, intArr));

    }

    private static int answer(int rowLength, int[][] intArr) {
        int answer = 0, rowCount = 0, rowMax = 1, rowSum = 0, totalSum = 0;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                for (int k = 0; k < rowLength; k++) {
                    if(intArr[j][i] == intArr[k][i]) rowCount++;
                }
                if(rowCount > rowMax) {
                    System.out.println("count = " + rowCount);
                    rowMax = rowCount;
                    rowSum += rowMax;
                    if(rowMax > totalSum) {
                        totalSum += rowMax;
                    }
                    answer = j+1;
                    rowCount = 0;
                }
                System.out.println("answer = " + answer);
            }
        }
        return answer;
    }

}
