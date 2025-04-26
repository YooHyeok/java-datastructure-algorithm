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

}
