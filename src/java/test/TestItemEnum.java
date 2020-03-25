package test;

import org.junit.Test;

import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/3/20
 * @Description:
 **/
public class TestItemEnum {



    @Test
    public void  testEnum(){

        List<String> ss=GoodsItem.getNameList();

        System.out.println(ss.size());



    }
}
