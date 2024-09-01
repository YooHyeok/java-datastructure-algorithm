package inflearn.section01_string;

import java.util.*;

/**
 * 문자열 압축 <br/>
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오. <br/>
 * 단 반복횟수가 1인 경우 생략합니다.<br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 번째 줄에 문자열이 주어진다.<br/>
 * 문자열의 길이는 100을 넘지 않는다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 압축된 문자열을 출력한다. <br/>
 *
 * @Input KKHSSSSSSSE
 * @Output K2HS7E
 */
public class Quiz11_CompressString {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String str = in.next();

        System.out.println(solution("KKHSSSSSSSE"));
        System.out.println(answer("KKHSSSSSSSE"));
        System.out.println(dongil("KKHSSSSSSSE"));
        System.out.println(dongil("KSTTTSEEKFKKKDJJGG"));

    }
    private static String solution_wrong(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i),0) > 0 ? map.get(str.charAt(i))+1 : 1;
            map.put(str.charAt(i), count);
        }
        StringBuilder sb = new StringBuilder();
        for (Character key :map.keySet()) {
            Integer count = map.get(key);
            sb.append(key).append(count > 1? count : "");
        }
        return sb.toString();
    }
    private static String solution(String str) {
        int cursor = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(str.charAt(0)));
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(cursor)==str.charAt(i)) {
                ++count;
                if(i == str.length()-1) sb.append(count); // 마지막 요소에 대한 처리
                continue;
            }
            cursor = i;
            sb.append(count > 1 ? count : "").append(str.charAt(cursor));
            count = 1;

        }
        return sb.toString();
    }
    private static String dongil(String str) {
        String answer = "";
        String c = "";
        int count = 0;

        for(String ch : str.split("")){
            if(c.equals(ch)){
                count++;
                continue;
            }
            answer += c + (count > 1 ? count : "");
            c = ch;
            count = 1;
        }
        answer += c + (count > 1 ? count : "");

        return answer;
    }

    private static String answer(String input) {
        String answer = "";
        input = input + " "; // 마지막 요소에 대한 처리
        int cnt = 1;
        for (int i = 0; i < input.length()-1; i++) { // 마지막 빈문자 전까지 돌도록 처리
            if(input.charAt(i) == input.charAt(i+1)) cnt++;
            else {
                answer += input.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return answer;
    }

    private static String stream(String input) {
        String answer = "";

        return answer;
    }

}
