package inflearn.section01_string;

import java.util.Scanner;

/**
 * 문자 찾기 <br/>
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정 문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. <br/>
 * 문자열은 영어 알파벳으로만 구성되어 있습니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * 첫 줄에 해당 문자의 개수를 출력한다. <br/>
 *
 * @Input Computercooler | c
 * @Output 2
 */
public class Quiz01_CountCharacter {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        System.out.println(solution(input1, input2));
        System.out.println(stream(input1, input2));
    }

    private static int solution(String input1, String input2) {
        int count = 0;
        for (char input1CharArr : input1.toUpperCase().toCharArray()) if (input1CharArr == input2.toUpperCase().charAt(0)) count++;
        return count;
    }

    /**
     * Stream 한줄좌 풀이
     * String.chars() : char단위로 끊어 IntStream으로 변환한다.
     * @param input1
     * @param input2
     * @return
     */
    static int stream(String input1, String input2) {
        return (int)input1.toUpperCase().chars().filter(value -> value == input2.toUpperCase().charAt(0)).count();
    }

}
