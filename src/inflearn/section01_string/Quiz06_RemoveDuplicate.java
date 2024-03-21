package inflearn.section01_string;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 중복문자제거 <br/>
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.<br/>
 * 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다. <br/>
 *
 * @Input ksekkset
 * @Output kset
 */
public class Quiz06_RemoveDuplicate {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }
    private static String solution(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                chars[j] = chars[j] == chars[i] ? 0 : chars[j];
            }
        }
        for(char c: chars) if (c != 0) sb.append(c);
        return String.valueOf(sb);
    }

}
