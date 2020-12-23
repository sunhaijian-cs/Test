package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/11
 * @Description:
 **/
public class Sort_Colors_75 {
    @Test
    public void test(){
        int [] nums={2,0,2,1,1,0};

        System.out.println(JSON.toJSONString(nums));
        sortColors(nums);
        System.out.println(JSON.toJSONString(nums));

    }

    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]<nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
}
