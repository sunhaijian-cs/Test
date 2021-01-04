package algo.lc;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/14
 * @Description:
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 **/
public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        Set<Character> set=new HashSet();
        set.add('(');
        set.add('[');
        set.add('{');
        Deque<Character> queue =new LinkedList();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                queue.addFirst(s.charAt(i));
            }else{
                if(queue.size()==0){
                    return false;
                }
                Character c=queue.getFirst();
                if(c=='('&&s.charAt(i)==')'){
                    queue.removeFirst();
                }else if(c=='['&&s.charAt(i)==']'){
                    queue.removeFirst();
                }else if(c=='{'&&s.charAt(i)=='}'){
                    queue.removeFirst();
                }else {
                    return false;
                }
            }
        }
        if(queue.size()==0){
            return true;
        }else {
            return false;
        }
    }
}
