package algo.lc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/9
 * @Description:
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

ps.划窗的变种。

 **/
public class Longest_Substring_Without_Repeating_Characters_3 {

    @Test
    public void test(){
        String s="abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window=new HashMap();


        int left=0,right=0;

        int len=0;

        while(right<s.length()){
            char c=s.charAt(right);
            right++;

            if(window.containsKey(c)){
                while(window.containsKey(c)){
                    char lc=s.charAt(left);
                    left++;
                    window.put(lc,window.getOrDefault(lc,0)-1);
                    if(window.get(lc).equals(0)){
                        window.remove(lc);
                    }
                }
                window.put(c,window.getOrDefault(c,0)+1);


            }else{
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.size()>len){
                    len=window.size();
                }
            }

        }

        return len;
    }
}
