package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/19
 * @Description:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false


 **/
public class Valid_Palindrome_125 {

    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        s=s.toLowerCase();

        while(left<right){
            while(left<s.length()&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right>0&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(s.charAt(right--)!=s.charAt(left++)){
                return false;
            }
        }

        return true;


    }
}
