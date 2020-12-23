package algo.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/17
 * @Description:
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]

https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/zi-ji-pai-lie-zu-he
 **/
public class Combinations_77 {

    static List<List<Integer>> res=new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        if(k>n){
            return null;
        }
        res=new ArrayList();

        List<Integer> list =new ArrayList();
        int [] nums=new int [n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        backTrack(nums,k,list,0);
        return res;

    }

    public void backTrack(int [] nums,int k,List<Integer> list,int start){
        if(list.size()==k){
            res.add(new ArrayList(list));
            return ;
        }
        for(int i=start;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums,k,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
