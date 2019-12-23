package algo.other.stack;





import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2019/12/9
 * @Description:
 **/
public class BracketMatch {

    public static void main(String[] args) {
        String brackets="()()(()()()))";

        System.out.println(check(brackets));


    }

    private static boolean check(String brackets) {

        if(StringUtils.isBlank(brackets)){
            return true;

        }

        Stack<Character> bracStack=new Stack();
       char [] chars=  brackets.toCharArray();
        for (int i = 0; i <chars.length ; i++) {

            if('('==(chars[i])){
                bracStack.push(chars[i]);
            }else{
                if(bracStack.empty()){
                    return false;
                }else{
                    bracStack.pop();

                }
            }
        }



        return true;
    }
}
