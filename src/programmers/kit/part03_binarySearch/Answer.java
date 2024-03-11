package programmers.kit.part03_binarySearch;


public class Answer {


    public int solution(int[] budgets, int M) {
        int answer = 0;
        int min = 0;
        int max = 0;

        for (int budget : budgets) {
            if(budget > max) max = budget; // 만약 최대값보다 지역예산이 크다면, 지역예산을 최대값으로 선택한다.
        }
        int count = 0;
        while(min < max) {
            int mid = (min + max)/2; //중간값 상한액
            int sum = 0;

            // 각 지역별 예산에 대한 상한액의 누적합을 연산한다.
            for (int budget : budgets) {
                if(budget > mid) sum += mid; // 예산이 상한값보다 클 경우 상한값을 누적.
                else sum+= budget; // 예산이 상한값과 같거나 작을경우 예산값을 누적한다.
            }
            if(sum <= M) { // 총 합이 총 예산보다 작다면 상향조정 해야한다.
                min = mid + 1; // [상향조정] 1 2 일 경우 상한액이 1 인데 그걸 다시 mid
                answer = mid; // 답 갱신
            } else { //총 합이 총 예산보다 작으면 하향조정 해야한다.
                max = mid - 1; // [하향조정]
            }
        }
        return answer;
    }

}
