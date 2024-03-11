package programmers.kit.part03_binarySearch;


import java.util.stream.IntStream;

public class Refactor {


    public int solution(int[] budgets, int M) {
        int answer = 0;
        int min = 0;
        int max = IntStream.of(budgets).max().getAsInt();

        for (int budget : budgets) {
            if(budget > max) max = budget; // 만약 최대값보다 지역예산이 크다면, 지역예산을 최대값으로 선택한다.
        }

        while(min <= max) {
            final int mid = (min + max)/2; //중간값 상한액 - stream사용시 가변 변수를 사용하면 안되므로 final변수로 선언해야 한다.

            // 각 지역별 예산에 대한 상한액의 누적합을 연산한다.
            int sum = IntStream.of(budgets)
                    .map(budget -> Math.min(budget, mid)) // 예산값과 상한값 중 최소값을 누적으로 더한다.
                    .sum();

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
