package inflearn.section01_string;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 대소문자 변환 <br/>
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정 문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다. <br/>
 * 문자열은 영어 알파벳으로만 구성되어 있습니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다. <br/>
 *
 * @Input StuDY
 * @Output sTUdy
 */
public class Quiz02_ConvertToUpperLower {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        StringBuffer sb = new StringBuffer();
        for (char character :input.toCharArray()) {
            sb.append(Character.isUpperCase(character) ? Character.toLowerCase(character) : Character.toUpperCase(character));
        }
        return sb.toString();
    }

}
