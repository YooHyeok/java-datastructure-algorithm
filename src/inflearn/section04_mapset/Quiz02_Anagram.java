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
        System.out.println(answer3(str1, str2));
        System.out.println(solution(str1, str2));
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

    /**
     * 혹은 getOrDefault를 0으로 간 뒤
     * 음수 혹은 양수가 나오면 두 값의 길이가 일치하지 않는것이기 때문에, 바로 No의값을 리턴한다.
     * 만약 비교값/대상값에서 특정 알파벳 두 값의 갯수가 일치하다면 0이 나올수밖에 없다.
     */
    private static String answer3(String str1, String str2) {
        char[] chars = str1.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (map.containsKey(chars2[i])) {
                map.put(chars2[i], map.get(chars2[i]) - 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return "NO";
            }
        }
        return "YES";
    }

    /**
     * 세번째 풀이방식에서의 -1 즉 contain 포함하지 않는 경우에 대한 처리를 함께 미리 처리한 풀이방법이다.
     */
    private static String solution(String s1, String s2){
//        String answer="YES";
        HashMap<Character, Integer> map=new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x)==0) return "NO";
            map.put(x, map.get(x)-1);
        }
        return "YES";
    }
}
