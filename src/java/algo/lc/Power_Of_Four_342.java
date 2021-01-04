package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/4
 * @Description:
 **/
public class Power_Of_Four_342 {
    @Test
    public void test(){
        System.out.println( isPowerOfFour(16));

    }

    public boolean isPowerOfFour(int num) {
        if(num==1){
            return true;
        }
        if(num<0||num==0||num==2){
            return false;
        }

        while(num%4==0){
            num=num/4;
        }

        if(num==1){
            return true;
        }else{
            return false;
        }

    }
}
