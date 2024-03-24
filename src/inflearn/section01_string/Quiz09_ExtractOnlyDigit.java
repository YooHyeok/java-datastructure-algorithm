package inflearn.section01_string;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 숫자만 추출 <br/>
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다. <br/>
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205 이 됩니다. <br/>
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 자연수를 출력합니다. <br/>
 *
 * @Input g0en2T0s8eSoft
 * @Output 208
 */
public class Quiz09_ExtractOnlyDigit {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }
    private static int solution(String input) {
        return Integer.parseInt(input.replaceAll("[^0-9]", ""));
    }
}
