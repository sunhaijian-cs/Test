import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description:
 **/
public class Test {


    @org.junit.Test
    public void test2(){


        String s="";
        String []ss =s.split(" ");

        System.out.println(reverseWords(s));





//        LinkedBlockingDeque queue=new LinkedBlockingDeque();
//        List<Integer> res = new LinkedList<>();
//
//
//        System.out.println(Character.isDigit('1'));
//        System.out.println(Character.isLetter('a'));
//        System.out.println(Character.isLetter('z'));
//
//        System.out.println((true) ? "" :"1");
//        System.out.println(1%2);
//        System.out.println(2%1);
    }


    public String reverseWords(String s) {
        String [] strs=s.split(" ");
        StringBuffer res=new StringBuffer();
        for(int i=strs.length-1;i>=0;i-- ){
            if(strs[i]!=null&&!strs[i].equals("")&&strs[i]!= " "){
                res.append(strs[i]+" ");
            }
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();



    }

    @org.junit.Test
    public void test(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0,3);


        System.out.println(JSON.toJSONString(list));


//        list.remove()






//        for (int i = 0; i <100 ; i++) {
////            System.out.println(new Double(Math.random()*10%7).intValue());
////            System.out.println( new Random().nextInt(5));
//            System.out.println( new Random().ints(1,4));
//        }




    }





    public static void main(String[] args) {

        Person p1 = new Person();
            p1.sss="1";

                System.out.println(p1.sss);
                change(p1);
               System.out.println(p1.sss);
    }

    public static void change(Person p2) {
//                p2 = new Person();
        p2.sss="2";

    }


}
class Person {


    String sss;
}