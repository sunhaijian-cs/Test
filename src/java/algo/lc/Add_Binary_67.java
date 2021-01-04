package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/23
 * @Description:
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


 虽然是简单题，但是错了好多次

 **/
public class Add_Binary_67 {

    @Test
    public void test(){
        String a="1010";
        String b="1011";
        char [] longChars= a.toCharArray();

        System.out.println( longChars[0]);



        System.out.println( addBinary(a,b));

    }

    public String addBinary(String a, String b) {

       char [] longChars;
       char [] shortChars;

       if(a.length()>b.length()){
            longChars= a.toCharArray();
            shortChars= b.toCharArray();
       }else{
           longChars= b.toCharArray();
           shortChars= a.toCharArray();
       }

       int  carry=0;
        for(int i=longChars.length-1,j=shortChars.length-1;i>=0;i--,j--){

            int temp;
            if(j>=0) {
                temp = longChars[i]-'0' +shortChars[j]-'0' + carry;
        }else{
            temp =  longChars[i]-'0' + carry;
        }
        longChars[i]=(char)(temp%2+'0');
        if(temp>=2){
            carry=1;
        }else{
            carry=0;
        }
       }

       if(carry==0){
           return  String.valueOf(longChars);
       }else{
           return "1"+ String.valueOf(longChars);
       }

    }

}
