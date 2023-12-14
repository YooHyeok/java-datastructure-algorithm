package datastructure.list.linkedList;

public class LinkedList {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    /**
     * Node 삽입 메소드 <br/>
     * (가장 마지막에 삽입)
     * @param data
     */
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data); // 새 노드 객체 데이터 추가 및 생성

        if(this.head == null) { // 현재 노드가 비어있다면 단일계층(하위 참조 노드가 null) 신규 노드를 바로 추가
            this.head = newNode;
            return;
        }

        ListNode tempNode = this.head; /* 현재 노드를 기준으로 마지막 노드까지 탐색하기 위해 임시 노드로 추출 */

        /* 현재 노드의 하위 노드가 비어있을때 까지(마지막노드까지) 탐색*/
        while(tempNode.pointer!= null) {
            tempNode = tempNode.pointer; /* 임시 노드를 다음계층의 노드로 초기화 */
        }

        tempNode.pointer = newNode;// 마지막 노드의 null을 새 노드 객체로 초기화
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
