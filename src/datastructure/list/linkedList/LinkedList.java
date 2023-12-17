package datastructure.list.linkedList;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedList {

    private ListNode headNode; // 가장 최초의 노드

    public LinkedList() {
        headNode = null;
    }

    /**
     * 노드 삽입 메소드 <br/>
     * (가장 마지막에 삽입)
     * @param data
     * @return newNode 주소값 : 노드 중간삽입시 이전노드 데이터로 사용된다.
     */
    public String insertNode(String data) {
        ListNode newNode = new ListNode(data); // 새 노드 객체 데이터 추가 및 생성

        if(this.headNode == null) { // 현재 노드가 비어있다면 단일계층(하위 참조 노드가 null) 신규 노드를 바로 추가
            this.headNode = newNode;
            return newNode.getAddressValue();
        }

        ListNode tempNode = this.headNode; /* 현재 노드를 기준으로 마지막 노드까지 탐색하기 위해 임시 노드로 추출 */

        /* 현재 노드의 하위 노드가 비어있을때 까지(마지막노드까지) 탐색*/
        while(tempNode.pointer!= null) {
            tempNode = tempNode.pointer; /* 임시 노드를 다음계층의 노드로 초기화 */
        }

        tempNode.pointer = newNode;// 마지막 노드의 null을 새 노드 객체로 초기화
        return newNode.getAddressValue();
    }

    /**
     * 노드 중간 삽입 메소드 <br/>
     * 노드와 노드간의 연결을 끊고 중간에 삽입한다.
     * 예를들어 노드2와 노드3 사이에 데이터를 넣는다.
     * 노드3의 데이터를 삽입할 새 노드의 pointer노드에 저장하고
     * 이전 노드의 pointer(노드3이 저장됨)노드 참조 변수에 
     * 노드3에 대한 참조작업 완료된 새 노드로 초기화한다. 
     * @param prevPointer : 삽입 후의 이전노드가 될 노드의 주소값
     * @param data : 링크드 리스트에 새로 삽입할 노드에 저장할 데이터
     * @return LinkedList : 노드 중간삽입시 이전노드 데이터로 사용된다.
     */
    public String insertNode(String prevPointer, String data) {
        ListNode prevNode = searchNode(prevPointer);
        ListNode newNode = new ListNode(data);
        newNode.pointer = prevNode.pointer; // 이전노드의 pointer 즉, node3의 데이터를 신규 노드의 다음노드로 저장한다.
        prevNode.pointer = newNode; // 신규노드를 이전노드의 포인터로 다시 저장한다 (원래 node3이 저장되어 있었음)
        return newNode.getAddressValue();
    }

    /**
     * 노드 삭제 메소드 <br/>
     * (가장 마지막 노드를 삭제)
     */
    public void deleteNode() {

        ListNode prevNode = null;
        ListNode tempNode = this.headNode; /* 현재 노드를 기준으로 마지막 노드까지 탐색하기 위해 임시 노드로 추출 */

        if(this.headNode == null) throw new RuntimeException("리스트에 데이터가 존재하지 않습니다.");

//        if (this.headNode == null) { //현재 노드가 비어있다면 size 0이므로 삭제불가 -> return
//            return;
//        }

        /* 현재 노드의 하위 노드가 비어있을때 까지(마지막노드까지) 탐색*/
        while(tempNode.pointer != null) {
            prevNode = tempNode; /* 다음 노드를 찾으면서 직전 노드를 저장한다. */
            tempNode = tempNode.pointer; /* 임시 노드를 다음계층의 노드로 초기화 */
        }

        /**
         * prevNode가 null이라면 while문이 한번도 실행되지 않았다.
         * 따라서 size가 1인 상태 이므로 현재 노드를 지운다.
         */
        if (prevNode == null) {
            this.headNode = null;
            return;
        }

        /**
         * size가 2 이상인 상태 이므로
         * prevNode는 loop에서 마지막 노드를 찾을때 직전 노드를 임시로 저장하기 위해 사용한다.
         * 임시로 저장한 이유는 마지막 노드인 tempNode는 참조변수이므로 지울수가 없으므로
         * 이전노드의 pointer에 접근함으로써 마지막노드를 지우기 위함이다.
         */
        prevNode.pointer = null;
    }

    /**
     * 중간 노드 삭제 메소드
     * 객체는 동등비교로 찾아가지만
     * String은 가장 첫 문자를 기준으로 삭제한다
     * 자바 컬렉션에서도 위처럼 동작한다. (String은 주소값을 찾을수 없음)
     */
    public void deleteNode(String data) {
        ListNode prevNode = this.headNode;
        ListNode tempNode = this.headNode.pointer;

        /**
         * 첫번째 노드 데이터 일치 검사
         */
        if(data.equals(prevNode.getData())) {// 현재 시점인 prevNode 데이터(첫번째 데이터)와 받은 데이터가 일치할 경우
            prevNode.pointer = null; // prevNode의 pointer에 null을 할당하여 연결을 끊는다.
            // (prev는 delete시 다시 초기화되므로 굳이 연결을 끊지 하지않아도 아래의 headNode초기화에 의해 삭제는되지만 링크가 연결되있기 때문에 논리상 값을 저장하기 전 먼저 끊는게 맞음)
            this.headNode = tempNode; // 현재(최초) 노드가  prevNode의 다음노드를 참조하도록 한다.
            return;
        }

        /**
         * 두번째 노드부터 데이터 일치 검사
         */
        while(tempNode != null) {
            if (data.equals(tempNode.getData())) { // 현재 노드의 데이터가 일치하면
                if (tempNode.pointer == null) { // 마지막노드일 경우
                    prevNode.pointer = null; // 이전노드를 통해 마지막 노드에 접근 후 제거
                    return;
                }
                //마지막 노드가 아닌 경우
                prevNode.pointer = tempNode.pointer; // 다음노드에
                tempNode.pointer = null;
                return;
            }
            prevNode = tempNode;
            tempNode = tempNode.pointer;
        }
        return;
    }

    /**
     * String타입 주소값으로 Node 탐색
     * @return
     */
    public ListNode searchNode(String headAddress) {
        ListNode tempNode = this.headNode;

        while(tempNode != null) {
            if(headAddress.equals(tempNode.getAddressValue())) {
                return tempNode;
            }
            tempNode = tempNode.pointer;
        }
        return tempNode;
    }

    /**
     * 출력시 배열에 담긴 문자열 형태로 출력하기 위한 toString 메소드 구현
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode tempNode = this.headNode;
        sb.append("[");
        while(tempNode != null) {
            sb.append(tempNode.getData());
            tempNode = tempNode.pointer;
            if(tempNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
//        return "LinkedList{head=" + head +'}';
    }
}
