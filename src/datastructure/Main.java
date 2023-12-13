package datastructure;

import datastructure.list.linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode("First Data");
        System.out.println("linkedList = " + linkedList);
        linkedList.insertNode("Second Data");
        System.out.println("linkedList = " + linkedList);
    }
}
