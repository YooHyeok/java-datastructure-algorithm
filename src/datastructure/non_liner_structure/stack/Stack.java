package datastructure.non_liner_structure.stack;

/**
 * pop : 스택의 가장 최상위(마지막) 위치의 데이터를 추출한 후 스택에서 삭제
 * push : 스택의 가장 최상위(마지막) 위치에 데이터를 삽입
 * isEmpty : 스택이 empty 상태인지 확인
 * clear : 스택에 저장된 모든 데이터를 삭제하고 스택을 초기화
 * peek : 스택의 가장 최상위(마지막) 위치의 데이터를 추출 - pop 메서드와는 달리 스택에서 데이터를 삭제하지 않음
 */
public interface Stack {
    boolean isEmpty();
    boolean isFull();
    void push(char item);
    char pop();
    char peek();
    void clear();
}
