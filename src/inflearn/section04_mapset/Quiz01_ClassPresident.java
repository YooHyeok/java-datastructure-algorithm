package inflearn.section04_mapset;

import java.util.HashMap;
import java.util.Scanner;

public class Quiz01_ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(answer(n, str));
        System.out.println(solution(n, str));
    }

    private static char answer(int n, String str) {
        char answer = 0; int max = 0;
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (Character key : map.keySet()) {
            if(max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    /**
     * for문 차이
     */
    private static char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
