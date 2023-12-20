package datastructure.non_liner_structure.stack;

import java.util.AbstractCollection;
import java.util.Arrays;

public class ArrayStack implements Stack{
    
    private int top; // Stack의 포인터
    private int stackSize; // Stack 사이즈 
    private char stackArr[]; // 스택 배열

    /**
     * 스택을 생성하는 생성자
     * 포인터, 사이즈. 배열 초기화
     * @param stackSize
     */
    public ArrayStack(int stackSize) {
        top = -1; //스택 포인터 초기화
        this.stackSize = stackSize; //스택 사이즈 설정
        stackArr = new char[this.stackSize]; //스택 배열 생성
    }

    /**
     * 스택이 비어있는지 상태 확인
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return top == -1; // 스택 포인터가 -1인 경우 데이터가 없는 상태 (인덱스는 0부터 시작하므로)
    }

    /**
     * 스택이 꽉 차있는지 상태 확인
     * @return boolean
     */
    @Override
    public boolean isFull() {
        return top == this.stackSize-1; // 스택의 사이즈가 스택의 마지막 인덱스와 일치할 경우 데이터가 꽉 찬 상태
    }

    /**
     * 추가 <br/>
     * 스택에 데이터를 추가
     * @param item
     */
    @Override
    public void push(char item) {
        if(isFull()) throw new RuntimeException("배열의 크기를 초과했습니다. 더이상 데이터를 추가할수 없습니다.");
        this.stackArr[++top] = item; // 탑 포인터를 1 증가시킨 후 저장해야 하므로 전위증감+연산
    }



    /**
     * 출력 및 삭제 <br/>
     * 스택에서 top 포인터가 가리키는 데이터를 출력하고 삭제
     * @return
     */
    @Override
    public char pop() {
        if(isEmpty()) throw new RuntimeException("스택에 데이터가 존재하지 않습니다. 데이터를 추출할 수 없습니다.");
        return this.stackArr[top--]; // 현재 위치의 데이터를 출력후 해당 데이터를 제거하므로 후위증감-연산
        // 후위 증감 - 연산하게되면 포인터의 위치가 아래로 내려가므로 데이터가 완벽하게 삭제되지 않았더라도
        // 다음 pop시 덮어쓰게된다
    }

    /**
     * 출력 <br/>
     * 스택에서 top 포인터가 가리키는 데이터를 단순히 출력
     * @return
     */
    @Override
    public char peek() {
        if(isEmpty()) throw new RuntimeException("스택에 데이터가 존재하지 않습니다. 데이터를 추출할 수 없습니다.");
        return this.stackArr[top];
    }

    /**
     * 전체 삭제
     */
    @Override
    public void clear() {
        if(isEmpty()) throw new RuntimeException("스택에 데이터가 존재하지 않습니다. 데이터를 추출할 수 없습니다.");
        top = -1;
        stackArr = new char[this.stackSize]; // 새 스택 배열 생성 후 초기화
    }

}
