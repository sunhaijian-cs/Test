package algo.lc;

import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/29
 * @Description:
Problem
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
Note: Do not use the eval built-in library function.

 **/
public class Basic_Calculator_III_772 {

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
