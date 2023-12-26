package datastructure.non_liner_structure.queue;

import java.util.Arrays;

public class ArrayCircleQueue implements Queue{

    private int front; // 배열의 가장 첫 인덱스로 사용된다.
    private int rear; // 배열의 마지막 인덱스로 사용된다.
    private int queueSize;
    private char queueArr[];

    public ArrayCircleQueue(int queueSize) {
        front = 0;
        rear = 0;
        this.queueSize = queueSize+1; // 공간 1개를 포화상태 용도로 사용하기 때문에 1을 증가시킨다.
        queueArr = new char[this.queueSize];
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public boolean isFull() {
        /**
         * add 할때 rear값을 계속 증가시킨다.
         * 증가시킨 값은 데이터가 저장된 다음 인덱스를 가리킨다.
         * 다음 데이터를 저장시킬 위치보다 1칸 더 뒤의 공간이 front와 일치한다면
         * 현재 데이터가 포화상태 인 것이다.
         *
         * front는 가장 첫 위치에 존재하는 데이터 위치 이므로
         * 다음 데이터가 저장할 공간보다 한칸 뒤 공간이 front 위치와 일치하면 데이터가 포화상태인것..
         * (왜 이런 논리가 나오는 걸까?)
         */
        return (this.rear + 1) % queueSize == this.front;
    }

    @Override
    public void add(char item) {
        if(isFull()) throw new RuntimeException("큐가 꽉 찼습니다. 더이상 데이터를 추가할 수 없습니다.");
        this.queueArr[rear] = item; // 마지막에 데이터 삽입
        rear++;
        rear = (rear) % this.queueSize;
        System.out.println("rear = " + rear);
    }

    @Override
    public char poll() {
        if(isEmpty()) throw new RuntimeException("큐가 비어있습니다. 데이터를 삭제할 수 없습니다.");
//        if(front == rear) clear();
        char temp = queueArr[front];
        front++;
        front = front % this.queueSize;
        return temp;
//        return this.queueArr[++front];// 요소 삭제 전 front값을 1 증가시킴
    }

    @Override
    public char peek() {
        return this.queueArr[front];
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public long size() {
       return (rear - front);
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", queueSize=" + queueSize +
                ", queueArr=" + Arrays.toString(queueArr) +
                '}';
    }
}
