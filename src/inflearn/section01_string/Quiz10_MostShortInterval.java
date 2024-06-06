package inflearn.section01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 가장 짧은 문자거리 <br/>
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.<br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다.<br/>
 * 문자열과 문자는 소문자로만 주어진다. <br/>
 * 문자열의 길이는 100을 넘지 않는다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다. <br/>
 *
 * @Input teachermode e
 * @Output 1 0 1 2 1 0 1 2 2 1 0
 */
public class Quiz10_MostShortInterval {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char ch = in.next().charAt(0);
        for (int i : solution(str, ch)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : solution2(str, ch)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : answer(str, ch)) {
            System.out.print(i + " ");
        }
    }
    private static int[] solution(String str, char ch) {
        char[] charArr = str.toCharArray();
        int[] charIntervalArr = new int[str.toCharArray().length];
        List<Integer> charIndexList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) { // e에 대한 위치 미리 담기
            if(charArr[i] == ch) charIndexList.add(i);
        }
        for (int i = 0; i < charArr.length; i++) {
            int temp = 0;
            for (int j = 0; j < charIndexList.size(); j++) {
                if (j == 0) temp = Math.abs(i - charIndexList.get(j)); // e에대한 위치의 처음 요소라면 거리 최소값 초기값으로 투척
                temp = temp < Math.abs(i - charIndexList.get(j)) ? temp : Math.abs(i - charIndexList.get(j)); // 거리 최소값 보다 [크다면? 초기 최소값] : [작다면? 현재 거리값]
            }
            charIntervalArr[i] = temp;
        }
        return charIntervalArr;
    }


    private static int[] solution2(String input, char ch) {
        char[] charArr = input.toCharArray();
        int[] idxArr = new int[charArr.length];
        int p = charArr.length;
        for (int i = 0; i < charArr.length; i++) {
            p = charArr[i] == ch ? 0 : p+1; // 문자열의 현재 커서 요소가 ch라면 ? 0 : ++p
            idxArr[i] = p;
        }
        p = charArr.length;
        for (int i = charArr.length-1; i >= 0; i--) {
            p = charArr[i] == ch ? 0 : p+1;
            idxArr[i] = idxArr[i] > p ? p : idxArr[i];
        }
        return idxArr;
    }

    private static int[] answer(String input, char ch) {
        int[] answer = new int[input.length()];
        int p = 1000;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ch) {//toCharArray대신 charAt으로 문자값 반환 및 확인.
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = input.length()-1; i >= 0; i--) {
            if(input.charAt(i) == ch) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
}
