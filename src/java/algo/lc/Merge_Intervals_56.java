package algo.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/18
 * @Description:
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

合并一共有两个想法：
1，建立一个last 每次循环如果需要合并到last里面，就合并，如果没办法合并到last中，则将last放到result，然后将当前的区间放到last中。
2，循环中嵌套循环，内循环处理所有的合并，内部循环结束，则放到result中。


 **/
public class Merge_Intervals_56 {
    public int[][] merge(int[][] intervals) {

        if(intervals.length==0){
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparing(a->a[0]));

        int [][] last=new int[1][2];
        last[0][0]=intervals[0][0];
        last[0][1]=intervals[0][1];
        int i=1;
        List<int []> res=new ArrayList();
        while(i<intervals.length){
            if(intervals[i][0]<=last[0][1] && intervals[i][1]>last[0][1]){
                last[0][1]=intervals[i][1];
            }
            if(intervals[i][0]>last[0][1]){
                res.add(new int []{ last[0][0], last[0][1]});
                last[0][0]=intervals[i][0];
                last[0][1]=intervals[i][1];
            }
            i++;

        }
        res.add(new int []{ last[0][0], last[0][1]});
        return res.toArray(new int [res.size()][]);
    }

}
