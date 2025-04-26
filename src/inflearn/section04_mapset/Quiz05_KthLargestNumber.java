package inflearn.section04_mapset;

import java.util.*;

public class Quiz05_KthLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        System.out.println(answer(n, k, ints));
        System.out.println(solution(n, k, ints));
    }

    /**
     * Set은 중복이 불가능하다.
     * TreeSet은 순차적으로 출력해준다.
     * 즉,
     */
    private static int answer(int n, int k, int[] ints) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    for (int l = 0; l < n; l++) {
                        if (l != j && l != i) {
                            treeSet.add(ints[i] + ints[j] + ints[l]);
                        }
                    }
                }
            }
        }
        return treeSet.toArray().length < k ? -1 : (int)treeSet.toArray()[treeSet.toArray().length-k];
    }

    /**
     * i는 0부터 j는 i+1부터 l은 j+1부터 시작하여 루프를 돌리게 되면 중복이 제거된다.
     */
    private static int solution(int n, int k, int[] ints) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    treeSet.add(ints[i] + ints[j] + ints[l]);
                }
            }
        }
        int count = 0;
        for (int num : treeSet) {
            count++;
            if (count == k) return num;
        }
        return -1;
    }

}
