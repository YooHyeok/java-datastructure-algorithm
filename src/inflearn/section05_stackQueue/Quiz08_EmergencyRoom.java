package inflearn.section05_stackQueue;

import java.util.*;

public class Quiz08_EmergencyRoom {
    static class Person{
        int id;
        /** * 변수에 대한 설명*/
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", priority=" + priority +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(answer(N, M, arr));
    }

    private static int answer(int N, int M, int[] arr) {
        int count = 1;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) Q.add(new Person(i, arr[i]));
        while (!Q.isEmpty()) {
            Person temp = Q.poll(); // 일단 하나 꺼내고 임시저장
            for (Person p : Q) {
                if (temp.priority < p.priority) { // 현재 꺼낸 값을 제외한 나머지 값중, 더 큰값 존재한다면 맨 뒤로옮기고 임시저장변수 비움
                    Q.offer(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) { // temp가 null이 아니라면 현재 꺼낸값이 최대값이므로, pk값 비교. pk값 일치시 count 즉시 return 아니라면 순서 증가
                if(temp.id == M) return count;
                count ++;
            }

        }
        return count;
    }

}
