package inflearn.section02_array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz06_ReversePrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            intArr[i] = sc.nextInt();
        }
        for (int i : solution(length, intArr)) {
            System.out.print(" " + i);
        }

    }

    /**
     * 소수 판별 함수
     * 기본적으로 소수는 1과 자기자신으로만 나누어지는 수 이다.
     * 1과 자기자신을 제외한 수 중 나누어 떨어지는 수가 있다면 무조건 소수가 아니다.
     * @param number
     * @return
     */
    private static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    private static List<Integer> solution(int length, int [] intArr) {
        int[] numbers = IntStream.of(intArr)
                .mapToObj(value -> new StringBuilder(String.valueOf(value)).reverse().toString())
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if(isPrime(number)) primes.add(number);

        }
        return primes;
    }

}
