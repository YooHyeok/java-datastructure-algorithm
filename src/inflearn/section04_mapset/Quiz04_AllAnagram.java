package inflearn.section04_mapset;

import java.util.*;

/**
 * 투 포인터 : 양끝 포인터를 옮기면서 앞과 뒤를 각각 적당히 빼거나 더해준다.
 * 기준이 되는 Map객체와
 * 적당히 빼고 더해가며 동적으로 변하는 부분배열 형태의 Map객체를 비교한다
 * 이때, 비교는 누적으로 구해진 value를 기준으로 비교해나간다.
 *       abc
 * bac  [111] bac true
 * -b+a [201] aca false
 * -a+A [101] caA false
 * -c+a [200] aAa false
 * -a+C [101] Aac false
 * -A+b [111] acb true
 * -a+a [111] cba true
 *        abc
 * baca  [211] baca true
 * -b+A  [201] acaA false
 * -a+a  [201] caAa false
 * -c+c  [201] aAac false
 * -a+b  [111] Aacb false
 * -A+a  [211] acba true
 * -a+a  [211] cbaa true
 */
public class Quiz04_AllAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(answer(s, t));
        System.out.println(refactor(s, t));
        System.out.println(solution(s, t));

    }

    /**
     * 기준 데이터는 미리 Map에 모두 넣어주고
     * 비교할 데이터의 처음값을 초기화한다.
     * [ lp-1(증가) → rp+1(증가) → 동등비교 ] 작업을 반복한다.
     * 위와같이 삭제/추가가 아닌 +1-1로 작업한다면 기준데이터에 없는값은 초기화할때 추가하지 않는다.
     */
    private static int answer(String s, String t){
        int answer = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        /* 기준 데이터 tMap 초기화 */
        for (int i = 0; i < tChars.length; i++) tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        /* 첫 비교용 데이터 sMap 초기화 */
        for (int i = 0; i < tChars.length; i++)
            /* 존재하는 하는 key라면 value 1 증가 */
            if (tMap.containsKey(sChars[i])) sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        if(tMap.equals(sMap)) answer ++;
        for (int rp = tChars.length; rp < sChars.length; rp++) {
            int lp = rp - tChars.length;
            /* 데이터가 존재하면 -1 */
            if (sMap.containsKey(sChars[lp])) sMap.put(sChars[lp], sMap.get(sChars[lp]) - 1);

            /* 존재하는 하는 key라면 value 1 증가 */
            if (tMap.containsKey(sChars[rp])) sMap.put(sChars[rp], sMap.getOrDefault(sChars[rp], 0) + 1);
            if(tMap.equals(sMap)) answer ++;
        }
        return answer;
    }

    /**
     * lp, rp 모두 0,0에서 시작한다.
     */
    private static int refactor(String s, String t) {
        int answer = 0, lp = 0, count = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        /* 기준 데이터 tMap 초기화 */
        for (int i = 0; i < tChars.length; i++) tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        /* TwoPointer Sliding Window 구현 */
        for (int rp = 0; rp < sChars.length; rp++) {
            /* 존재하는 하는 key라면 value 1 증가 */
            if (tMap.containsKey(sChars[rp])) sMap.put(sChars[rp], sMap.getOrDefault(sChars[rp], 0) + 1);
            ++count;
            if(count == t.length()) {
                if(tMap.equals(sMap)) answer++;
                --count;
                // 부분배열의 첫 인덱스 확인 후 감소 - lp 증가, count감소
                if (sMap.containsKey(sChars[lp])) sMap.put(sChars[lp], sMap.get(sChars[lp]) - 1);
                lp++;
            }
        }
        return answer;
    }

    /**
     * 기준 데이터는 미리 Map에 모두 넣어주고
     * 비교할 데이터를 rp의 직전까지 초기화해놓는다.
     * [ rp추가(증가) → 동등비교 → lp삭제(증가) ] 작업을 반복한다.
     * 위와같이 +1-1이 아닌 삭제/추가 방식으로 작업한다면 기준데이터에 없는값은 초기화할때 추가해도 된다. (lp커서의 차례가 오면 삭제할것이므로)
     * 또한 배열로 변경하지않고 charAt으로 접근하여 관리한다.
     */
    private static int solution(String s, String t) {
        int answer = 0, lp = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char tc : t.toCharArray()) tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        for (int i=0; i < t.length()-1; i++) sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        for (int rp = t.length()-1; rp < s.length(); rp++) {
            sMap.put(s.charAt(rp), sMap.getOrDefault(s.charAt(rp), 0) + 1);
            if(tMap.equals(sMap)) answer++;
            sMap.put(s.charAt(lp), sMap.get(s.charAt(lp)) - 1);
            if(sMap.get(s.charAt(lp)) == 0) sMap.remove(s.charAt(lp));
            ++lp;
        }
        return answer;
    }
}



























