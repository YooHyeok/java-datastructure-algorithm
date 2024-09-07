package inflearn.section02_array;

import java.util.*;

public class Quiz05_PrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(wrong_solution(input));
        System.out.println(solution(input));
        System.out.println(answer(input));

    }

    /**
     * 입력받은 숫자를 기준으로 모든 소수를 순차적으로 구해 나갈 리스트를 준비한다.
     * 기본적으로 소수의 가장 작은 값은 2 이므로, 가장 작은 소수 값 2를 소수 리스트에 저장한다.
     * 입력받은 값을 기준으로 가장 작은 소수값인 2부터 시작해서 1씩 증가시켜 나가는 1차 루프에서
     * 순차증가 i값이 소수 리스트의 모든 소수를 순회하며 나머지가 0인지 확인한다.
     * 나머지가 0일 경우 소수가 아니므로 소수여부에 대한 값을 부여하고, 소수를 판별하는 2차 루프를 빠져나온다.
     * 만약 소수가 아니라면, 기준값이 증가되도록 1차 loop로 contiune 하고 소수라면 list에 저장한다.
     * @param input
     */
    private static int wrong_solution(int input) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 2; i <= input; i++) {
            boolean isNotPrime = false;
            for (int prime : primes) {
                if(i % prime == 0) {
                    isNotPrime = true;
                    break;
                }
            }
            if(isNotPrime) continue;
            primes.add(i);
        }
        System.out.println("primes = " + primes);
        return primes.size();
    }

    private static int solution(int input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < input; i++) {
            numbers.add(i+1);
        }
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (j != i && numbers.get(j) % numbers.get(i) == 0) {
                    numbers.remove(j);
                }
                count++;
            }
        }
        System.out.println("count = " + count);
        return numbers.size();
    }

    /**
     * 1부터 입력받은 값 까지의 모든 정수를 담을 수 있는 길이의 배열을 생성한다.
     * (1부터 이므로 n+1로 지정해야함 - 실제는 0도 포함하므로 0 ~ n까지 n+1개)
     * 소수를 판별할 값을 소수의 최소값 2로 지정하여 Loop를 돌린다.
     * 배열은 모두 0으로 초기화되어 있고, i값은 2부터 시작하여 해당 배열인덱스가 0인지 확인한다.
     * (index 0과 1은 값이 0,1 이므로 소수에 포함되지 않기 때문에 index 2부터 시작한다.)
     */
    private static int answer(int n) {
        int answer = 0;
        int count = 0;
        int[] check = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    check[j] = 1;
                    count++;
                }
            }
        }
        System.out.println("check = " + Arrays.toString(check));
        System.out.println("count = " + count);
        return answer;
    }

}
