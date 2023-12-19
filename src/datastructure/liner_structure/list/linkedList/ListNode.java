package datastructure.liner_structure.list.linkedList;


public class ListNode implements Cloneable{
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

    /**
     * 깊은 복제 <br/>
     * 중간 데이터 삭제시 링크를 끊기 위해 복제를 한다. <br/>
     * 이때, 일반적인 얕은복제시, 주소값을 가지고있기 때문에 <br/>
     * Hierarchy한 특성을 가진 LinkedList의 각 Node를 깊은 복제를 한 뒤 <br/>
     * 복제한 객체에서 링크를 끊어버린다.
     * @return
     */
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData() {
        return this.data;
    }

    public String getAddressValue() {
        return this.addressValue;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data='" + data + '\'' +
                ", addressValue='" + addressValue + '\'' +
                ", pointer=" + pointer +
                '}';
    }

}
