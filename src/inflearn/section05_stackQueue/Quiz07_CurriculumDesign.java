package inflearn.section05_stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz07_CurriculumDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(answer(a, b));
    }

    /**
     * 필수 과목을 Queue 에 넣는다.
     * 설계한 값을 하나씩 순차로 돌면서 Queue에서 Peek한뒤 값과 일치하면 Queue에서 제거한다.
     * 이렇게하면 그다음 Queue값에 대한 비교를 하기때문에 순서비교가 보장된다.
     */
    private static String answer(String a, String b) {;
        Queue<Character> queue = new LinkedList<>();
        for (char c : a.toCharArray()) queue.add(c);
        for (char c : b.toCharArray()) {
            if (queue.isEmpty()) return "YES";
            if (queue.peek() == c) queue.remove();
        }
        return "NO";
    }

}
