package inflearn.section02_array;

import java.util.HashMap;
import java.util.Scanner;

public class Quiz03_RockScissorsPaper {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i]=kb.nextInt();
        }
        for(char x :solution(n, a, b).toCharArray()) System.out.println(x);
        for(char x :answer(n, a, b).toCharArray()) System.out.println(x);
    }

    /**
     * A가 모두 이기는 경우, 비기는경우 외에는 B가 이긴다는것이 핵심 포인트
     */
    private static String solution(int n, int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                sb.append("D");
                continue;
            }
            if (a[i] == 1 && b[i] == 3) {
                sb.append("A");
                continue;
            }
            if (a[i] == 2 && b[i] == 1) {
                sb.append("A");
                continue;
            }
            if (a[i] == 3 && b[i] == 2) {
                sb.append("A");
                continue;
            }
            sb.append("B");
        }

        return String.valueOf(sb);
    }

    private static String answer(int n, int[] a, int[] b) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer += "D";
            else if (a[i] == 1 && b[i] == 3) answer += "A";
            else if (a[i] == 2 && b[i] == 1) answer += "A";
            else if (a[i] == 3 && b[i] == 2) answer += "A";
            else answer += "B";
        }
        return answer;
    }

}
