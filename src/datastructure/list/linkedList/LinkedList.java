package datastructure.list.linkedList;

public class LinkedList {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    /**
     * 노드 삽입 메소드 <br/>
     * (가장 마지막에 삽입)
     * @param data
     * @return LinkedList : 노드 중간삽입시 이전노드 데이터로 사용된다.
     */
    public LinkedList insertNode(String data) {
        ListNode newNode = new ListNode(data); // 새 노드 객체 데이터 추가 및 생성

        if(this.head == null) { // 현재 노드가 비어있다면 단일계층(하위 참조 노드가 null) 신규 노드를 바로 추가
            this.head = newNode;
            return this;
        }

        ListNode tempNode = this.head; /* 현재 노드를 기준으로 마지막 노드까지 탐색하기 위해 임시 노드로 추출 */

        /* 현재 노드의 하위 노드가 비어있을때 까지(마지막노드까지) 탐색*/
        while(tempNode.pointer!= null) {
            tempNode = tempNode.pointer; /* 임시 노드를 다음계층의 노드로 초기화 */
        }

        tempNode.pointer = newNode;// 마지막 노드의 null을 새 노드 객체로 초기화
        return this;
    }

    /**
     * 노드 중간 삽입 메소드 <br/>
     * 노드와 노드간의 연결을 끊고 중간에 삽입한다.
     * 예를들어 노드2와 노드3 사이에 데이터를 넣는다.
     * 노드3의 데이터를 삽입할 새 노드의 pointer노드에 저장하고
     * 이전 노드의 pointer(노드3이 저장됨)노드 참조 변수에 
     * 노드3에 대한 참조작업 완료된 새 노드로 초기화한다. 
     * @param prevNode : 삽입 후의 이전노드가 될 노드
     * @param data : 링크드 리스트에 새로 삽입할 노드에 저장할 데이터
     * @return LinkedList : 노드 중간삽입시 이전노드 데이터로 사용된다.
     */
    public LinkedList insertNode(ListNode prevNode, String data) {
        ListNode newNode = new ListNode(data);
        newNode.pointer = prevNode.pointer; // 이전노드의 pointer 즉, node3의 데이터를 신규 노드의 다음노드로 저장한다.
        prevNode.pointer = newNode; // 신규노드를 이전노드의 포인터로 다시 저장한다 (원래 node3이 저장되어 있었음)
        return this;
    }

    /**
     * 노드 삭제 메소드 <br/>
     * (가장 마지막 노드를 삭제)
     */
    public void deleteNode() {

        ListNode prevNode = null;
        ListNode tempNode = this.head; /* 현재 노드를 기준으로 마지막 노드까지 탐색하기 위해 임시 노드로 추출 */

        if (this.head == null) { //현재 노드가 비어있다면 size 0이므로 삭제불가 -> return
            return;
        }

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
            this.head = null;
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

    public ListNode getHead() {
        return head;
    }

    /**
     * 출력시 배열에 담긴 문자열 형태로 출력하기 위한 toString 메소드 구현
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode tempNode = this.head;
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
