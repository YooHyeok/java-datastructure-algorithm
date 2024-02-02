package programmers.kit.part01_greedy;

import java.util.Arrays;

public class Refactor {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int index = B.length-1;
        for (int i = A.length-1; i>=0; i++) {
                if(A[i] < B[index]) {
                    index--;
                    answer++;
                    B[index] = 0; // B의 값을 사용할수 없으므로 제거 - 0이면 어떠한 숫자와 비교해도 가장 작은값이되므로 다음 탐색에서 들어오지 않게 된다.
                    break;
                }
        }

        return answer;
    }

}
