package algo.lc;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/15
 * @Description:
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
这个题本身不复杂，但是处理方法如果用的不合适，会比较麻烦。
一个最需要注意的点：循环相加的时候，最好循环到最长的那个数字处理完为止。不然循环之后还要有额外的处理，代码会显得比较臃肿。
Ps：记得处理完之后判断进位符有没有值，有的话，也要添加到result里

 **/
public class Add_Two_Numbers_2 {
    public static void main(String[] args) {

        List<Integer> num1=new LinkedList(){{
            add(2);
            add(4);
            add(3);
            add(9);
            add(9);
        }};
        List<Integer> num2=new LinkedList(){{
            add(5);
            add(6);
            add(4);
            add(4);
        }};

        List<Integer> result =addTwoNumbers(num1,num2);

        System.out.println(JSONObject.toJSONString(result));


    }

    private static List<Integer> addTwoNumbers(List<Integer> num1, List<Integer> num2) {

        if(num1.size()==0){
            return num2;
        }
        if(num2.size()==0){
            return num1;
        }
        List<Integer> result=new LinkedList();
        int n=0;

        int carried=0;
        while(n<num1.size()||n<num2.size()){
            int n1=n<num1.size()?num1.get(n):0;
            int n2=n<num2.size()?num2.get(n):0;
            int temp =(carried+n1+n2)%10;
            result.add(temp);
            carried=(carried+n1+n2)/10;
            n++;
        }

        if(carried>0){
            result.add(carried);
        }
    return result;

    }
}
