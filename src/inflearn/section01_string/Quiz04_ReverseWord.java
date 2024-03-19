package inflearn.section01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 단어 뒤집기 <br/>
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요. <br/>
 * <br/>
 * [입력설명] <br/>
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다. <br/>
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다. <br/>
 * <br/>
 * [출력설명] <br/>
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다. <br/>
 *
 * @Input 3, good, Time, Big
 * @Output doog, emiT, giB
 * @Tip
 *         String str = "asd";
 *         String answer = "";
 *         for(String ch : str.split("")){
 *             answer = ch + answer;
 *         }
 *         for (int i = 0; i < str.length(); i++){
 *             answer += str.charAt(i) + answer;
 *         }
 */
public class Quiz04_ReverseWord {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String [] inputStringArr = new String[n];
        for (int i = 0; i < n; i++) {
            inputStringArr[i] = in.next();
        }
        for (String word : solution(inputStringArr)) System.out.println(word);
        for (String word : solution2(inputStringArr)) System.out.println(word);
        for (String word : answer(inputStringArr)) System.out.println(word);


    }
    private static String[] solution(String[] inputStringArr) {
        for (int i = 0; i < inputStringArr.length; i++) {
            char[] charArr = inputStringArr[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = charArr.length-1; j >= 0 ; j--) {
                sb.append(charArr[j]);
            }
            inputStringArr[i] = sb.toString();
        }
        return inputStringArr;
    }

    private static String[] solution2(String[] inputStringArr) {
        for (int i = 0; i < inputStringArr.length; i++) {
            String temp = "";
            for (String input : inputStringArr[i].split("")) {
                temp = input + temp;
            }
            inputStringArr[i] = temp;
        }
        return inputStringArr;
    }

    private static List<String> answer(String[] inputStringArr) {
        List<String> answer = new ArrayList<>();
        for (String word :inputStringArr) {
            answer.add(new StringBuilder(word).reverse().toString());
        }
        return answer;
    }

}