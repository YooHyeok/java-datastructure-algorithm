package datastructure.non_liner_structure.stack;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(5);
        System.out.println("arrayStack = " + arrayStack);
        arrayStack.push('2');
        System.out.println("arrayStack = " + arrayStack);
        arrayStack.push('=');
        System.out.println("arrayStack = " + arrayStack);
        arrayStack.push('1');
        System.out.println("arrayStack = " + arrayStack);
    }
}
