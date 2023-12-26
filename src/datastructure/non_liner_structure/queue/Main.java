package datastructure.non_liner_structure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Queue queue = new ArrayCircleQueue(5);
        System.out.println("queue = " + queue);
        queue.add('a');
        System.out.println("queue = " + queue);
        queue.add('b');
        System.out.println("queue = " + queue);
        queue.add('c');
        System.out.println("queue = " + queue);
        queue.add('d');
        System.out.println("queue = " + queue);
        queue.add('e');
        System.out.println("queue = " + queue);

        char poll1 = queue.poll();
        System.out.println("poll = " + poll1);
        System.out.println("size = " + queue.size());
        char poll2 = queue.poll();
        System.out.println("poll = " + poll2);
        System.out.println("queue = " + queue);

        char poll3 = queue.poll();
        System.out.println("poll = " + poll3);
        System.out.println("queue = " + queue);
        char poll4 = queue.poll();
        System.out.println("poll = " + poll4);
        System.out.println("queue = " + queue);
        char poll5 = queue.poll();
        System.out.println("poll = " + poll5);
        System.out.println("queue = " + queue);
        queue.add('f');
        System.out.println("queue = " + queue);
        queue.add('g');
        System.out.println("queue = " + queue);
        queue.add('h');
        System.out.println("queue = " + queue);
        queue.add('i');
        System.out.println("queue = " + queue);
        queue.add('j');
        System.out.println(queue.peek()); // 첫 데이터 f 출력되야한다.
        System.out.println("queue = " + queue);
        queue.add('k');
        System.out.println("queue = " + queue);
    }
}
