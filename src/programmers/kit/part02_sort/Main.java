package programmers.kit.part02_sort;

/**
 * Lv.2 [정렬] 가장 큰 수 <br/>
 * 2024년 01월 28일
 * @see <a href="https://school.programmers.co.kr/learn/courses/10302/lessons/62948">프로그래머스</a>
 * @see <a href="https://u-it.tistory.com/507">블로그 문제풀이 오답노트</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===========첫번째 케이스===========>\n");
        String result1 = new Solution().solution( new int[]{6,10, 2}).equals("6210") ? "정답": "오답";
//        String result1 = new Answer().solution( new int[]{6,10, 2}).equals("6210") ? "정답": "오답";
//        String result1 = new Refactor().solution( new int[]{6,10, 2}).equals("6210") ? "정답": "오답";
        System.out.println();
        System.out.println("===========두번째 케이스===========>\n");
        String result2 = new Solution().solution( new int[]{3, 30, 34, 5, 9}).equals("9534330") ? "정답": "오답";
//        String result2 = new Answer().solution( new int[]{3, 30, 34, 5, 9}).equals("9534330") ? "정답": "오답";
//        String result2 = new Refactor().solution( new int[]{3, 30, 34, 5, 9}).equals("9534330") ? "정답": "오답";
        System.out.println();
        System.out.println("===========최종 답안===========>\n");
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
