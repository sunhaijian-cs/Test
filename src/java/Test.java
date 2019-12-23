import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description:
 **/
public class Test {

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