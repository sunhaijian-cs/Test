package algo.lc;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/29
 * @Description:
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 **/
public class Implement_Queue_Using_Stacks_232 {

    @Test
    public void test(){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());;  // returns 1
        System.out.println(queue.pop());;   // returns 1
        System.out.println( queue.empty());;


    }


}

class MyQueue {

    private Stack<Integer> s1,s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        peek();
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&& s2.isEmpty();
    }
}