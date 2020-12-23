package algo.lc;

import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/29
 * @Description:
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 **/
public class Basic_Calculator_II_227 {

    static int i =0;
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();

        int num=0;
        char sign='+';

        for ( ; i < s.length(); i++) {
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=10*num+(c-'0');
            }
            if(c=='('){
                i++;
                num=calculate(s);
            }
            if((!Character.isDigit(c)&&c!=' ')||i==s.length()-1){
                switch(sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre=stack.pop();
                        stack.push(pre*num);
                        break;
                    case '/':
                        pre=stack.pop();
                        stack.push(pre/num);
                        break;
                }
                sign=c;
                num=0;
            }

            if(c==')'){
                break;
            }
        }


        if(i==s.length()){
            i=0;
        }

        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
