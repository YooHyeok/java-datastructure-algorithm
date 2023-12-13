package datastructure.list.linkedList;

public class LinkedList {

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);

        if(this.head == null) {
            this.head = newNode;
            return;
        }

        ListNode tempNode = this.head;
        while(tempNode.pointer!= null) {
            tempNode = tempNode.pointer;
        }

        tempNode.pointer = newNode;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
}
