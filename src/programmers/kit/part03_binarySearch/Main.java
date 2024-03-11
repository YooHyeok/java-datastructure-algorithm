package programmers.kit.part03_binarySearch;

/**
 * Lv.2 [정렬] 가장 큰 수 <br/>
 * 2024년 01월 28일
 * @see <a href="https://school.programmers.co.kr/learn/courses/10302/lessons/62948">프로그래머스</a>
 * @see <a href="https://u-it.tistory.com/507">블로그 문제풀이 오답노트</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=========== 케이스 시작 ===========>\n");
//        String result = new Solution().solution( new int[]{120, 110, 140, 150}, 485) == 127 ? "정답": "오답";
        String result = new Answer().solution( new int[]{120, 110, 140, 150}, 485) == 127 ? "정답": "오답";
//        String result = new Refector().solution( new int[]{6,10, 2}).equals("6210") ? "정답": "오답";
        System.out.println();
        System.out.println("=========== 최종 답안 ===========>\n");
        System.out.println("result = " + result);
//        System.out.println("result2 = " + result2);
    }
}
