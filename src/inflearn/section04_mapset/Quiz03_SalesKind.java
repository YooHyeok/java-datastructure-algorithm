package inflearn.section04_mapset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz03_SalesKind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : answer(n, k, arr)) {
            System.out.print(i + " ");
        }
        for (int i : solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> answer(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());
        int lp = 0, rp = k-1;
        while (lp < n-k || rp < n ) {
            if(lp == n-k || rp == n) break;
            if (map.get(arr[lp]) == 1) {
                map.remove(arr[lp++]);
            } else {
                map.put(arr[lp], map.get(arr[lp++]) - 1);
            }
            map.put(arr[++rp], map.getOrDefault(arr[rp], 0) + 1);
            answer.add(map.size());
        }
        return answer;
    }

    private static  ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        for(int i=0; i<k-1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }
        int lt=0;
        for(int rt=k-1; rt<n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }

}
