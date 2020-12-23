package algo.lc;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/21
 * @Description:
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 **/
public class Multiply_String_43 {

@Test
public void test(){

    String num1="408";
    String num2="5";
    System.out.println(multiply2(num1,num2));;
}

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 结果最多为 m + n 位数
        int [] res=new int [m + n];
        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 乘积在 res 对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                // 叠加到 res 上
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        System.out.println(JSONObject.toJSONString(res));

        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        // 将计算结果转化成字符串
        String str=new String();
        for (; i < res.length; i++) {
            str += String.valueOf(res[i]);
        }

        return str.length() == 0 ? "0" : str;
    }



    public String multiply2(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int n1=num1.length(),n2=num2.length();
        int [] arr =new int[n1+n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int t1=num1.charAt(i)-'0';
                int t2=num2.charAt(j)-'0';
                arr[n1+n2-2-i-j]+=t1*t2;
            }
        }
        int carry=0;
        StringBuilder strB=new StringBuilder();

        int maxCount=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0){
                maxCount=i;
            }else{
                break;
            }
        }
        for(int i=0;i<maxCount;i++){

            if((arr[i]+carry)>9){
                strB.append((arr[i]+carry)%10);
                carry=(arr[i]+carry)/10;
            }else{
                strB.append(arr[i]+carry);
                carry=0;
            }
        }
        while(carry>0){
            strB.append(carry%10);
            carry/=10;
        }
        return strB.reverse().toString();
    }
}
