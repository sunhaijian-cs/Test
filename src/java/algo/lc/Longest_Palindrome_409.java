package algo.lc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/14
 * @Description:
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 **/
public class Longest_Palindrome_409 {
    public int longestPalindrome(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Iterator<Character> it=map.keySet().iterator();
        int count=0;
        while(it.hasNext()){
            if(map.get(it.next())%2!=0){
                count++;
            }
        }

        if(count<2){
            return s.length();
        }else{
            return s.length()-count+1;
        }

    }
}
