package algo.lc;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/29
 * @Description:
 *
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

 **/
public class Basic_Calculator_224 {
    @Test
    public void test(){
//        System.out.println(calculate("2 +3+5 *6"));
//        System.out.println(calculate2("((2 +3)+(5 *6))"));
        System.out.println(calculate2(" 2-1+2 "));
    }


    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();

        int num=0;
        char sign='+';

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=10*num+(c-'0');
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
        }

        int res=0;

        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

    static int i =0;
    public int calculate2(String s) {
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
                num=calculate2(s);
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
