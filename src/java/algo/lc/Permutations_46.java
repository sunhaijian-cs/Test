package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/2
 * @Description:
 **/
public class Permutations_46 {

    @Test
    public void test(){
        int[] nums={1,2,3};
        List<List<Integer>> res=permute(nums);
        System.out.println(JSON.toJSONString(res));

    }

    List<List<Integer>> result=new LinkedList();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList();
        backTrack(nums,track);

        return result;
    }

    void backTrack(int[] nums ,LinkedList<Integer>  track){

        if(track.size()==nums.length){
            result.add(new LinkedList(track));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track);
            track.removeLast();
        }
        return;


    }

}
