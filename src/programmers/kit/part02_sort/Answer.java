package programmers.kit.part02_sort;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Answer {

    /**
     * compareTo 메소드는 대상값과 매개변수의 값을 비교한다.
     * 정수 비교의 경우는 단순하게 크다(1) 같다(0) 작다(-1) 와 같은 결과값을 리턴한다.
     * 문자열 비교의 경우는 사전 순으로 비교하는 데 사용되고, 정수만큼 단순하지는 않다.
     * 기준 값에 비교 대상 값이 포함되어 있을 경우 서로의 문자열 길이의 차이 값을 리턴하고,
     * 만약 포함되어 있지 않다면 각 문자열의 아스키 코드를 비교한다.
     *
     * ABCDEF와 A를 비교하면 A는 ABCDEF에 포함되어 있기 때문에 길이의 차 6 - 1인 5를 반환한다.
     * ABCDEF와 G를 비교하면 G는 ABCDEF에 포함되어 있지 않기 때문에 길이가 아닌 A(97) - G(103)인 -6을 반환한다.
     *
     * 만약 두 문자열의 길이가 모두 1이상일 경우 ABCDEF와 BG에 대한 비교는 A(97) - B(98) 이므로 -1을 반환하지만
     * 예를들어 ABCDEF와 AG를 비교할때 두 값이 일치하는 A는 각각 기준 값 비교대상 값 모두 건너뛴다.
     * 따라서 B(98) - G(103)  = -5 와 같은 연산 결과가 나온다.
     * ABCDEF와 ABG를 비교하면 C(99) - G(103) 인 -4가 되고
     * ABCDEF와 AF를 비교하면 B(98)-F(102)인 -4가 된다.
     */
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        int index = 0;
        while (index < numbers.length) strNums[index] = String.valueOf(numbers[index++]);

        for(int i = 0; i < strNums.length; i++) {
            for(int j = i+1; j < strNums.length; j++) {
                String s1 = strNums[i], s2 = strNums[j];
                if((s1+s2).compareTo(s2+s1) < 0) { // 이전값+다음값 <-> 다음값+이전값 문자열 조합 사전적 정렬
                    strNums[i] = s2;
                    strNums[j] = s1;
                }
            }
        }

        index = 0;
        StringBuffer sb = new StringBuffer();
        while (index < strNums.length) sb.append(strNums[index++]);
        if(sb.toString().charAt(0) == '0') return "0";// 만약 두 값의 합의 차이가 0보다 작을 경우 이후 값을 이전 값과 자리를 바꿔 정렬한다.
        return sb.toString();
    }

}
