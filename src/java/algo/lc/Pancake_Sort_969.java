package algo.lc;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/21
 * @Description:
 *Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.



Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.


Note:

1 <= A.length <= 100
A[i] is a permutation of [1, 2, ..., A.length]

 **/
public class Pancake_Sort_969 {
    static List<Integer> res;



    @Test
    public void test(){
        int[] A={3,2,4,1};
        pancakeSort(A);

        System.out.println(JSONObject.toJSONString(res));
        System.out.println(JSONObject.toJSONString(A));
    }

    /**
     * 注意 加到res 的时候要加1
     * @param A
     * @return
     */
    public List<Integer> pancakeSort(int[] A) {
        res=new ArrayList<>();
        sort(A,A.length-1);

        return res;


    }

    void sort(int[] A,int n){

        for (int i = n; i >0 ; i--) {

            int index=findMax(A,i);
            if(index==i){
                continue;
            }else if (index==0) {

                res.add(i);
                reverse(A,0,i);
            }else {
                    res.add(index);
                    reverse(A,0,index);

                    res.add(i);
                    reverse(A,0,i);

                }
            }

    }

    void reverse(int[] A, int i, int j) {
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++; j--;
        }
    }

    public int findMax(int [] A,int n ){
        int maxN=Integer.MIN_VALUE;
        int maxI=0;

        for (int i = 0; i <= n; i++) {
            if(A[i]>maxN){
                maxN=A[i];
                maxI=i;
            }
        }
        return maxI;
    }


    /**
     * 官方答案  效率还没上面的高呢
     * @param A
     * @return
     */
    public List<Integer> pancakeSort2(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i) {
            B[i] = i + 1;
        }
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans) {
                if (i <= f) {
                    i = f + 1 - i;
                }
            }
            ans.add(i);
            ans.add(N--);
        }

        return ans;



    }


}
