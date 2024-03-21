package inflearn.section01_string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 유효한 팰린드롬 <br/>
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다. <br/>
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요. <br/>
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다. <br/>
 * 알파벳 이외의 문자들의 무시합니다. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다. <br/>
 *
 * @Input found7, time: study; Yduts; emit, 7Dnuof
 * @Output YES
 */
public class Quiz08_ValidPalindrome {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
        System.out.println(answer(input));
        System.out.println(refactor(input));
    }
    private static String solution(String input) {
        String str = input.toUpperCase().replaceAll("[^A-Z]", "");// 정규식 ^ = 부정 즉, A~Z가 아니면 "" 빈문자로 변경
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
        String answer="NO";
        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp=new StringBuilder(input).reverse().toString();
        if(input.equals(tmp)) answer="YES";
        return answer;
    }
    private static String refactor(String input) {
        return input.toUpperCase()
                .replaceAll("[^A-Z]", "")
                .equals(new StringBuilder(input.toUpperCase().replaceAll("[^A-Z]", "")).reverse().toString())
                ? "YES" : "NO";
    }
}
