package programmers.kit.part01_greedy;

import java.util.Arrays;

/*
N개의 아파트가 일렬로 쭉 늘어서 있습니다.
이 중에서 일부 아파트 옥상에는 4g 기지국이 설치되어 있습니다.
기술이 발전해 5g 수요가 높아져 4g 기지국을 5g 기지국으로 바꾸려 합니다.
그런데 5g 기지국은 4g 기지국보다 전달 범위가 좁아, 4g 기지국을 5g 기지국으로 바꾸면 어떤 아파트에는 전파가 도달하지 않습니다.
예를 들어 11개의 아파트가 쭉 늘어서 있고, [4, 11] 번째 아파트 옥상에는 4g 기지국이 설치되어 있습니다.
만약 이 4g 기지국이 전파 도달 거리가 1인 5g 기지국으로 바뀔 경우 모든 아파트에 전파를 전달할 수 없습니다.
(전파의 도달 거리가 W일 땐, 기지국이 설치된 아파트를 기준으로 전파를 양쪽으로 W만큼 전달할 수 있습니다.)
*/
public class Solution {

    /**
     * @param n 아파트 갯수
     * @param stations 기지국이 설치된 아파트들
     * @param w 전파 도달 거리
     * @return
     */
    int answer, coverage = 0;

    public int solution(int n, int[] stations, int w) {

        coverage = w*2+1;

        int curPosition = 1; // 현재 위치를 저장
        for (int station : stations) {
            //필요 기지국 갯수계산: 기준거리=현재 기지국의 왼쪽 끝 범위 - 현재 위치
            getAnswer((station - w) - curPosition);
            curPosition = (station + w) + 1; // 현재 기지국 우측바깥 위치(기지국의 우측 끝 + 1)를 현재위치에 저장
        }
        if (curPosition <= n) getAnswer(n-curPosition+1);
        // 기지국 루프 종료 후 현재 위치가 아파트 끝 번호보다 작거나 같으면 최소 한개의 아파트가 남아있다는 뜻
        //필요 기지국 갯수계산: 기준거리=마지막 아파트부터 현재 위치까지의 거리

        return answer;
    }

    public void getAnswer(int interval) {// 나눴을때 몫이 1 혹은 나머지가 1이면 answer 증가
        int quotient = interval / coverage; // 몫
        if (quotient > 0) answer += quotient;// 몫이 1보다 크면 몫만큼 증가
        if (interval % coverage > 0) ++answer;// 나머지가 1보다 크면
    }
}
