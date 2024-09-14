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
        System.out.println(solution(length, intArr));

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

    /**
     * 나를 기준으로 다른 학생과 학년별로 몇번 같은반이 되었는지 횟수를 센다. <br/>
     * i는 자신, j는 다른학생, k는 학년으로 3중 loop를 돈다.
     * 만약 다음 학년에서 이전 학년의 같은반이었던 다른 학생이 또 같은반이 되는 경우는 누적으로 값을 세지 않기 위해 <br/>
     * 나를 기준으로 특정 다른 학생이 한 학년에서 최초로 같은 반 기록이 있다면 다음 학년에 대한 갯수를 세지않고 break로 빠져나온다. <br/>
     * @param rowLength
     * @param intArr
     * @return
     */
    private static int solution(int rowLength, int[][] intArr) {
        int answer = 0, max = 0;
        /* i는 나 j 는 다른학생 k는 학년 */
        for (int i = 0; i < rowLength; i++) {
            int count = 0;
            for (int j = 0; j < rowLength; j++) {
                for (int k = 0; k < 5; k++) {
                    if (intArr[i][k] == intArr[j][k]) {
                        count++; // 현재 학년을 기준으로 나와 다른학생의 값이 일치한다면 count증가
                        break;
                    }
                }
            }
            if(max < count) {
                max = count;
                answer = i+1;
            }
        }
        return answer;
    }

}
