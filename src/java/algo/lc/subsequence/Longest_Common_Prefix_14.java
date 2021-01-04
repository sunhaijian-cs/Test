package algo.lc.subsequence;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/15
 * @Description:
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

 **/
public class Longest_Common_Prefix_14 {
    @Test
    public void test(){
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String str1=strs[0];
        if(str1==null||str1.length()==0){
            return "";
        }
        if(strs.length==1){
            return str1;
        }
        int minComLen=Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            int comLen=0;
            while(strs[i]!=null
                    &&comLen<str1.length()
                    &&comLen<strs[i].length()
                    &&strs[i].charAt(comLen)==str1.charAt(comLen)){
                comLen++;

            }
            if(comLen<minComLen){
                minComLen=comLen;
            }
        }
        return (minComLen<=0||minComLen==Integer.MAX_VALUE) ? "" :str1.substring(0,minComLen);
    }
}
