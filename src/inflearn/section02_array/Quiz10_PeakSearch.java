package inflearn.section02_array;

import java.util.Scanner;

public class Quiz10_PeakSearch {

    /**
     * 동 서 남 북 좌표
     */
    static int[] xRange = {0, 0, -1, 1};
    static int[] yRange = {-1, 1, 0, 0};

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

    }

    /**
     * X 축 Y 축에 대한 탐색 좌표를 미리 생성해둔다.
     * 좌표를 하나씩 대입한다.
     * [i][j] 가 행 렬 이 된다.
     * 0, 0일 경우는 동, 북이 0
     * 0, n일 경우는 북, 서가 0
     * i = 0이고 0 < j < n 인 경우 북만 0
     * i = N이고 0 < j < n 인 경우 남만 0
     * j = 0이고 0 < i < n 인 경우 동만 0
     * j = N이고 0 < i < n 인 경우 서만 0
     * @param length
     * @param intArr
     * @return
     */
    private static int answer(int length, int[][] intArr) {
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
            boolean flag = false;

                for (int k = 0; k < 4; k++) {
                    flag = false;
                    int x = i + xRange[k];
                    int y = j + yRange[k];
                    if (x > 0 && x < length && y > 0 && y < length && intArr[i][j] > intArr[x][y]) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }

                }
            if(flag) answer++;
            }
        }
        return answer;
    }

    /**
     * 반대 케이스로 생각해야 한다.
     * 즉, 4방면의 값 비교중 한번이라도 큰값이 나오면 flag값을 false로 하고 반복문을 빠져나온다.
     * 이렇게 할때, 가장자리 0에대한 조건을 세우기도 훨씬 편해진다.
     * @param length
     * @param intArr
     * @return
     */
    private static int solution(int length, int[][] intArr) {
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int x = i + xRange[k];
                    int y = j + yRange[k];
                    /* 현재 행(i)열(j) 의 4방면에 대한 좌표를 각각 이동한 연산(최종 index)값이 경계값 0라인 을 넘지 않은 경우에만 큰지 작은지 체크한다면 0인곳은 체킹하지 않음 */
                    if (x >= 0 && x < length && y >= 0 && y < length && intArr[i][j] < intArr[x][y]) {
                        flag = false;
                        break;
                    }

                }
                if(flag) answer++;
            }
        }
        return answer;
    }


}
