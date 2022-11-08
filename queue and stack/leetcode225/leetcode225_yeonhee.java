package stack_queue;

import java.util.ArrayList;

class MyStack {

    ArrayList<Integer> arr;
    public MyStack() {
        this.arr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);
    }

    public int pop() {
        return arr.remove(arr.size()-1);
    }

    public int top() {
        return arr.get(arr.size()-1);
    }

    public boolean empty() {
        return arr.isEmpty();
    }
}

public class leetcode225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());

    }
}
