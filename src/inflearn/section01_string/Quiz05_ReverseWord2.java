package inflearn.section01_string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 특정 문자 뒤집기 <br/>
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다. <br/>
 *
 * @Input a#b!GE*T@S
 * @Output S#T!EG*b@a
 */
public class Quiz05_ReverseWord2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }
    private static String solution(String input) {
        char[] chars = input.toCharArray();
        int lt = 0, rt = chars.length-1;
        while (lt < rt) {
            char temp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = temp;
            lt ++;
            rt --;
        }
        return String.valueOf(chars);
    }
}
