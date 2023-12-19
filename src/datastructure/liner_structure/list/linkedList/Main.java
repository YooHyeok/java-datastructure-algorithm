package datastructure.liner_structure.list.linkedList;

import datastructure.liner_structure.list.linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        Object strobj = new String("12312");
        LinkedList linkedList = new LinkedList();

        /* 리스트 마지막에 첫번째 데이터 삽입 */
        String firstNodeAddress = linkedList.insertNode("First Data");
        System.out.println("linkedList = " + linkedList);
        /* 리스트 마지막에 두번째 데이터 삽입 */
        linkedList.insertNode("Third Data");
        System.out.println("linkedList = " + linkedList);

        /* 첫번째 데이터의 노드 정보를 넘긴 후 중간에 삽입 */
        linkedList.insertNode(firstNodeAddress, "Second Data");
        linkedList.insertNode("4 Data");
        String headAddress = linkedList.insertNode("5 Data");
        linkedList.insertNode("6 Data");
        linkedList.insertNode("7 Data");
        String str = new String("12312");
//        String s = linkedList.insertNode(headAddress, "12312");
        String s = linkedList.insertNode(headAddress, str);
        linkedList.insertNode("7 Data");
        linkedList.insertNode(s,"6 Data");
        System.out.println("linkedList = " + linkedList);
        linkedList.deleteNode("First Data");
        linkedList.deleteNode(str);
        linkedList.deleteNode("Third Data");


//        linkedList.deleteNode("12312");
        System.out.println("linkedList = " + linkedList);
    }
}
