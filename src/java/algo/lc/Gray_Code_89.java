package algo.lc;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/22
 * @Description:
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
————————————————
版权声明：本文为CSDN博主「vincent-xia」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u012501459/article/details/46790683

 **/
public class Gray_Code_89 {

    @Test
    public void test(){

//        for (int i = 0; i < 10; i++) {
//            System.out.println(1<<i);
//        }


        System.out.println(JSONObject.toJSONString(grayCode2(2)));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList();
        result.add(0);
        for(int i=0;i<n;i++)
        {
            for(int j=result.size()-1;j>=0;j--)
            {
                result.add((1<<i)+result.get(j));
            }
        }
        return result;
    }


    /**
     * 数学方法
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> result=new ArrayList();
        for(int i=0;i<1<<n;i++)
        {
            result.add(i^i>>1);
        }
        return result;


    }







}
