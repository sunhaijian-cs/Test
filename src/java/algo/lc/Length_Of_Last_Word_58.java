package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/9/15
 * @Description:
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 **/
public class Length_Of_Last_Word_58 {
    public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }

        int res=0;
        int start=s.length()-1;
        while(start>=0&&s.charAt(start)==' '){
            start--;
        }

        for(int i=start;i>=0;i--){
            if(s.charAt(i)==' '){
                return res;
            }
            res++;
        }
        return res;

    }
}
