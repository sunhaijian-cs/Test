package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/23
 * @Description:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]


 **/
public class Generate_Parentheses_22 {

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(generateParenthesis(3)));

    }

    public List<String> generateParenthesis(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        List<String> res=new ArrayList<>();
        String track=new String();
        backtrack(n,n,track,res);

        return res;
    }

    void backtrack(int left, int right,
                   String track, List<String> res) {
        if(right<left) {
            return;
        }
        if(left<0|right<0){
            return ;
        }
        if(left==0&&right==0){
            res.add(track);
            return ;
        }

        track=track.concat("(");
        backtrack(left - 1, right, track, res);
        track=track.substring(0,track.length()-1);

        track=track.concat(")");
        backtrack(left , right-1, track, res);
        track=track.substring(0,track.length()-1);



    }

}
