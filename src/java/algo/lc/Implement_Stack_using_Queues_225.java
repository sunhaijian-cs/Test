package algo.lc;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/29
 * @Description:
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 **/
public class Implement_Stack_using_Queues_225 {

    @Test
    public void test(){
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());;   // returns 2
        System.out.println( stack.pop());;   // returns 2
        System.out.println(stack.empty());; // returns false
    }
}


class MyStack {

    private Queue<Integer> q;
    private Integer top_elem=null;
    /** Initialize your data structure here. */
    public MyStack() {
        q=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);

        top_elem=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size=q.size();
        while (size>2){
            q.offer(q.poll());
            size--;
        }
        top_elem=q.peek();
        q.offer(q.poll());
        return q.poll();

    }

    /** Get the top element. */
    public int top() {
        return top_elem;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}