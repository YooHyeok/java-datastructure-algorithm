package inflearn.section02_array;

import java.util.*;

public class Quiz12_Mentoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(answer(n, m, arr));
        System.out.println(refactor(n, m, arr));
        System.out.println(solution(n, m, arr));
    }
    static class Pair {
        int mento;
        int menti;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return mento == pair.mento && menti == pair.menti;
        }
        @Override
        public int hashCode() {
            return Objects.hash(mento, menti);
        }
    }

    /**
     * 3,4 / 3,1 / 3,2 / 4,1 / 4,2 / 1,2
     * 4,3 / 4,2 / 4,1 / 3,2 / 3,1 / 2,1
     * 3,1 / 3,4 / 3,2 / 1,4 / 1,2 / 4,2
     * 3번의 시험중 모든 시험에서 다 앞서는 경우만 찾는다.
     * @param n
     * @param m
     * @param arr
     * @return
     */
    private static int answer(int n, int m, int[][] arr) {
        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    Pair pair = new Pair();
                    pair.mento = arr[i][j];
                    pair.menti = arr[i][k];
                    boolean b = map.containsKey(pair);
                    Integer count = map.get(pair);
                    map.put(pair, b ? ++count: 1);
                }
            }
        }
        int maxValue = map.entrySet().stream().mapToInt(entry -> entry.getValue()).max().getAsInt(); // 각 시험별 짝 카운트의 max 값
        int count = (int) map.entrySet().stream().filter(entry -> entry.getValue() == maxValue).count();
        return count;
    }

    private static int refactor(int n, int m, int[][] arr) {
        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    Pair pair = new Pair();
                    pair.mento = arr[i][j];
                    pair.menti = arr[i][k];
                    map.put(pair, map.getOrDefault(pair, 1) + 1);
                }
            }
        }
        return (int) map.entrySet().stream().filter(entry -> entry.getValue() == m).count();
    }

    /**
     * i, j, k, s
     * i: 비교대상 고정 학생 (1~n 까지)
     * j: 비교대상 변경 학생 (1~n 까지)
     * (i와 j가 같더라도 해당 케이스는 멘토와 멘티가 될 수 없으므로 속도면에서 큰 차이가 없으므로 따로 검증하지 않아도 된다.)
     * k: [행]시험 횟수(0 ~ m-1 까지)
     * s: [열]등수 (0~n-1까지)
     * 즉, K Loop에서 i와 j의 등수를 각각 구한다.
     * arr[k][s] 즉, 첫번째 루프라면 [시험횟수][등수]에 대한 값이
     * i[학생]값 이라면,s값을 i의 등수인 pi에 저장 / j[학생]값 이라면, s값을 j의 등수인 pj에 저장한다.
     * 시험 횟수인 k loop에서 i의 등수와 j의 등수를 n번 구할때 마다 각 등수를 비교하여 i의 등수가 더 작으면
     * 각 시험횟수별 학생 i와 j가 짝꿍이 가능한 count수를 증가시킨다.
     * (작으면 등수가 더 높으므로)
     * 이렇게 발생한 count수가 m과 같다면 해당 i, j는 모든 시험에서 멘토멘티 짝지을수 있으므로 최종 멘토멘티 횟수를 1회 증가시킨다.
     *
     * @return
     */
    private static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0; // 회차별 짝 카운트
                for (int k = 0; k < m; k++) { // 문제 회차
                    int pi = 0, pj = 0;
                    for (int s = 0; s < n; s++) { // 등수
                        if(arr[k][s] == i) pi = s; // 등수 저장
                        if(arr[k][s] == j) pj = s; // 등수 저장
                    }
                    if(pi < pj) count ++;
                }
                if(count == m) answer ++;
            }
        }
        return answer;
    }

}
