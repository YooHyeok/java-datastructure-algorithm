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
        System.out.println(solution(a, b));
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

    /**
     * Q에 문자가 존재하면, Q의 첫번째 요소를 꺼내어 비교하고, 다르면 "NO"를 반환
     * 존재하는지 여부를 확인하는 이유는, 존재하지 않는데 꺼내버리면, 순서보장이 안된다.
     * 만약 D와 A를 비교할때 둘이 일치하지않는데 A를 꺼내어 확인하면, Queue에서 A가 삭제되기 때문이다.
     * (Peek후 일치하는 조건에서 Remove하는거면 상관없을것 같다.)
     * 모든 순회가 끝나고, Queue에 값이 남았다면 "NO"를 반환
     * 그렇지 않으면, Queue가 비어있으므로 순차적으로 비교되어 지워진것이기 때문에 "YES"를 반환.
     */
    private static String solution(String a, String b) {
        Queue<Character> Q = new LinkedList<>();
        for (char c : a.toCharArray()) Q.offer(c);
        for (char c : b.toCharArray()) {
            if (Q.contains(c) && Q.poll()!=c) return "NO";

        }
        if (!Q.isEmpty()) return "NO";
        return "YES";
    }

}
