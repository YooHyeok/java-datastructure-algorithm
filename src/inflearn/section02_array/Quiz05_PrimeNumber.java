package inflearn.section02_array;

import java.util.*;

public class Quiz05_PrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(wrong_solution(input));
        System.out.println(solution(input));

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
}
