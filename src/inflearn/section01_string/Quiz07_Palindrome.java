package inflearn.section01_string;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 회문 문자열 <br/>
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다. <br/>
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요. <br/>
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다. <br/>
 *
 * @Input gooG
 * @Output YES
 */
public class Quiz07_Palindrome {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
        System.out.println(answer(input));
    }
    private static String solution(String input) {
        String str = input.toUpperCase();
        int lt = 0, rt = str.length()-1;
        String answer = "YES";
        while(lt <= rt) {
            if (str.charAt(lt) == str.charAt(rt)) {
                lt++;
                rt--;
                continue;
            }
            answer = "NO";
            break;

        }
        return answer;
    }

    private static String answer(String input) {
        String answer = "YES";
        String str = input.toUpperCase();
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            if(str.charAt(i) != str.charAt(length-1-i)) return "NO";
            answer = "YES";
            break;
        }
        return answer;
    }

}
