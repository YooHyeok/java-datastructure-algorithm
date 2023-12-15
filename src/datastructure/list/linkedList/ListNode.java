package datastructure.list.linkedList;


public class ListNode {
    private String data; //데이터 저장 변수
    private String addressValue = super.toString(); // 주소값을 저장
    public ListNode pointer; //다음 노드를 참조할 pointer 변수
    public ListNode() {
        this.data = null;
        this.pointer = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.pointer = null;
    }

    public ListNode(String data, ListNode pointer) {
        this.data = data;
        this.pointer = pointer;
    }

    public String getData() {
        return this.data;
    }

    public String getAddressValue() {
        return this.addressValue;
    }
}
