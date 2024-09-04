package inflearn.section02_array;

import java.util.*;
import java.util.stream.IntStream;

public class Quiz02_VisibleStudent {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int index = in.nextInt();
        int[] intArr = new int[index];
        for (int i = 0; i < index; i++) {
            intArr[i] = in.nextInt();
        }
        System.out.println(solution(intArr));
        System.out.println(answer(intArr));
        System.out.println(stream(intArr));

    }
    private static int solution(int[] ints) {
        int answer = 0;
        int max = 0;
        for (int i : ints) {
            if (max < i) {
                max = i;
                answer++;
            }
        }
        return answer;
    }
    private static int answer(int[] ints) {
        int answer=1, max = ints[0];
        for(int i=1; i<ints.length; i++){
            if(ints[i]>max){
                max=ints[i];
                answer++;
            }
        }
        return answer;
    }

    /**
     * <pre>
     * 0~7까지 8개 범위 요소 순차 필터링
     * [ 130(0), 135(1), 148(2), 140(3), 145(4), 150(5), 150(6), 153(7) ]
     * [필터링 조건] : 현재 index값 > 현재 index 기준 직전 요소 비교 최대값
     * [true] 130(0) >  MIN(orElse)
     * [true] 135(1) >  130
     * [true] 148(2) >  135
     * [flse] 140(3) >! 148
     * [flse] 145(4) >! 148
     * [true] 150(5) >  148
     * [flse] 150(6) >! 150
     * [true] 153(7) >  150
     * </pre>
     * @param ints
     * @return
     */
    private static int stream(int[] ints) {
        // 0~길이-1(7)까지 8개의 범위 요소 순차 필터링
        return (int) IntStream.range(0, ints.length) // 0, 1, 2, 3, 4, 5, 6, 7
                .filter(i ->
                        ints[i] > IntStream.range(0, i)
                                .map(j -> ints[j]) // []
                                .max()
                                .orElse(Integer.MIN_VALUE)// i가 0일 경우 비교 불가로 해당 코드 적용됨
                )
                .count();
    }
}
