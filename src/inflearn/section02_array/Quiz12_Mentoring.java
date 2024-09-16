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

}
