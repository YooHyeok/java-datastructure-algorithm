package inflearn.section01_string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문장 속 단어 <br/>
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. <br/>
 * 문장속의 각 단어는 공백으로 구분됩니다. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. <br/>
 * 문자열은 영어 알파벳으로만 구성되어 있습니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위치한 단어를 답으로 합니다. <br/>
 *
 * @Input it is time to study
 * @Output study
 */
public class Quiz03_MostLongWord {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String[] inputArr = input.split(" ");
        int max = 0;
        String answer = null;
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i].length() > max) {
                max = inputArr[i].length();
                answer = inputArr[i];
            }
        }
        return answer;
    }
}
