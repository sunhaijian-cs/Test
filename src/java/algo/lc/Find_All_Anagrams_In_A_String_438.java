package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/9
 * @Description:
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".



 **/
public class Find_All_Anagrams_In_A_String_438 {
    @Test
    public void test(){
        String s="cbaebabacd";
        String p="abc";
        System.out.println(JSON.toJSONString(findAnagrams(s,p)));

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character,Integer> need=new HashMap();
        Map<Character,Integer> window=new HashMap();
        for(char c:p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left=0, right=0;
        int isValid=0;

        while(right<s.length()){
            char c=s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    isValid++;
                }
            }

            while(isValid==need.size()){
                if(right-left==p.length()){
                    result.add(left);
                }
                char rc=s.charAt(left);
                left++;
                if(need.containsKey(rc)){
                    if(need.get(rc).equals(window.get(rc))){
                        isValid--;
                    }
                    window.put(rc,window.getOrDefault(rc,0)-1);
                }
            }
        }
        return result;
    }

}
