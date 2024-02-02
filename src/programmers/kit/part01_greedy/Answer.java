package programmers.kit.part01_greedy;


import java.util.LinkedList;
import java.util.Queue;

public class Answer {

    /**
     * @param n 아파트 갯수
     * @param stations 기지국이 설치된 아파트들
     * @param w 전파 도달 거리
     * @return
     */
    public int solution(int n, int[] stations, int w) {
        int answer = 0;


        Queue<Integer> stationsQueue = new LinkedList<>();
        for (int station:stations) stationsQueue.offer(station);
        int curPosition = 1;
        while (curPosition <= n) {
            /**
             * 기지국의 범위 내에 있는지 확인
             * 기지국 범위 맨 왼쪽값보다 현재 위치가 더 크면 범위 바깥이므로
             * answer를 1 증가시킨 뒤 현재 위치를 기지국의 끝 범위보다 한칸 더 늘려서 이동한다.
             * 그렇지 않다면
             */
            if (!stationsQueue.isEmpty() && stationsQueue.peek() - w<= curPosition) {
                curPosition = stationsQueue.poll() + w+1;
            } else {
                answer += 1;
                curPosition += w*2+1 ;

            }
        }
        return answer;
    }

}
