package inflearn.section04_mapset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz02_Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(answer1(str1, str2));
    }

    private static String answer1(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2) ? "YES" : "NO" ;
    }

}
