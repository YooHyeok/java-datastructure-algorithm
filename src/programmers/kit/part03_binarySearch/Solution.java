package programmers.kit.part03_binarySearch;



import java.util.Arrays;
import java.util.stream.IntStream;

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를알아내 주세요.
예를들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return하도록 solution함수를 작성해주세요.
*/
public class Solution {

    /**
     *
     * @param budgets : 각 지방의 예산
     * @param M : 총 예산액
     * @return
     */
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int min = 1;
        for (int budget : budgets) {
            int max = budget;
            int mid = (min+max)/2;
            while (min < mid) {
                mid = (min+max)/2;
                if (mid * budgets.length < M ) { //485
                    min = mid;
                    if(min == max) {
                        answer += mid;
                        break;
                    }
                    continue;
                }
                if(mid * budgets.length > M ) {
                    max = mid;
                }
            }
        }
        return answer;
    }

}
