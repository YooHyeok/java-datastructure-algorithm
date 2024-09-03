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
        System.out.println(answer(intArr));

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
    private static int answer(int[] ints) {
        int answer=1, max = ints[0];
        for(int i=1; i<ints.length; i++){
            if(ints[i]>max){
                max=ints[i];
                answer++;
            }
        }
        return answer;
    }

}
