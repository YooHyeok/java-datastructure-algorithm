package programmers.kit.part01_greedy;

/**
 * Lv.3 [그리디] 기지국 설치 <br/>
 * 2024년 01월 27일
 * @see <a href="https://school.programmers.co.kr/learn/courses/10302/lessons/62946">프로그래머스</a>
 * @see <a href="https://u-it.tistory.com/506">블로그 문제풀이 오답노트</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===========첫번째 케이스===========>\n");
//        String result1 = new Solution().solution(11, new int[]{4,11}, 1) == 3 ? "정답": "오답";
        String result1 = new Answer().solution(11, new int[]{4,11}, 1) == 3 ? "정답": "오답";
        System.out.println();
        System.out.println("===========두번째 케이스===========>\n");
//        String result2 = new Solution().solution(16, new int[]{9}, 2) == 3 ? "정답": "오답";
        String result2 = new Answer().solution(16, new int[]{9}, 2) == 3 ? "정답": "오답";
        System.out.println();
        System.out.println("===========최종 답안===========>\n");
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
