package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/8
 * @Description:
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 **/
public class Permutation_In_String_567 {

    @Test
    public  void test(){
        String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1,s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();

        for (char c :s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

//        for (char c :s.toCharArray()) {
//            window.put(c, window.getOrDefault(c, 0) + 1);
//        }
//        System.out.println(JSON.toJSONString(window));
        int left =0,right=0;
        int valid=0;
        //记录最小覆盖子串的起始索引和长度
        int start=0,len=Integer.MAX_VALUE;
        int i=0;
        while(right<s2.length()){
//            c是将要移入窗口的字符
            char c=s2.charAt(right);
            //右移窗口
            right++;
//            进行窗口内数据的更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c) .equals(need.get(c)) ){
                    valid++;
                }
            }

//            System.out.println(11);
//            判断左侧窗口是否要收缩
            while (valid==need.size()){
//                再这里更新最小的覆盖子串
                if(right-left==s1.length()){
                    return true;


                }
//                d是将移出窗口的字符
                char d=s2.charAt(left);
//                左移窗口
                left++;
//                进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }

        }


        return false;
    }
}
