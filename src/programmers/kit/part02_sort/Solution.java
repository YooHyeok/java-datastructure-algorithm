package programmers.kit.part02_sort;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를알아내 주세요.
예를들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return하도록 solution함수를 작성해주세요.
*/
public class Solution {

    /**
     * 10의자리의 각 자리와 크기비교
     * 1의자리가 크다면
     * @param numbers 주어진 정수
     * @return 결과값
     */
    public String solution(int[] numbers) {
//        return IntStream.of(numbers).mapToObj(String::valueOf).sorted((o1, o2) ->  -(o1+o2).compareTo(o2+o1)).collect(Collectors.joining(""));
        return IntStream.of(numbers).mapToObj(String::valueOf).sorted((o1, o2) ->  -(o1+o2).compareTo(o2+o1)).reduce((s1, s2) -> (s1+s2).equals("00") ? "0" : s1+s2).get();
    }

}
