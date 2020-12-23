package algo.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/18
 * @Description:
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/qu-jian-jiao-ji-wen-ti
 **/
public class Interval_List_Intersections_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;

        int rows=Math.min(A.length,B.length);
//        int[][] res=new int [rows][2];

        List<int []> res=new ArrayList();
        while(i<A.length&&j<B.length){
            int a1=A[i][0],a2=A[i][1];
            int b1=B[j][0],b2=B[j][1];

            if(b1>a2||a1>b2){
//                不相交
            }else{
                int t1=Math.max(a1,b1);
                int t2=Math.min(a2,b2);
                res.add(new int[]{t1,t2});
            }
            if(b2>a2){
                i++;
            }else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
