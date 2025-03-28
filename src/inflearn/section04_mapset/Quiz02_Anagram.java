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
        System.out.println(answer2(str1, str2));
    }

    private static String answer1(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2) ? "YES" : "NO" ;
    }

    /**
     * getOrDefault를 1로 해야하는 이유
     * getOrDefault가 0이면
     * aabbb(2,3) / aaabb일때, 2-3 = -1 / 3-2 = 1
     * 즉 -1 + 1 = 0이 되기 때문에 누적합이 0이되어 모순이 생긴다.
     * 비교해야할 대상 값보다 비교값이 1개 더 많으면 무조건 음수가 나오기 때문이다.
     * 하지만 1로 처리를 한다면
     * aabbb(3,4) / aaabb 일때, 3-3 = 0 / 4-2 = 2
     * 즉 0 + 2 = 2가 되기 때문에 누적합이 0이 아니므로 "NO"가 된다.
     */
    private static String answer2(String str1, String str2) {
        char[] chars = str1.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 1) + 1);
        }
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (map.containsKey(chars2[i])) {
                map.put(chars2[i], map.get(chars2[i]) - 1);
            }
        }
        int sum = 0;
        for (Character character : map.keySet()) {
            sum += map.get(character);
        }
        return sum == 0 ? "YES" : "NO";
    }

}
