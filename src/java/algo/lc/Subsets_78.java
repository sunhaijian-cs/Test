package algo.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/17
 * @Description:
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]

https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/zi-ji-pai-lie-zu-he
 **/
public class Subsets_78 {

    static List<List<Integer>> res=new ArrayList();


    public List<List<Integer>> subsets(int[] nums) {
        res=new LinkedList();

        List<Integer> list=new ArrayList();
        backTrack(nums,0,list);

        return res;
    }

    public void backTrack(int[] nums,int start,List<Integer> list){
        res.add(new ArrayList(list));

        for(int i=start;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums,i+1,list);
            list.remove(list.size()-1);
        }
        return ;
    }
}
