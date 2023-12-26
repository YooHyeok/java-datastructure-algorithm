package datastructure.non_liner_structure.queue;

public interface Queue {
    boolean isEmpty();
    boolean isFull();
    void add(char item); //가장 마지막(rear)에 데이터 삽입(rear에는 삽입만 발생한다.)
    char poll(); //가장 처음(front)에 위치한 데이터 반환 후 큐에서 삭제(front에서는 삭제만 발생한다.)
    char peek(); // 가장 처음(front)에 위치한 데이터를 단순 출력(반환)만 하는 연산
    void clear();
    long size();
}
