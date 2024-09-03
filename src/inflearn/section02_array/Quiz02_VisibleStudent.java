package inflearn.section02_array;

import java.util.*;

public class Quiz02_VisibleStudent {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int index = in.nextInt();
        int[] intArr = new int[index];
        for (int i = 0; i < index; i++) {
            intArr[i] = in.nextInt();
        }
        System.out.println(solution(intArr));

    }
    private static int solution(int[] ints) {
        int answer = 0;
        int max = 0;
        for (int i : ints) {
            if (max < i) {
                max = i;
                answer++;
            }
        }
        return answer;
    }

}
